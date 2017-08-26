package com.wauoen.offer.leetcode.array;
/**
 * 合并两个有序数组
 * @author wauoen
 *
 */
public class MergeSortedArray {
	
	public void merge(int[] a,int n, int[] b, int m){
		
		int i = n -1;
		int j = m - 1;
		int k = m + n - 1;
		while(i >= 0 && j >= 0 ){
			if(a[i] > b[j]){
				a[k--] = a[i--];
			}else{
				a[k--] = a[j--];
			}
		}
		while(j>=0){
			a[k--] = b[j--];
		}
	}

}
