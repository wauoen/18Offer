package com.wauoen.offer.leetcode.array;
/**
 * ��ת���飬���ұ�k��Ԫ������߽�����
 * [1,2,3,4,5,6,7] to [5,6,7,1,2,3,4]
 * @author wauoen
 *
 */
public class RoateArray {
	
	public static void main(String args[]){
		
		
	}
	
	public static void rotate(int[] nums,int k){
		
		
		int temp = 0;
		for (int i = 0; i < k; i++) {
			
			for (int j = 0; j < Math.round(nums.length / k); j++) {
				temp = nums[(i + k) % nums.length];
				nums[(i + k) % nums.length] = nums[i];
			}
		}
	}

}
