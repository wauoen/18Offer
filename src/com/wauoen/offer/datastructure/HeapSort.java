package com.wauoen.offer.datastructure;

/**
 * 堆排序，使用最大堆
 * 
 * @author wauoen
 * 
 */

public class HeapSort {

	public static void main(String[] args) {
		
		
		int[] array = {1,2,3,6,3,0,10,8,99,3,89,100};
		new HeapSort().heapSort(array);
		for (int i : array) {
			System.out.print(i+"  ");
		}

	}
	
	/**
	 * 堆排序
	 * @param a
	 */
	private void heapSort(int[] a) {
		// 建堆
		for (int i = a.length / 2 - 1; i >= 0; i--){
			perDown(a, i, a.length);
		}
		// 排序
		for (int i = a.length-1; i > 0; i--) {
			swap(a, 0, i);// 将堆顶元素与未排序元素序列最后一个序列交换
			perDown(a, 0, i);// 下虑堆顶，使其重新变为最大堆
		}
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
			if (child+1 <n  && a[child] < a[child + 1])
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
	 * @param i
	 * @return
	 */
	private int leftChild(int i) {
		return i * 2 + 1;// 与二叉堆不同，index从0开始
	}

	
	/**
	 * 交换元素
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
	
	
}
