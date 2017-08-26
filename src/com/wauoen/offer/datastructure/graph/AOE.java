package com.wauoen.offer.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AOE 关键路径
 * @author wauoen
 *
 */
public class AOE {
	Stack<Event> topoStack = new Stack<>();
	/**
	 * 节点集合
	 */
	List<Event> events = new ArrayList<>();
	
	public static void main(String args[]){
		
		AOE aoe = new AOE();
		aoe.buildAOE();
		try {
			aoe.CriticalPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 
	 * @return
	 */
	public Activity buildAOE(){
		//TODO 手动创建AOE
		
		Event v1 = new Event("v1",0,2);
		Event v2 = new Event("v2",1,2);
		Event v3 = new Event("v3",1,2);
		Event v4 = new Event("v4",2,1);
		Event v5 = new Event("v5",1,1);
		Event v6 = new Event("v6",3,0);
		
		events.add(v1);
		events.add(v2);
		events.add(v3);
		events.add(v4);
		events.add(v5);
		events.add(v6);
		
		Activity a1 = new Activity("a1",v1,v2,3);
		Activity a2 = new Activity("a2",v1,v3,2);
		Activity a3 = new Activity("a3",v2,v4,2);
		Activity a4 = new Activity("a4",v2,v5,3);
		Activity a5 = new Activity("a5",v3,v4,4);
		Activity a6 = new Activity("a6",v3,v6,3);
		Activity a7 = new Activity("a7",v4,v6,2);
		Activity a8 = new Activity("a8",v5,v6,1);
		
		v1.arcs.add(a1);
		v1.arcs.add(a2);
		
		v2.arcs.add(a4);
		v2.arcs.add(a3);
		
		v3.arcs.add(a5);
		v3.arcs.add(a6);
		
		v4.arcs.add(a7);
		
		v5.arcs.add(a8);
		
		return null;
	}
	
	/**
	 * 拓扑排序计算事件节点的最早发生时间
	 * @throws Exception
	 */
	public void TopologicalOrder() throws Exception{
		
		//o入度节点栈
		Stack<Event> zeroIndegreeStack = new Stack<>();
		zeroIndegreeStack.push(find2IndegreeEvent());
		//拓扑排序节点栈
		
		int count = 0;//计数器，统计入度为0的节点的数量
		
		while(!zeroIndegreeStack.empty()){
			count ++;
			//入度为0 的节点
			Event zeroIndegreeEvent = zeroIndegreeStack.pop();
			topoStack.push(zeroIndegreeEvent);
			ArrayList<Activity> arcs = zeroIndegreeEvent.arcs;
			//遍历以zeroIndegreeEvent为尾的节点
			for (int i = 0; i < arcs.size(); i++) {
				Activity edge = arcs.get(i);
				edge.endEvent.indegree -= 1;
				if(edge.endEvent.indegree == 0){
					zeroIndegreeStack.push(edge.endEvent);
				}
				if(zeroIndegreeEvent.ve + edge.weight > edge.endEvent.ve){
					edge.endEvent.ve = zeroIndegreeEvent.ve + edge.weight;
				}
			}
		}
		if(count < events.size()){
			throw new Exception("该图是有环图，请检查输入!count="+count+"  event.size="+events.size());
		}
	}
	
	
	/**
	 * 计算该AEO的关键活动
	 * @throws Exception 
	 */
	public void CriticalPath() throws Exception{
		TopologicalOrder();
		//初始化最迟发生时间
		int maxVe = topoStack.peek().ve;
		for (int i = 0; i < events.size(); i++) {
			events.get(i).vl = maxVe;
		}
		//TODO 最迟发生时间的初始化
		while(!topoStack.isEmpty()){
			Event event = topoStack.pop();
			ArrayList<Activity> arcs = event.arcs;
			for (int i = 0; i < arcs.size(); i++) {
				Activity activity = arcs.get(i);
				Event j =activity.startEvent;
				Event k = activity.endEvent;
				int dut = activity.weight;
				if(k.vl - dut < j.vl){
					j.vl = k.vl - dut;  
				}
			}
		}
		for (int i = 0; i < events.size(); i++) {
			
			Event event = events.get(i);
			ArrayList<Activity> arcs = event.arcs;
			for (int j = 0; j < arcs.size(); j++) {
				Activity activity = arcs.get(j);
				int ee = event.ve;
				int el = activity.endEvent.vl - activity.weight;
				if(el == ee){
					System.out.println(activity.name+"  ");
				}
			}
		}
	}
	
	

	/**
	 * 查找入度为0的节点
	 * @return
	 */
	private Event find2IndegreeEvent() {
		for (Event event : events) {
			if(event.indegree == 0){
				return event;
			}
		}
		return null;
	}
	
	
	
	

}


/**
 * 节点
 * @author wauoen
 *
 */
class Event{

	public Event(String name,int indegree,int outdegree){
		this.name = name;
		this.indegree = indegree;
		this.outdegress = outdegree;
	}
	/**
	 * 顶点事件的最早发生时间
	 */
	int ve = 0;
	/**
	 * 顶点事件的最迟发生时间
	 */
	int vl =0;
	String name ;
	int indegree;
	int outdegress;
	/**
	 * 以该节点为尾的边的集合
	 */
	ArrayList<Activity> arcs = new ArrayList<>(); 
}

/**
 * 边，邻接表的形式存储AOE
 * @author wauoen
 *
 */
class Activity{
	public Activity(String name,Event startEvent,Event endEvent,int weight){
		this.name = name;
		this.startEvent = startEvent;
		this.endEvent = endEvent;
		this.weight = weight;
	}
	String name;
	Event startEvent;
	Event endEvent;
	int weight;//权值
}

