package com.wauoen.offer.datastructure.graph;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * ���·�� �Ͻ�˹����
 * @author wauoen
 *
 */
public class DIJ {

	/**
	 * ��������G��v0���㵽���ඥ��v�����·��p[v]�����Ȩ����D[v]
	 * ��P[v][w]=true,��w�Ǵ�v0��v��ǰ������·���ϵĶ���
	 * finnal[v]=true�����ҽ���v��S�����Ѿ����v0��v�����·��
	 */
	
	//�ڵ������
	int vexnum = 6;
	//���·�������
	int v0 = 0;
	//�ڽӾ���洢������
	int[][] G = {
			{Integer.MAX_VALUE,Integer.MAX_VALUE,10,Integer.MAX_VALUE,30,100},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,5,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,50,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,10},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,20,Integer.MAX_VALUE,60},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,}
	};
	
	//TODO 
	boolean[][] P = new boolean[6][6]; 
	
	//TODO 
	boolean[] finnal = new boolean[6];
	
	//TODO
	int[] D = new int[vexnum];
	
	public void shortestPaht(){
		
		//��ʼ��
		for (int v = 0; v < vexnum; v++) {
			
			finnal[v] = false;
			D[v] = G[0][v];
			for (int w = 0; w < vexnum; w++) {
				P[v][w] = false;
			}
			if(D[v] < Integer.MAX_VALUE){
				P[v][v0] = true;
				P[v][v] = true;
			}
		}
		
		D[v0] = 0;
		finnal[v0] = true;
		
		for (int i = 1; i < vexnum; i++) {
			
			int min = Integer.MAX_VALUE;
			int v = Integer.MAX_VALUE;//TODO
			for (int w = 0; w < vexnum; w++) {
				if(!finnal[w]){
					if(D[w] < min){
						v = w;
						min = D[w];
					}
				}
			}
			if(v>=vexnum-1)
				continue;
			finnal[v] = true;
			
			for (int w = 0; w < vexnum; w++) {
				if(!finnal[w] && (min + G[v][w]) < D[w] && (min + G[v][w]) >= 0){
					
					D[w] = min + G[v][w];
//					P[w] = P[v]; 
					for (int j = 0; j < vexnum; j++) {
						P[w][j] = P[v][j];
					}
					P[w][w] = true;
				}
			}
		}
		
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P.length; j++) {
				System.out.print(""+P[i][j]+"  ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String args[]){
		
		DIJ dij = new DIJ();
		dij.shortestPaht();
	}
	
}
