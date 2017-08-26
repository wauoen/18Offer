package com.wauoen.offer.leetcode.string;

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String args[]){
		
		System.out.println(""+isValid("[{()}]"));
	}

	public static boolean isValid(String s) {
		
		Stack<Character> sb = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			switch (s.charAt(i)) {
			case '(':
				sb.push('(');
				break;
			case ')':
				if(sb.isEmpty() ||sb.pop()!='('){
					return false;
				}
				break;
			case '[':
				sb.push('[');
				break;
			case ']':
				if(sb.isEmpty() || sb.pop()!='['){
					return false;
				}
				break;
			case '{':
				sb.push('{');
				break;
			case '}':
				if(sb.isEmpty() ||sb.pop()!='{'){
					return false;
				}
				break;

			default:
				break;
			}
		}

		return true;
	}
}
