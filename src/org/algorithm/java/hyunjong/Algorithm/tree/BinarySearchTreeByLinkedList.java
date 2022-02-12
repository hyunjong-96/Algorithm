package org.algorithm.java.hyunjong.Algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTreeByLinkedList {

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public BinarySearchTreeByLinkedList(int[] a) {
		root = makeTree(a, 0, a.length - 1);
	}

	public Node makeTree(int[] a, int start, int end) {
		if (start > end)
			return null;

		int pivot = (start + end) / 2;
		Node root = new Node(a[pivot]);

		root.left = this.makeTree(a, start, pivot - 1);
		root.right = this.makeTree(a, pivot + 1, end);

		return root;
	}

	public ArrayList<LinkedList<Node>> BSTToList() {
		ArrayList<LinkedList<Node>> lists = new ArrayList<>();
		BSTtoList(lists, root, 0);
		return lists;
	}

	//이진탐색리스트 by 재귀함수
	public void BSTtoList(ArrayList<LinkedList<Node>> lists, Node root, int level) {
		if (root == null)
			return;

		LinkedList<Node> levelLinkedList;
		if (lists.size() == level) {
			levelLinkedList = new LinkedList<>();
			lists.add(levelLinkedList);
		} else {
			levelLinkedList = lists.get(level);
		}
		levelLinkedList.push(root);

		BSTtoList(lists, root.left, level + 1);
		BSTtoList(lists, root.right, level + 1);
	}

	//이진탐색리스트 by BFS
	public ArrayList<LinkedList<Node>> BSTtoList2(){
		ArrayList<LinkedList<Node>> result = new ArrayList<>();
		LinkedList<Node> current = new LinkedList<>(); //현재 level의 node저장;

		if(root != null){
			current.add(root);
		}

		while (current.size() > 0){
			result.add(current);
			LinkedList<Node> parentsList = current;
			current = new LinkedList<>();

			for(Node parents : parentsList){
				if(parents.left != null) current.add(parents.left);
				if(parents.right != null) current.add(parents.right);
			}
		}

		return result;
	}

	public void printList(ArrayList<LinkedList<Node>> arr){
		for(LinkedList<Node> list : arr){
			for(Node node : list){
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
