package org.algorithm.java.hyunjong.Algorithm.tree;

public class Tree {
	private Node root;

	public void setRoot(Node root){
		this.root = root;
	}

	public Node getRoot(){
		return this.root;
	}

	public Node makeNode(Node left, int data, Node right){
		return new Node(left, data, right);
	}

	public class Node{
		int data;
		Node left;
		Node right;

		public Node(Node left, int data, Node right){
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}

	//left, root, right
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	//root, left, right
	public void preOrder(Node node){
		if(node != null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//left, right, root
	public void postOrder(Node node){
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}

	public boolean isBalance(){
		return checkBalance(root);
	}

	private boolean checkBalance(Node root){
		if(root == null) return true;

		int leftCount = subCount(root.left);
		int right = subCount(root.right);

		return Math.abs(leftCount - right) <= 1;
	}

	private int subCount(Node root){
		if(root == null) return 0;

		int leftCount = subCount(root.left);
		int rightCount = subCount(root.right);

		return leftCount + rightCount + 1;
	}
}
