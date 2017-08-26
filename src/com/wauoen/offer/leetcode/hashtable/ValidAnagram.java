package com.wauoen.offer.leetcode.hashtable;

public class ValidAnagram {
	
	public static void main(String args[]){
		
		System.out.println(""+isAnagram("anagram","nagaram"));
	}
	
	public static boolean isAnagram(String s, String t){
		char c = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			c ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			c ^= t.charAt(i);
		}
		if(c==0)
			return true;
		
		return false;
	} 

}
