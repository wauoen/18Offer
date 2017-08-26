package com.wauoen.offer.leetcode.array;

public class Util {
	
	
	/**
	 * 随机生成一个数组，且该数组的大小为length,且最大值不超过limt
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
