package com.wauoen.offer.leetcode.array;

public class Util {
	
	
	/**
	 * �������һ�����飬�Ҹ�����Ĵ�СΪlength,�����ֵ������limt
	 * @param length
	 * @param limt
	 * @return
	 */
	public static int[] genArray(int length,int limt){
		
		int[] ints = new int[length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int)(Math.random()*limt);
		}
		
		return ints;
	}

}
