package com.wauoen.offer.datastructure;

/**
 * ������ʹ������
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
	 * ������
	 * @param a
	 */
	private void heapSort(int[] a) {
		// ����
		for (int i = a.length / 2 - 1; i >= 0; i--){
			perDown(a, i, a.length);
		}
		// ����
		for (int i = a.length-1; i > 0; i--) {
			swap(a, 0, i);// ���Ѷ�Ԫ����δ����Ԫ���������һ�����н���
			perDown(a, 0, i);// ���ǶѶ���ʹ�����±�Ϊ����
		}
	}


	/**
	 * ���ǣ������Һ��ӽڵ��нϴ��ֵ���Ԫ�ؽ�����ʼ�ձ��ָ��ڵ��ֵ���ں��ӽڵ��ֵ
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
	 * �ҵ���ڵ�
	 * @param i
	 * @return
	 */
	private int leftChild(int i) {
		return i * 2 + 1;// �����Ѳ�ͬ��index��0��ʼ
	}

	
	/**
	 * ����Ԫ��
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
