package com.wauoen.offer.mainshi;

import java.util.ArrayList;
import java.util.List;

/**
 * 京东面试题
 * @author wauoen
 *
 */
public class JD {
	
	/**
	 * 从list中删除与target相同的字符串
	 * @param list
	 * @param target
	 */
	public void remove(ArrayList<String> list,String target){
		
		if(list == null && target == null){
			return;
		}
		while(list.remove(target));
	}
	
	/**
	 * 插入排序
	 * @param array
	 */
	public void insertSorted(int[] array){
		
		for (int i = 1; i < array.length; i++) {
			int target = array[i];
			int j ;
			for (j = i; j >0; j--) {
				if(array[j]< array[j-1])
					array[j] = array[j-1];
			}
			array[j] = target;
		}
	}
	
//	======生产者消费者模式=========
	/**
	 * 生产者
	 * @author wauoen
	 *
	 */
	class Producer{
		
		private List list;
		
		public void produce() throws InterruptedException{
			list.wait();
			list.add(new Object());
			list.notify();
		}
	}
	
	/**
	 * 消费者
	 * @author wauoen
	 *
	 */
	class Customer{
		private List list;
		public void custom() throws InterruptedException{
			list.wait();
			list.remove(0);
			list.notify();
		}
	}
	
	
	
	public static void main(String args[]){
		
	}

}
