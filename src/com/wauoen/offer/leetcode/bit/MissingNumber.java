package com.wauoen.offer.leetcode.bit;

import java.util.Arrays;

public class MissingNumber {

	public int missingNumber(int[] nums) {

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return ((1+nums.length)/2)*nums.length - sum;
	}

}
