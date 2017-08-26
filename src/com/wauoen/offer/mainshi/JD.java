package com.wauoen.offer.mainshi;

import java.util.ArrayList;
import java.util.List;

/**
 * ����������
 * @author wauoen
 *
 */
public class JD {
	
	/**
	 * ��list��ɾ����target��ͬ���ַ���
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
	 * ��������
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
	
//	======������������ģʽ=========
	/**
	 * ������
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
	 * ������
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
