package com.wauoen.offer.leetcode.array;
/**
 * ɾ�������������ظ���Ԫ��
 * @author wauoen
 *
 */
public class RemoveDuplicateFromSortedArray {
	
	
	public static void main(String args[]){
		
		int[] nums = {1,1,1,1,1,1,2};
		int l = removeDuplicates(nums);
		System.out.println("���鳤�ȣ�"+l);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i]+"  ");
		}
	}
	
	public static int removeDuplicates(int[] nums){
		
		int length = 1;
		int last = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] != last){
				nums[length] = nums[i];
				length ++;
			}
			last = nums[i];
		}
		return length;
	}
	
	
}
