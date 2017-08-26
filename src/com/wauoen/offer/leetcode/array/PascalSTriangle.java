package com.wauoen.offer.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 杨辉三角
 */
public class PascalSTriangle {

	public static void main(String args[]) {

		new PascalSTriangle().getRow(5);
	}

	public List<Integer> getRow(int rowIndex) {

		int[] nums = new int[rowIndex + 1];
		nums[0] = 1;//第一个值
		int numIndex = rowIndex + 1;//每列的数字的数量
		

		for (int i = 1; i <= rowIndex; i++) {
			int temp = nums[0];
			for (int j = 1; j <= i + 1; j++) {

				if(j == nums.length){
					nums[nums.length-1] = nums[0];
				}else{
					int temp2 = nums[j-1];
					nums[j-1] = temp;
					temp = temp2 +nums[j];
				}
			}
				
			
		}
		
		for (Integer integer : nums) {
			System.out.print(integer+"  ");
		}

		return null;

	}

}
