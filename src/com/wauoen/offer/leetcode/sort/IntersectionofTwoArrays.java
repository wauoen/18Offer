package com.wauoen.offer.leetcode.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {

	public static void main(String[] args) {

		int[] nums1 = { 9, 1 };
		int[] nums2 = { 7, 8, 3, 9, 0, 0, 9, 1, 5 };
		System.out.println(intersection(nums1, nums2));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		if (nums1.length == 0 || nums2.length == 0) {

			return new int[0];
		}

		Set<Integer> result = new HashSet<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int integer : nums1) {
			set.add(integer);
		}

		for (int integer : nums2) {
			if (set.contains(integer))
				result.add(integer);
		}
		int[] results = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			results[i] = (int) result.toArray()[i];
		}

		return results;
	}

	public static int[] intersection2(int[] nums1, int[] nums2) {

		if (nums1.length == 0 || nums2.length == 0) {

			return new int[0];
		}
		

		Set<Integer> result = new HashSet<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int integer : nums1) {
			set.add(integer);
		}

		for (int integer : nums2) {
			if (set.contains(integer))
				result.add(integer);
		}
		int[] results = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			results[i] = (int) result.toArray()[i];
		}

		return results;
	}
}
