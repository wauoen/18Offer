package com.wauoen.offer.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wauoen
 *
 */
public class WordPattern {

	public static void main(String[] args){
		
		String pattern = "abba";
		String pattern2 = "abba";
		String pattern3 = "aaaa";
		String pattern4 = "abba";
		String str = "dog cat cat dog";
		String str2 = "dog cat cat fish";
		String str3 = "dog cat cat dog";
		String str4 = "dog dog dog dog";
		System.out.println(""+wordPattern(pattern,str));
		System.out.println(""+wordPattern(pattern2,str2));
		System.out.println(""+wordPattern(pattern3,str3));
		System.out.println(""+wordPattern(pattern4,str4));
		
		
	}
	
	public static boolean wordPattern(String pattern,String str){
		
		
		String[] strs = str.split(" ");
		Map<String,Character> strMap = new HashMap<String,Character>();
		for (int i = 0; i < strs.length; i++) {
			Character c = strMap.get(strs[i]);
			Character c2 = pattern.charAt(i);
			
			if(c != null){
				if(c != pattern.charAt(i)){
					return false;
				}
			}else if(!strMap.containsValue(c2)){
				strMap.put(strs[i], pattern.charAt(i));
			}else{
				return false;
			}
			
		}
		
		
		
		return true;
	}
	
	public String genPattern(){
		
		
		
		
		return null;
	}
}
