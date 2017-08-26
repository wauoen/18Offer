package com.wauoen.offer.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	
	public static void main(String args[]){
		
		int[] findNums = {2,4};
		int[] nums = {1,2,3,4};
		nextGreaterElement(findNums, nums);
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {

		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			
			while(!stack.isEmpty() && stack.peek() < nums[i] ){
				maps.put(stack.pop(), nums[i]);
			}
			stack.push(nums[i]);
		}
		
		for (int i = 0; i < findNums.length; i++) {
			
//			findNums[i] = ((Object) maps).getOrDefault(findNums[i], -1);
		}
		
		for (int i = 0; i < findNums.length; i++) {
			System.out.println(findNums[i]);
		}
		
		return findNums;
	}

}
