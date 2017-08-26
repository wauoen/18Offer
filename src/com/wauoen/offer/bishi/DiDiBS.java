package com.wauoen.offer.bishi;

import java.util.Arrays;
import java.util.Scanner;

public class DiDiBS {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		String[] stringArr = sc.nextLine().split(" ");

		int[] intArr = new int[stringArr.length];

		for (int i = 0; i < stringArr.length; i++) {
			intArr[i] = Integer.parseInt(stringArr[i]);
		}

		int k = Integer.parseInt(sc.nextLine());

		System.out.println(new DiDiBS().FindK2(intArr, k));

	}
	
	
	/**
	 * 下虑：将左右孩子节点中较大的值与该元素交换，始终保持根节点的值大于孩子节点的值
	 * 
	 * @param array
	 * @param index
	 */
	private void perDown(int[] a, int i, int n) {
		int child;
		int temp = a[i];
		for (; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child + 1 < n && a[child] < a[child + 1])
				child++;
			if (a[child] > temp)
				a[i] = a[child];
			else
				break;
		}
		a[i] = temp;
	}

	/**
	 * 找到左节点
	 * 
	 * @param i
	 * @return
	 */
	private int leftChild(int i) {
		return i * 2 + 1;// 与二叉堆不同，index从0开始
	}

	/**
	 * 交换元素
	 * 
	 * @param a
	 * @param i
	 * @param i2
	 */
	private void swap(int[] a, int index1, int index2) {
		// TODO Auto-generated method stub

		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public int FindK2(int[] arr, int k) {

		if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
			return 0;
		}

		// 建堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			perDown(arr, i, arr.length);
		}
		// 排序
		for (int i = arr.length - 1; i >= arr.length - k; i--) {
			swap(arr, 0, i);// 将堆顶元素与未排序元素序列最后一个序列交换
			perDown(arr, 0, i);// 下虑堆顶，使其重新变为最大堆
		}

		return arr[arr.length - k];

	}

	/**
	 * 堆排序
	 * 
	 * @param a
	 */
	private void heapSort(int[] a) {
		// 建堆
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			perDown(a, i, a.length);
		}
		// 排序
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);// 将堆顶元素与未排序元素序列最后一个序列交换
			perDown(a, 0, i);// 下虑堆顶，使其重新变为最大堆
		}
	}

	

	public static int FindK(int[] arr, int k) {

		if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
			return 0;
		}

		Arrays.sort(arr);

		return arr[arr.length - k];

	}

	public static int FindGreatestSumOfSubArray(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}
		int result = array[0];
		int resultT = array[0];
		for (int i = 1; i < array.length; i++) {
			if (resultT < 0) {
				resultT = array[i];
			} else {
				resultT += array[i];
			}
			result = resultT > result ? resultT : result;
		}

		return result;
	}
}
