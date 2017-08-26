package com.wauoen.offer.leetcode.hashtable;

import java.util.HashMap;

/**
 * 查找两个数的和等于目标数
 * @author wauoen
 *
 */
public class TwoSum {
	
	public static void main(String args[]){
		
		int nums[] = {2,7,11,15};
		int target[] = twoSum(nums,9);
		System.out.println(target[0]+"  "+target[1]);
		
	}
	
	public static int[] twoSum(int[] nums, int target){

		HashMap<Integer,Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
			if(numMap.containsKey(target - nums[i])){
				return new int[]{i,numMap.get(target - nums[i])};
			}
		}
		
		return null;
	}

}
