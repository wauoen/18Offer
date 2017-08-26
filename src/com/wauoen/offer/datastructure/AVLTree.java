package com.wauoen.offer.datastructure;

/**
 * 平衡二叉树
 * @author wauoen
 *
 */
public class AVLTree <T extends Comparable> {
	
	private static class AVLNode<T>{
		
		T element;//改节点数据
		AVLNode<T> left;//左二子
		AVLNode<T> right;//右儿子
		int height;//高度
		
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
	 * 计算高度
	 * @param <T>
	 * @return
	 */
	public int height(AVLNode<T> t){
		return t==null ? -1:t.height;
	}
	
	/**
	 * 将节点x插入到t中
	 * @param x 
	 * @param t
	 * @return 经过平衡后的根节点
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
	 * 在平衡二叉树的过程中有四种情况
	 * 1.对a的左儿子的左子树进行一次插入
	 * 2.对a的左儿子的右子树进行一次插入
	 * 3.对a的右儿子的左子树进行一次插入
	 * 4.对a的右儿子的右子树进行一次插入
	 * 使二叉树平衡
	 * @param t
	 * @return
	 */
	private AVLNode<T> blance(AVLNode<T> t){
		
		if(t == null){
			return t;
		}
		
		if(height(t.left) - height(t.right) > ALLOW_IMBALANCE){
			
			if(height(t.left.left) >= height(t.left.right)){//情形1
				t = rotateWithLeftChild(t);
			}else{//情形2
				t = doubleWithLeftChild(t);
			}
		}
		if(height(t.right) - height(t.left) > ALLOW_IMBALANCE){
			if( height(t.right.right) >= height(t.right.left) ){//情形3
				t = rotateWithRightChild(t);
			}else{//情形4
				t = doubleWithRightChild(t);
			}
		}
		
		t.height = Math.max(t.left.height, t.right.height) + 1;
		
		return t;
	}
	
	/**
	 * 以左儿子为中心单旋转，情形1
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
	 * 以右儿子进行单旋转，情形4
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
	 * 双旋转，先对k3的左儿子进行单旋转，在对k3进行单旋转，情形2
	 * @param k3
	 * @return
	 */
	private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3){
		
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	/**
	 * 双旋转，先对k3的右儿子进行单旋转，在对k3进行单旋转，情形3
	 * @param k3
	 * @return
	 */
	private AVLNode<T> doubleWithRightChild(AVLNode<T> k3){
		
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

}
