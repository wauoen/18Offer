package com.wauoen.offer.bishi;

/**
 * ‘∂æ∞ƒ‹‘¥±  ‘
 * @author wauoen
 *
 */
import java.util.*;
public class YJNYTest {

	
	public static void main(String args[]){
		
		System.out.println(checkDifferent("acbdbesy"));

	}
	public ArrayList<String> letterCombinations(String digits) {
		
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
         
       List<String> res = new ArrayList<String>();  
         
       rec(res, new StringBuilder(), digits, map, 0); 
       
       return (ArrayList<String>) res;  
   }
   
    private void rec(List<String> res, StringBuilder sb, String digits, String[] map, int level){  
       if(level==digits.length() ){  
           res.add(sb.toString());  
           return;  
       }  
       String s = map[digits.charAt(level)-'2'];  
       for(int i=0; i<s.length(); i++) {  
           sb.append(s.charAt(i));  
           rec(res, sb, digits, map, level+1);  
           sb.deleteCharAt(sb.length()-1);  
       }  
   }  
	
	public static boolean checkDifferent(String iniString) {
        
		if(iniString == null || iniString.length() == 0){
			return false;
		}
		int[] bool  = new int[65536];
		for (int i = 0; i < iniString.length(); i++) {
			int index = iniString.charAt(i);
			System.out.println(index);
			if(bool[index] ==  1){
				return false;
			}else{
				bool[index] = 1;
			}
		}
		return true;
    }
}
