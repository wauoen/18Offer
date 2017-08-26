package com.wauoen.offer.leetcode.hashtable;
/**
 * 
 * @author wauoen
 *
 */
public class FindTheDifference {
	
	public static void main(String args[]){
		
		System.out.println(findTheDifference("abcd", "abecd"));
	}
	
	public static char findTheDifference(String s,String t){
		
		for (int i = 0; i < t.length(); i++) {
			try {
				if(t.charAt(i) != s.charAt(i)){
					return t.charAt(i);
				}
			} catch (StringIndexOutOfBoundsException e) {
				// TODO: handle exception
				return t.charAt(i);
			}
		}
		
		return ' ';
	}

}
