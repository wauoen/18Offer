package com.wauoen.offer.leetcode.array;

import java.util.Set;
import java.util.Vector;

/**
 * 在n个数中选出第三大的数
 * @author wauoen
 *
 */
public class ThirdMaximumNunber {
	
	public static void main(String[] args){
		
		int[] ints = {3,2,1};
		System.out.println(getThirdMaxNum(ints)+"");
		int[] ints2 = {1,2};
		System.out.println(getThirdMaxNum(ints2)+"");
		int[] ints3 = {2,2,3,1};
		System.out.println(getThirdMaxNum(ints3)+"");
		Vector c;
	}

	
	public static int getThirdMaxNum(int[] ints){
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		int cur = Integer.MIN_VALUE;//
		
		if(ints.length == 1){
			return ints[0];
		}else if(ints.length == 2){
			return ints[0] >= ints[1] ? ints[0] : ints[1];
		}
		
		for (int i = 0; i < ints.length; i++) {
			
			cur = ints[i];
			
			if(cur > first){
				first = cur;
				second = first;
				third = second;
			}else if(cur < first && cur > second){
				second = cur;
				third = second;
			} else if(cur < second && cur < third){
				third = cur;
			}
		}
		
		if(third == Integer.MIN_VALUE){
			return first;
		}
//		
//		Set set;
//		set.add(e)
//		set.era
//		SortedSet ss;
//		
		return third;
	}
}
