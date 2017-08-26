package com.wauoen.offer.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;


public class HappyNumber {

	public static void main(String args[]){
		
		nums.clear();
		System.out.println(""+isHappy(9));
		
		
	}
	
	static Set<Integer> nums = new HashSet<>();
	static boolean bool = false;
	
	public static boolean isHappy(int n){
		
		String nstr = n+"";
		int sum = 0;
		for (int i = 0; i < nstr.length(); i++) {
			int num = Integer.parseInt(nstr.charAt(i)+"");
			sum += Math.pow(num, 2);
		}
		System.out.println(""+sum);
		if(sum == 1){
			bool =  true;
			return bool;
		}else if(!nums.add(sum)){
			bool =  false;
			return bool;
		}
		isHappy(sum);
	
		return bool;
	}
}
