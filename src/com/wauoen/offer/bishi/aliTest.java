package com.wauoen.offer.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/*
8
0000***0
0*0000*0
00**0**0
00000000
00**0000
00000*00
00000***
*****000
*/
public class aliTest {

	static class Node {
		int x;
		int y;
	}

	static int counter = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			char[] chs = sc.nextLine().toCharArray();
			arr[i] = chs;
		}
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == '*') {
					Node node = new Node();
					node.x = i;
					node.y = j;
					nodes.add(node);
				}
			}
		}

		Collections.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node node1, Node node2) {

				if (Math.abs(node2.x - node1.x) <= 1
						&& Math.abs(node2.y - node1.y) <= 1) {
					return 0;
				}
				return -1;
			}
		});

		List<ArrayList<Node>> result = new ArrayList<ArrayList<Node>>();

		for (Node node : nodes) {
			ArrayList<Node> item = new ArrayList<>();
			item.add(node);
			result.add(item);
		}

		ArrayList<Integer> indexs = new ArrayList<>();

		List<ArrayList<Node>> subItem = new ArrayList<ArrayList<Node>>();
		while (true) {
			for (int i = 0; i < result.size(); i++) {
				ArrayList<Node> list1 = result.get(i);
				for (int j = 0; j < result.size(); j++) {

					if (i != j && !indexs.contains(i) && !indexs.contains(j)) {
						ArrayList<Node> list2 = result.get(j);
						ArrayList<Node> merged = mergeList(list1, list2);
						if (merged != null && merged.size() != 0) {
							subItem.add(merged);
							indexs.add(j);
							indexs.add(i);
							break;
						}
					}
				}
			}
			for (int i = 0; i < result.size(); i++) {
				if(!indexs.contains(i)){
					subItem.add(result.get(i));
				}
			}
			if(subItem.size() == result.size()){
				
				break;
			}else{
				result.clear();
				result.addAll(subItem);
				subItem.clear();
				indexs.clear();
			}
		}
		
		System.out.println(subItem.size());

	}

	private static ArrayList<Node> mergeList(ArrayList<Node> list1,
			ArrayList<Node> list2) {

		ArrayList<Node> result = null;

		boolean eq = false;
		for (int i = 0; i < list1.size(); i++) {
			Node node1 = list1.get(i);
			for (int j = 0; j < list2.size(); j++) {
				Node node2 = list2.get(j);
				if (Math.abs(node2.x - node1.x) <= 1
						&& Math.abs(node2.y - node1.y) <= 1) {
					eq = true;
				}
			}
		}
		if (eq) {
			result = new ArrayList<>();
			result.addAll(list1);
			result.addAll(list2);
		}
		return result;
	}

}
