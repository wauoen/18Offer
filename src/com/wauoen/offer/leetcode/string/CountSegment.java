package com.wauoen.offer.leetcode.string;

public class CountSegment {

	public static void main(String args[]) {

		System.out.println("" + countSegments("Hello, my name is John "));
	}

	public static int countSegments(String s) {

		int count = 0;

		int index = 0;
		while (index < s.length()) {
			try {

				if (s.charAt(index) != ' ' && s.charAt(index + 1) == ' ') {
					count++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			index++;
		}
		if (s.charAt(s.length() - 1) != ' ') {
			count++;
		}
		return count;
	}

}
