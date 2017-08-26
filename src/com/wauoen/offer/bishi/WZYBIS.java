package com.wauoen.offer.bishi;

import java.util.HashMap;
import java.util.Scanner;

public class WZYBIS {

	public static void main(String[] args) {
		
		
		HashMap map;
	
		
		
		
		Scanner in = new Scanner(System.in);
		String s1,s2;
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入第一个字符串：");
		s2=sc.nextLine();
		System.out.print("请输入第二个字符串：");
		s1=sc.nextLine();
		System.out.println("输入的字符串是："+s1+" "+s2);
		
		
		// while (in.hasNextInt()) {// 注意while处理多个case
		// int a = in.nextInt();
		// int b = in.nextInt();
		// System.out.println(a + b);
		// }
//		String string = null;
//		int length = in.nextInt();
//		while(){
//			
//		}
//		System.out.println(length);
//		string = in.nextLine();
//		System.out.println(string);
		
//		print2(string, length);
	}

	public static void print2(String string, int n) {

		if (string == null || n == 0) {
			return;
		}

		String[] aArr = string.split(" ");
		String[] bArr = new String[n];
		int insetIndex = 0;
		for (int i = 0; i < aArr.length; i++) {
			// 1.插入末尾
			bArr[insetIndex] = aArr[i];
			// 翻转
			String[] subArr = new String[insetIndex + 1];

			for (int j = insetIndex; j >= 0; j--) {
				subArr[insetIndex - j] = bArr[j];
			}
			for (int j = 0; j <= insetIndex; j++) {
				bArr[j] = subArr[j];
			}
			insetIndex++;
		}

		for (int i = 0; i < bArr.length; i++) {

			System.out.print(bArr[i]);
			if (i < bArr.length - 1) {
				System.out.print(" ");
			}
		}

	}

	public static String getSubLength(String string) {

		String maxSub = "";
		if (string.length() <= 1) {
			return "";
		}
		int start = 0;
		int end = 1;
		String sub = "" + string.charAt(start);
		while (start < string.length()) {
			if (end < string.length()
					&& string.charAt(start) != string.charAt(end)) {
				sub += string.charAt(end);
				start++;
				end++;
			} else {
				if (sub.length() > maxSub.length()) {
					maxSub = sub;
				}
				start = end;
				end++;
			}
		}

		if (maxSub.length() < 2) {
			return "";
		}

		return maxSub;
	}
}
