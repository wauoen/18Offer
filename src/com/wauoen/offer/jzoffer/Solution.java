package com.wauoen.offer.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {

	/**
	 * 二维数组中查找
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean find(int target, int[][] array) {

		if (array == null || array.length == 0) {

			return false;
		}
		// 行
		int row = array.length;
		// 列
		int column = array[0].length - 1;
		// 当前访问元素的位置a[i][j],从第一行最后一个元素开始遍历
		int curI = 0;
		while (curI < row && column >= 0) {

			if (array[curI][column] == target) {
				return true;
			} else if (target > array[curI][column]) {
				curI++;
			} else if (target < array[curI][column]) {
				column--;
			}
		}
		return false;
	}

	/**
	 * 字符替换
	 * 
	 * @param str
	 * @return
	 */
	public String replaceSpace(StringBuffer str) {

		if (str == null && str.length() > 0) {
			return null;
		}

		String sub = "%20";
		String target = " ";

		int startIndex = str.indexOf(target);
		while (startIndex != -1) {

			str.replace(startIndex, startIndex + 1, sub);
			startIndex = str.indexOf(target, startIndex + 3);
		}

		return str.toString();
	}

	public static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 输入一个链表，从尾到头打印链表每个节点的值。
	 * 
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		while (listNode != null) {

			list.add(0, listNode.val);
			listNode = listNode.next;
		}

		return list;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 在数组array中查找target的位置，查找范围：start-end
	 * 
	 * @param start
	 * @param end
	 * @param array
	 * @return
	 */
	private int indexOf(int start, int end, int[] array, int target) {

		for (int i = start; i < end; i++) {

			if (array[i] == target) {

				return i;
			}
		}

		return -1;
	}

	/**
	 * 将数组分成两份，返回左边的数组
	 * 
	 * @param array
	 * @param midIndex
	 * @return
	 */
	public int[] getSubLeftArray(int[] array, int midIndex) {

		if (array == null || midIndex == 0) {

			return null;
		}

		int[] left = new int[midIndex];
		for (int i = 0; i < midIndex; i++) {
			left[i] = array[i];
		}
		return left;

	}

	/**
	 * 将数组分成两部分返回右边的数组
	 * 
	 * @param array
	 * @param midIndex
	 * @return
	 */
	public int[] getSubRightArray(int[] array, int midIndex) {

		if (array == null || midIndex == array.length - 1) {

			return null;
		}
		int[] right = new int[array.length - 1 - midIndex];
		for (int i = 0; i < right.length; i++) {
			right[i] = array[midIndex + 1 + i];
		}

		return right;

	}

	/**
	 * 从数组中取出从start位置开始长度为length的数组
	 * 
	 * @param start
	 * @param length
	 * @param array
	 * @return
	 */
	private int[] getSubScropArray(int start, int length, int[] array) {

		if (array == null || start + length > array.length) {
			return null;
		}
		int[] subArray = new int[length];
		for (int i = 0; i < length; i++) {
			subArray[i] = array[start + i];
		}
		return subArray;
	}

	/**
	 * 重建二叉树
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre == null || in == null || pre.length == 0 || in.length == 0) {

			return null;
		}
		// 当前根节点在前序遍历中的位置
		int rootIndexInPre = 0;
		TreeNode root = new TreeNode(pre[rootIndexInPre]);
		// 根节点在中序遍历中的位置
		int rootIndexInIn = indexOf(0, in.length, in, pre[rootIndexInPre]);
		// 从中序遍历中取出左子树节点数组
		int[] leftTreeNodes = getSubLeftArray(in, rootIndexInIn);
		// 从中序遍历中取出右子树节点数组
		int[] rightTreeNodes = getSubRightArray(in, rootIndexInIn);
		// 从前序遍历中取出左子树的前序遍历
		int leftPreLength = 0;
		int[] preLeft = null;
		if (leftTreeNodes != null)
			preLeft = getSubScropArray(rootIndexInPre + 1,
					leftTreeNodes.length, pre);
		// 从前序遍历中取出右子树的前序遍历
		int rightStartIndexInPre = rootIndexInPre + 1;
		if (leftTreeNodes != null) {
			rightStartIndexInPre = rightStartIndexInPre + preLeft.length;
		}
		int[] preRight = null;
		if (rightTreeNodes != null)
			preRight = getSubScropArray(rightStartIndexInPre,
					rightTreeNodes.length, pre);

		root.left = reConstructBinaryTree(preLeft, leftTreeNodes);
		root.right = reConstructBinaryTree(preRight, rightTreeNodes);

		return root;
	}

	/**
	 * 按层遍历二叉树
	 * 
	 * @param root
	 */
	private void bianliTree(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	/**
	 * 5.用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}

	public int pop() {

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	/**
	 * 旋转数组的最小数字
	 */
	public int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0) {

			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		for (int i = array.length - 1; i >= 1; i--) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}

		return 0;
	}

	/**
	 * 计算斐波那契数
	 * 
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] f = new int[n];
		f[0] = 1;

		f[1] = 1;
		int i = 2;
		while (i < n) {
			f[i] = f[i - 1] + f[i - 2];
			i++;
		}

		return f[n - 1];
	}

	/**
	 * 跳台阶
	 * 
	 * @param target
	 * @return
	 */
	public int JumpFloor(int target) {

		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int[] f = new int[target];
		f[0] = 1;

		f[1] = 2;
		int i = 2;
		while (i < target) {
			f[i] = f[i - 1] + f[i - 2];
			i++;
		}

		return f[target - 1];

	}

	/**
	 * 变态跳台阶，递推公式：f(n) = 2f(n-1)
	 * 
	 * @param target
	 * @return
	 */
	public int JumpFloorII(int target) {
		if (target == 1) {

			return 1;
		}
		return 2 * JumpFloorII(target - 1);
	}

	/**
	 * 矩形覆盖
	 * 
	 * @param target
	 * @return
	 */
	public int RectCover(int target) {

		if (target == 1) {

			return 1;
		}
		if (target == 2) {

			return 2;
		}
		if (target == 3) {

			return 3;
		}

		return 4 * RectCover(target - 1);
	}

	/**
	 * 链表中倒数第k个结点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}

		ListNode first = head;
		int i = k;
		while (--i >= 1 && (head = head.next) != null)
			;
		if (head == null)
			return null;
		while (head.next != null && (head = head.next) != null) {
			first = first.next;
		}

		return first;
	}

	/**
	 * 树的子结构
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {

		if (root1 == null || root2 == null) {
			return false;
		}

		return isSubTree(root1, root2) || HasSubtree(root1.left, root2)
				|| HasSubtree(root1.right, root2);
	}

	/**
	 * 判断root2是否时root1的子结构
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isSubTree(TreeNode root1, TreeNode root2) {

		if (root1 == null)
			return false;
		if (root2 == null)
			return true;
		if (root1.val == root2.val) {
			return isSubTree(root1.left, root2.left)
					&& isSubTree(root1.right, root2.right);
		}
		return false;

	}

	/**
	 * 二叉树的镜像
	 * 
	 * @param root
	 */
	public void Mirror(TreeNode root) {

		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}

	/**
	 * 顺时针打印矩阵
	 * 
	 * @param matrix
	 * @return
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> list = new ArrayList<>();
		if (matrix == null) {
			return null;
		}
		int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
		int i = left, j = top;
		if (left == right && top == bottom) {
			list.add(matrix[0][0]);
		}
		while (list.size() != matrix.length * matrix[0].length) {
			// 向左走
			for (; i >= left && i <= right && j <= bottom && j >= top; i++) {
				list.add(matrix[j][i]);
			}
			j = ++top;
			i--;
			// 向下走
			for (; i >= left && i <= right && j <= bottom && j >= top; j++) {
				list.add(matrix[j][i]);
			}
			i = --right;
			j--;
			// 向左走
			for (; i >= left && i <= right && j <= bottom && j >= top; i--) {
				list.add(matrix[j][i]);
			}
			j = --bottom;
			i++;
			// 向上走
			for (; i >= left && i <= right && j <= bottom && j >= top; j--) {
				list.add(matrix[j][i]);
			}
			j++;
			i = ++left;
		}
		return list;
	}

	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
	 * 
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {

		if (pushA == null || popA == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();

		int pushAIndex = 0;
		int popAIndex = 0;

		while (pushAIndex < pushA.length) {

			if (stack.isEmpty() || stack.peek() != popA[popAIndex]) {
				stack.push(pushA[pushAIndex++]);
			}

			while (!stack.isEmpty() && stack.peek() == popA[popAIndex]) {
				stack.pop();
				popAIndex++;
			}
		}

		return stack.isEmpty();
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return null;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			result.add(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

		return result;
	}

	/**
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0) {
			return false;
		}

		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
	}

	public boolean VerifySquenceOfBST(int[] sequence, int startIndex,
			int endIndex) {

		if (startIndex == endIndex) {
			return true;
		}

		int root = sequence[endIndex];
		int leftStart = startIndex;
		while (sequence[startIndex] < root) {
			startIndex++;
		}
		;
		int rightStart = startIndex;
		while (sequence[startIndex] > root) {
			startIndex++;
		}
		;

		if (startIndex != endIndex) {
			return false;
		}

		boolean left = true;
		if (leftStart < rightStart - 1) {
			left = VerifySquenceOfBST(sequence, leftStart, rightStart - 1);
		}
		boolean right = true;
		if (rightStart < endIndex - 1) {
			right = VerifySquenceOfBST(sequence, rightStart, endIndex - 1);
		}

		return left && right;
	}

	/**
	 * 二叉树中和为某一值的路径
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		FindPath(root, target, 0, new ArrayList<Integer>(), result);

		return result;
	}

	public void FindPath(TreeNode node, int target, int preSum,
			ArrayList<Integer> parentPath, ArrayList<ArrayList<Integer>> result) {

		if (node == null || target < preSum) {
			return;
		}
		ArrayList<Integer> path = new ArrayList<>();
		path.addAll(parentPath);
		if (preSum + node.val == target && node.left == null
				&& node.right == null) {

			path.add(node.val);
			result.add(path);
		} else if (preSum + node.val < target) {
			path.add(node.val);
			preSum += node.val;
			FindPath(node.left, target, preSum, path, result);
			FindPath(node.right, target, preSum, path, result);
		}

	}

	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	/**
	 * hasHmap保存节点，且map的键值是原链表中的节点
	 * 
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {

		if (pHead == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
		RandomListNode head = new RandomListNode(pHead.label);
		RandomListNode result = head;
		RandomListNode pHeadTemp = pHead;
		nodeMap.put(pHead, head);
		while (pHead.next != null) {
			RandomListNode next = new RandomListNode(pHead.next.label);
			head.next = next;
			nodeMap.put(pHead.next, next);
			pHead = pHead.next;
			head = head.next;
		}
		head = result;
		pHead = pHeadTemp;
		while (pHead != null) {
			if (pHead.random != null) {
				RandomListNode random = nodeMap.get(pHead.random);
				head.random = random;
			}
			pHead = pHead.next;
			head = head.next;
		}

		return result;
	}

	/**
	 * 方法2
	 * 
	 * @param pHead
	 * @param a
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead, int a) {

		if (pHead == null) {
			return null;
		}

		RandomListNode pHeadT = pHead;
		/**
		 * 复制节点： 复制前：A->B->C 复制后：A->A*->B->B*->C->C*
		 */
		while (pHead != null) {
			RandomListNode node = new RandomListNode(pHead.label);
			RandomListNode temp = pHead.next;
			pHead.next = node;
			node.next = temp;
			pHead = temp;
		}
		/**
		 * 初始化random指向的节点
		 */
		pHead = pHeadT;
		while (pHead != null) {
			if (pHead.random != null) {
				// pHead的复制节点
				RandomListNode newNode = pHead.next;
				newNode.random = pHead.random.next;
			}
			pHead = pHead.next.next;
		}
		/**
		 * 删除初始链表中的节点
		 */
		pHead = pHeadT.next;
		while (pHead != null) {
			pHead.next = pHead.next.next;
			pHead = pHead.next;
		}

		return pHeadT.next;
	}

	/**
	 * 二叉搜索树与双向链表：中序遍历
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {

		if (pRootOfTree == null) {
			return null;
		}

		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		inorderReverse(pRootOfTree, list);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = list.get(i);
			if (i == 0) {
				node.left = null;
				if (i + 1 < list.size()) {
					node.right = list.get(i + 1);
				} else {
					node.right = null;
				}
			} else if (i == list.size() - 1) {
				node.right = null;
				if (i - 1 >= 0) {
					node.left = list.get(i - 1);
				} else {
					node.left = null;
				}
			} else {
				node.left = list.get(i - 1);
				node.right = list.get(i + 1);
			}

		}

		return list.get(0);
	}

	/**
	 * 中序遍历一棵树
	 * 
	 * @param pRootOfTree
	 */
	public void inorderReverse(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
		if (pRootOfTree == null || list == null) {
			return;
		}
		inorderReverse(pRootOfTree.left, list);
		list.add(pRootOfTree);
		inorderReverse(pRootOfTree.right, list);
	}

	/**
	 * 字符串的排列
	 * 
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> result = new ArrayList<>();
		TreeSet<String> resultSet = new TreeSet<>();
		Permutation(str.toCharArray(), resultSet, 0);
		result.addAll(resultSet);
		return result;
	}

	public void Permutation(char[] chars, TreeSet<String> resultSet,
			int startIndex) {

		if (startIndex >= chars.length) {
			return;
		}

		if (startIndex == chars.length - 1) {
			resultSet.add(new String(chars));
		} else {
			for (int i = startIndex; i < chars.length; i++) {
				swap(chars, i, startIndex);
				Permutation(chars, resultSet, startIndex + 1);
				swap(chars, i, startIndex);
			}
		}
	}

	private void swap(char[] chars, int i, int startIndex) {

		char temp = chars[startIndex];
		chars[startIndex] = chars[i];
		chars[i] = temp;
	}

	/**
	 * 数组中出现次数超过一半的数字
	 * 
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}
		// 出现次数最多
		int result = 0;
		int counter = 0;
		for (int i : array) {
			if (counter <= 0) {
				result = i;
				counter = 1;
			} else {
				if (i == result) {
					counter++;
				} else {
					counter--;
				}
			}
		}
		counter = 0;
		for (int i : array) {
			if (result == i) {
				counter++;
			}
		}

		return counter > array.length / 2 ? result : 0;
	}

	/**
	 * 连续子数组的最大和,非动态规划解法
	 * 
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {

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

	/**
	 * 整数中1出现的次数（从1到n整数中1出现
	 * 
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {

		if (n <= 0) {
			return 0;
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			String string = String.valueOf(i);
			for (int j = 0; j < string.length(); j++) {
				if (string.charAt(j) == '1')
					result++;
			}
		}
		return result;
	}

	/**
	 * 把数组排成最小的数
	 * 
	 * @param numbers
	 * @return
	 */
	public String PrintMinNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return "";
		}
		String[] numberStrings = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numberStrings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(numberStrings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String string : numberStrings) {
			sb.append(string);
		}
		return sb.toString();
	}

	/**
	 * 丑数
	 * 
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {

		return 0;
	}

	/**
	 * 第一个只出现一次的字符
	 * 
	 * @param str
	 * @return
	 */
	public int FirstNotRepeatingChar(String str) {

		return 0;
	}

	/**
	 * 和为S的连续正数序列
	 * 
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> item = new ArrayList<>();
		int counter = 0;
		int first = 0;
		for (int i = 1; first < (1 + sum) / 2; i++) {

			if (counter < sum) {
				item.add(i);
				counter += i;
				if (counter == sum) {
					if (item.size() >= 2) {
						ArrayList<Integer> oneResult = new ArrayList<>();
						oneResult.addAll(item);
						result.add(oneResult);
					}
					int delInt = item.get(0);
					counter -= delInt;
					item.remove(0);
					first = delInt;
				}
			} else if (counter > sum) {
				int size = item.size();
				while (counter > sum && size > 0) {

					int delInt = item.get(0);
					counter -= delInt;
					item.remove(0);
					size = item.size();
					first = delInt;
				}
				if (counter == sum && item.size() >= 2) {
					ArrayList<Integer> oneResult = new ArrayList<>();
					oneResult.addAll(item);
					result.add(oneResult);
				}
				item.add(i);
				counter += i;
			}

		}

		return result;
	}

	/**
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		if (array == null && array.length <= 0) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();

		int startIndex = 0;
		int endIndex = array.length - 1;
		int minResult = Integer.MAX_VALUE;
		int minI = -1;
		int minJ = -1;

		while (startIndex < endIndex) {

			int start = array[startIndex];
			int end = array[endIndex];
			int mul = start * end;
			int sumT = start + end;
			if (sumT == sum) {

				if (mul < minResult) {
					minResult = mul;
					minI = start;
					minJ = end;
				}
				startIndex++;
			} else if (sumT > sum) {
				endIndex--;
			} else if (sumT < sum) {
				startIndex++;
			}
		}

		if (minResult < Integer.MAX_VALUE) {
			result.add(minI);
			result.add(minJ);
		}

		return result;
	}

	/**
	 * 左旋转字符串
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString(String str, int n) {

		if (str == null || str.length() == 0) {
			return null;
		}

		if (n > str.length()) {
			n %= str.length();
		}

		String subString = str.substring(0, n);
		String subString2 = str.substring(n);

		return subString2 + subString;
	}

	/**
	 * 翻转单词顺序列
	 * 
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {

		if (str == null) {
			return null;
		}

		String strArray[] = str.split(" ");
		int startIndex = 0;
		int endIndex = strArray.length - 1;
		while (startIndex < endIndex) {

			String temp = strArray[startIndex];
			strArray[startIndex] = strArray[endIndex];
			strArray[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strArray.length; i++) {
			sb.append(strArray[i]);
			if (i + 1 < strArray.length) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	/**
	 * 扑克牌顺子
	 * 
	 * @param numbers
	 * @return
	 */
	public boolean isContinuous(int[] numbers) {

		if (numbers == null || numbers.length < 5) {
			return false;
		}

		TreeSet<Integer> set = new TreeSet<Integer>();
		int zeroCount = 0;
		for (int i : numbers) {
			if (i != 0) {
				set.add(i);
			} else {
				zeroCount++;
			}
		}
		if (set.size() + zeroCount < 5) {
			return false;
		}
		int last = -1;
		for (Integer integer : set) {
			if (last != -1) {
				zeroCount -= integer.intValue() - last - 1;
			}
			last = integer.intValue();
		}

		return zeroCount < 0 ? false : true;
	}

	/**
	 * 孩子们的游戏(圆圈中最后剩下的数) f(n,m) = [f(n-1,m)+m]%n;
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {

		if (n <= 0 || m <= 0) {
			return -1;
		}

		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}

		return last;
	}

	/**
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 * 
	 * @param n
	 * @return
	 */
	public int Sum_Solution(int n) {

		if (n <= 0) {
			return 0;
		}
		return n + Sum_Solution(n - 1);
	}

	/**
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int Add(int num1, int num2) {

		// 1.与运算
		int result = num1 & num2;
		// 2.左移一位，进位运算
		result <<= 1;
		// 3.异或
		int yhResult = num1 ^ num2;

		return yhResult + result;
	}

	/**
	 * 把字符串转换成整数
	 * 
	 * @param str
	 * @return
	 */
	public int StrToInt(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}
		// 遍历结束位置，存在符号位在1处结束，否则在0处结束
		int endIndex = 0;
		// 符号位处理
		char ch = str.charAt(0);
		int zf = 1;
		if (ch == '+') {
			zf = 1;
			endIndex = 1;
		} else if (ch == '-') {
			zf = -1;
			endIndex = 1;
		}

		// 从后往前遍历相加
		int result = 0;
		for (int i = str.length() - 1; i >= endIndex; i--) {

			// 相加
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				result += (c - '0') * Math.pow(10, (str.length() - 1 - i)) * zf;
			} else {
				return 0;
			}
		}

		return result;
	}

	/**
	 * 数组中重复的数字
	 * 
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || numbers.length <= 1) {
			return false;
		}

		boolean[] num = new boolean[length];
		for (int i = 0; i < numbers.length; i++) {
			if (num[numbers[i]]) {
				duplication[0] = numbers[i];
				return true;
			} else {
				num[numbers[i]] = true;
			}
		}

		return false;
	}

	/**
	 * 构建乘积数组
	 * 
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {

		if (A == null || A.length == 0) {
			return null;
		}
		int[] C = new int[A.length];
		C[0] = 1;
		for (int i = 1; i < C.length; i++) {
			C[i] = C[i - 1] * A[i - 1];
		}
		int[] D = new int[A.length];
		D[D.length - 1] = 1;
		for (int i = D.length - 2; i >= 0; i--) {
			D[i] = D[i + 1] * A[i + 1];
		}
		int[] result = new int[A.length];
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				result[i] = D[i];
			} else if (i == result.length - 1) {
				result[i] = C[i];
			} else {
				result[i] = C[i] * D[i];
			}
		}

		return result;
	}

	/**
	 * 正则表达式匹配
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean match(char[] str, char[] pattern) {

		if (str == null || pattern == null) {
			return false;
		}
		if (str.length <= 0 && pattern.length <= 0) {
			return true;
		}
		if (str.length == 0 && pattern.length >= 2 && pattern[1] == '*') {
			return true;
		}
		int strIndex = 0, patternIndex = 0;
		while (strIndex < str.length && patternIndex < pattern.length) {

			if (str[strIndex] == pattern[patternIndex]) {
				strIndex++;
				patternIndex++;
			} else {
				if (pattern[patternIndex] == '.') {
					pattern[patternIndex] = str[strIndex];
					strIndex++;
					patternIndex++;
				} else if (patternIndex + 1 < pattern.length
						&& pattern[patternIndex + 1] == '*') {
					patternIndex += 2;
				} else if (pattern[patternIndex] == '*') {
					if (patternIndex - 1 > 0
							&& pattern[patternIndex - 1] == str[strIndex]) {
						strIndex++;
					} else if (patternIndex - 1 > 0
							&& pattern[patternIndex - 1] != str[strIndex]) {
						patternIndex++;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		if (strIndex < str.length) {
			return false;
		}
		int i = pattern.length - 2;
		if (patternIndex < pattern.length) {

			if (pattern[pattern.length - 1] != '*') {
				return false;
			} else {
				char last = 0;

				for (; i >= patternIndex; i--) {
					if (i == pattern.length - 2) {
						last = pattern[i];
					} else {
						if (pattern[i] != last) {
							return false;
						}
					}
				}
			}
		}
		if (i != patternIndex) {
			return false;
		}

		return true;
	}

	/**
	 * 链表中环的入口结点
	 * 
	 * @param pHead
	 * @return
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {

		if (pHead == null) {
			return null;
		}
		Set<ListNode> pHeadSet = new HashSet<>();
		while (pHead != null) {
			if (!pHeadSet.add(pHead)) {
				return pHead;
			}
			pHead = pHead.next;
		}

		return null;
	}

	/**
	 * 删除链表中重复的结点
	 * 
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication(ListNode pHead) {

		if (pHead == null) {
			return null;
		}
		Set<Integer> set = new HashSet<>();
		Set<Integer> dupSet = new HashSet<>();
		ListNode temp = pHead;
		while (temp != null) {
			if (!set.add(temp.val)) {
				dupSet.add(temp.val);
			}
			temp = temp.next;
		}
		ListNode newHead = new ListNode(0);
		temp = pHead;
		pHead = newHead;

		while (temp != null) {
			if (dupSet.add(temp.val)) {
				newHead.next = temp;
				newHead = newHead.next;
			}
			temp = temp.next;
		}
		newHead.next = null;
		return pHead.next;
	}

	/**
	 * 对称的二叉树
	 * 
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot) {

		return isSymmetrical(pRoot, pRoot);

	}

	boolean isSymmetrical(TreeNode pRootL, TreeNode pRootR) {

		if (pRootL == null && pRootR == null) {
			return true;
		}
		if (pRootL == null || pRootR == null) {
			return false;
		}

		if (pRootL.val != pRootR.val) {
			return false;
		}

		return isSymmetrical(pRootL.left, pRootR.right)
				&& isSymmetrical(pRootL.right, pRootR.left);

	}

	/**
	 * 按之字形顺序打印二叉树
	 * 
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> intResult = new ArrayList<>();

		if (pRoot == null) {
			return intResult;
		}
		// 按层遍历树
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
		ArrayList<TreeNode> item = new ArrayList<>();
		item.add(pRoot);
		result.add(item);
		ArrayList<TreeNode> temp = item;
		while (temp.size() > 0) {
			ArrayList<TreeNode> newItem = new ArrayList<>();
			for (int i = 0; i < temp.size(); i++) {
				TreeNode node = temp.get(i);
				if (node.left != null) {
					newItem.add(node.left);
				}
				if (node.right != null) {
					newItem.add(node.right);
				}
			}
			result.add(newItem);
			temp = newItem;
		}
		// 之子输出
		int order = 0;// 0:从左到右；1：从右到左；

		for (int i = 0; i < result.size(); i++) {
			ArrayList<TreeNode> TreeItem = result.get(i);
			ArrayList<Integer> resultItem = new ArrayList<>();
			if (order == 0) {
				for (int j = 0; j < TreeItem.size(); j++) {
					resultItem.add(TreeItem.get(j).val);
				}
				order = 1;
			} else if (order == 1) {
				for (int j = TreeItem.size() - 1; j >= 0; j--) {
					resultItem.add(TreeItem.get(j).val);
				}
				order = 0;
			}
			if (resultItem.size() > 0)
				intResult.add(resultItem);
		}

		return intResult;
	}

	/**
	 * 二叉搜索树的第k个结点
	 * 
	 * @param pRoot
	 * @param k
	 * @return
	 */
	TreeNode KthNode(TreeNode pRoot, int k) {

		if (pRoot == null || k <= 0) {
			return null;
		}
		List<TreeNode> result = new ArrayList<>();
		inOrder(pRoot, result);

		if (k - 1 >= result.size()) {
			return null;
		}

		return result.get(k - 1);
	}

	/**
	 * 中序遍历一棵树
	 */
	void inOrder(TreeNode pRoot, List<TreeNode> result) {

		if (pRoot == null) {
			return;
		}

		inOrder(pRoot.left, result);
		result.add(pRoot);
		inOrder(pRoot.right, result);
	}

	/**
	 * 
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int movingCount(int threshold, int rows, int cols) {

		if (rows + cols > threshold) {
			return 0;
		}
		
		return 0;

	}

	/**
	 * 背包问题
	 * 
	 * @param args
	 */
	public static void bb(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt() >> 10;
				sum += arr[i];
			}
			int[] dp = new int[sum / 2 + 1];
			for (int i = 0; i < n; i++) {
				for (int j = sum / 2; j >= arr[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
				}
			}
			System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
		}
	}
	
	

	/**
	 * 下虑：将左右孩子节点中较大的值与该元素交换，始终保持根节点的值大于孩子节点的值
	 * 
	 * @param array
	 * @param index
	 */
	private static void perDown(int[] a, int i, int n) {
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
	private static int leftChild(int i) {
		return i * 2 + 1;// 与二叉堆不同，index从0开始
	}

	/**
	 * 交换元素
	 * 
	 * @param a
	 * @param i
	 * @param i2
	 */
	private static void swap(int[] a, int index1, int index2) {
		// TODO Auto-generated method stub

		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	/**
	 * TopN:找到第N大的数
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int FindK2(int[] arr, int k) {

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

	public static void main(String args[]) {

		Solution solution = new Solution();
		int array[] = { 1, 2, 3, 4, 5 };
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node11 = new TreeNode(11);

		node8.left = node6;
		node8.right = node10;
		node6.left = node5;
		node6.right = node7;
		node10.left = node9;
		node10.right = node11;

		System.out.println(solution.Print(node8));
	}

}
