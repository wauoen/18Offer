package com.wauoen.offer.leetcode.greedy;

import java.util.Arrays;

public class AssignCookies {
	
	public static void main(String args[]){
		
		int[] g = {1,2,3};
		int[] s = {1,1};
		System.out.println(""+findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {

		int count = 0;
		Arrays.sort(g);
		for (int i = g.length-1; i >=0; i--) {
			for (int j = 0; j < s.length; j++) {
				if(g[i] <= s[j]){
					s[j] = -1;
					count ++;
					break;
				}
			}
		}
		
		return count;
	}

}
