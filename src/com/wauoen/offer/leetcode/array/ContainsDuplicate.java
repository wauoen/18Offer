package com.wauoen.offer.leetcode.array;

import java.util.ArrayList;

/**
 * Ѱ����ͬ���������������ǵľ��벻����k
 * 
 * @author wauoen
 * 
 */
public class ContainsDuplicate {

	public static void main(String args[]) {
		
//		int[] ints = Util.genArray(100, 100);
		int[] ints = {1,2,3,4,5,6,7,8,5};
		
		for (int i : ints) {
			System.out.print(i+" ");
			
		}
		System.out.println();
		
		System.out.println(containsNearbyDuplicate(ints, 2));

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		ArrayList<Integer> indexs = null ;
		
		for (int i = 0; i < nums.length; i++) {
			int left = Math.max(0, i - k);
			int right = Math.min(nums.length - 1, i + k);
			indexs = contain(nums, left, right, nums[i]);
			if(indexs.size() > 1){
				for (int j = 0; j < indexs.size(); j++) {
					if(i <= right && j >= left)
						return true;
				}
			}
		}

		return false;
	}

	/**
	 * ������nums����С��i-j֮������num��ͬ������������ڷ��ظ������±�
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 * @param num
	 * @return
	 */
	public static ArrayList<Integer> contain(int[] nums, int i, int j, int num) {

		ArrayList<Integer> indexs = new ArrayList<>(); 
		for (; i <= j; i++) {
			if (nums[i] == num) {
				indexs.add(i);
			}
		}

		return indexs;
	}
	
	
}
