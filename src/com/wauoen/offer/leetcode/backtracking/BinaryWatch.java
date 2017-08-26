package com.wauoen.offer.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	
	public static void main(String args[]){
		
		printList(readBinaryWatch(1));
	}
	
	public static void printList(List list){
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i)+"");
		}
		
	}
	
	
	 public static List<String> readBinaryWatch(int num) {
	        
		 List<String> times = new ArrayList<String>();
	 
		 
		 for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				
				if(Integer.bitCount(i) + Integer.bitCount(j) == num){
					
					times.add(String.format("%d:%02d", i,j));
				}
				
			}
		}
		 
		 return times;
	 }
	

}
