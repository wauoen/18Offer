package com.wauoen.offer.datastructure;

/**
 * ƽ�������
 * @author wauoen
 *
 */
public class AVLTree <T extends Comparable> {
	
	private static class AVLNode<T>{
		
		T element;//�Ľڵ�����
		AVLNode<T> left;//�����
		AVLNode<T> right;//�Ҷ���
		int height;//�߶�
		
		AVLNode(T element,AVLNode<T> left, AVLNode<T> right){
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
		
		AVLNode(T element){
			this(element,null,null);
		}
	}
	
	/**
	 * ����߶�
	 * @param <T>
	 * @return
	 */
	public int height(AVLNode<T> t){
		return t==null ? -1:t.height;
	}
	
	/**
	 * ���ڵ�x���뵽t��
	 * @param x 
	 * @param t
	 * @return ����ƽ���ĸ��ڵ�
	 */
	private AVLNode<T> insert(T x, AVLNode<T> t){
		
		if(t == null){
			return new AVLNode(x);
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0){
			insert(x,t.left);
		}else if(compareResult > 0){
			insert(x,t.right);
		}
		
		return blance(t);
	}
	
	
	private static final int ALLOW_IMBALANCE = 1;
	
	/**
	 * ��ƽ��������Ĺ��������������
	 * 1.��a������ӵ�����������һ�β���
	 * 2.��a������ӵ�����������һ�β���
	 * 3.��a���Ҷ��ӵ�����������һ�β���
	 * 4.��a���Ҷ��ӵ�����������һ�β���
	 * ʹ������ƽ��
	 * @param t
	 * @return
	 */
	private AVLNode<T> blance(AVLNode<T> t){
		
		if(t == null){
			return t;
		}
		
		if(height(t.left) - height(t.right) > ALLOW_IMBALANCE){
			
			if(height(t.left.left) >= height(t.left.right)){//����1
				t = rotateWithLeftChild(t);
			}else{//����2
				t = doubleWithLeftChild(t);
			}
		}
		if(height(t.right) - height(t.left) > ALLOW_IMBALANCE){
			if( height(t.right.right) >= height(t.right.left) ){//����3
				t = rotateWithRightChild(t);
			}else{//����4
				t = doubleWithRightChild(t);
			}
		}
		
		t.height = Math.max(t.left.height, t.right.height) + 1;
		
		return t;
	}
	
	/**
	 * �������Ϊ���ĵ���ת������1
	 * @param k2
	 * @return
	 */
	private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2){
		
		AVLNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		
		return k1;
	}
	/**
	 * ���Ҷ��ӽ��е���ת������4
	 * @param k2
	 * @return
	 */
	private AVLNode<T> rotateWithRightChild(AVLNode<T> k2){
		
		AVLNode<T> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		
		return k1;
	}
	
	/**
	 * ˫��ת���ȶ�k3������ӽ��е���ת���ڶ�k3���е���ת������2
	 * @param k3
	 * @return
	 */
	private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3){
		
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	/**
	 * ˫��ת���ȶ�k3���Ҷ��ӽ��е���ת���ڶ�k3���е���ת������3
	 * @param k3
	 * @return
	 */
	private AVLNode<T> doubleWithRightChild(AVLNode<T> k3){
		
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

}
