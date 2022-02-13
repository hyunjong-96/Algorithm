package org.algorithm.java.hyunjong.Algorithm.tree;

import java.util.ArrayList;
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
		root.left.right.left = new Node(12);
	}

	public Node makeTree(int[] a, int start, int end) {
		int pivot = (start + end) / 2;

		Node root = new Node(a[pivot]);
		if (start > end) {
			return null;
		}

		// int[] leftArray = Arrays.copyOfRange(a, 0, pivot);
		// int[] rightArray = Arrays.copyOfRange(a, pivot+1, end+1);
		root.left = makeTree(a, start, pivot - 1);
		root.right = makeTree(a, pivot + 1, end);
		return root;
	}

	public Node getRoot() {
		return root;
	}

	public void searchBTree(Node n, int find) {
		if (n == null) {
			System.out.println("Not found Data");
		}

		if (find < n.data) {
			System.out.println("Data is smaller than " + n.data);
			searchBTree(n.left, find);
		} else if (find > n.data) {
			System.out.println("Data is bigger than " + n.data);
			searchBTree(n.right, find);
		} else {
			System.out.println("Data found " + n.data);
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

	public boolean isValidateBST1() {
		ArrayList<Integer> inorderList = new ArrayList<>();
		inorder(root, inorderList);

		for (int i = 0; i < inorderList.size()-1; i++) {
			if(inorderList.get(i) > inorderList.get(i+1)){
				System.out.println(i + " ");
				return false;
			}
		}

		return true;
	}

	private void inorder(Node root, ArrayList<Integer> inorderList) {
		if (root == null)
			return;

		inorder(root.left, inorderList);
		inorderList.add(root.data);
		inorder(root.right, inorderList);
	}

	Node lastNode = null;
	public boolean isValidateBST2(){
		return isValidateBST2(root);
	}

	private boolean isValidateBST2(Node root){
		if(root == null) return true;


		if(!isValidateBST2(root.left)) return false;
		if(lastNode != null && root.data < lastNode.data){
			return false;
		}
		lastNode = root;
		return isValidateBST2(root.right);
	}
}
