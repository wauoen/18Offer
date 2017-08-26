package com.wauoen.offer.bishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Õ∑Ãı±  ‘
 * @author wauoen
 *
 */
public class TouTiaoBishi {
	
	static class Node{
		int x;
		int y;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());

		Node[] nodeArr = new Node[n];
		
		for (int i = 0; i < n; i++) {
			String[] nodeString = sc.nextLine().split(" ");
			Node node = new Node();
			node.x = Integer.parseInt(nodeString[0]);
			node.y = Integer.parseInt(nodeString[1]);
			nodeArr[i] = node;
		}
		
		List<Node> result = new ArrayList<>();
		boolean isMax = true;
		for (int i = 0; i < nodeArr.length; i++) {
			isMax = true;
			Node node = nodeArr[i];
			for (int j = 0; j < nodeArr.length; j++) {
				Node node2 = nodeArr[j];
				if(node2.x > node.x && node2.y > node.y){
					isMax = false;
					break;
				}
			}
			if (isMax) {
				result.add(node);
			}
		}
		Collections.sort(result, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.x < o2.x){
					return -1;
				}
				if(o1.x > o2.x){
					return 1;
				}
				return 0;
			}
		});
		

		for (Node node : result) {
			System.out.println(node.x + " "+node.y);
		}
		
	}

}
