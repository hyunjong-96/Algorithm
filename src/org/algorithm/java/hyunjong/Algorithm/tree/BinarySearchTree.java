package org.algorithm.java.hyunjong.Algorithm.tree;

import java.util.Arrays;

public class BinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public BinarySearchTree(int[] a) {
		root = makeTree(a, 0, a.length - 1);
	}

	public Node makeTree(int[] a, int start, int end) {
		int pivot = (start+end)/2;

		Node root = new Node(a[pivot]);
		if(start > end){
			return null;
		}

		// int[] leftArray = Arrays.copyOfRange(a, 0, pivot);
		// int[] rightArray = Arrays.copyOfRange(a, pivot+1, end+1);
		root.left = makeTree(a, start, pivot-1);
		root.right = makeTree(a, pivot+1, end);
		return root;
	}

	public Node getRoot(){
		return root;
	}

	public void searchBTree (Node n, int find){
		if(n == null){
			System.out.println("Not found Data");
		}

		if(find < n.data){
			System.out.println("Data is smaller than "+n.data);
			searchBTree(n.left, find);
		}else if(find > n.data){
			System.out.println("Data is bigger than "+n.data);
			searchBTree(n.right, find);
		}else{
			System.out.println("Data found "+n.data);
		}
	}

	// public boolean isBalance(){
	// 	return checkBalance(root);
	// }
	//
	// private boolean checkBalance(Node root){
	// 	if(root == null) return true;
	//
	// 	int leftCount = subCount(root.left);
	// 	int right = subCount(root.right);
	//
	// 	if(Math.abs(leftCount-right) > 1) return false;
	//
	// 	return checkBalance(root.left) && checkBalance(root.right);
	// }
	//
	// private int subCount(Node root){
	// 	if(root == null) return 0;
	//
	// 	int leftCount = subCount(root.left);
	// 	int rightCount = subCount(root.right);
	//
	// 	return leftCount + rightCount;
	// }
}
