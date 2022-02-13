package org.algorithm.java.hyunjong.Algorithm.tree;

public class BinarySearchWithParents {

	public class Node{
		int data;
		public Node left;
		public Node right;
		Node parents;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node root;

	public BinarySearchWithParents(int[] a) {
		root = makeTree(a, 0, a.length - 1, null);
	}

	public Node makeTree(int[] a, int start, int end, Node parents) {
		int pivot = (start + end) / 2;

		Node root = new Node(a[pivot]);
		if (start > end) {
			return null;
		}

		// int[] leftArray = Arrays.copyOfRange(a, 0, pivot);
		// int[] rightArray = Arrays.copyOfRange(a, pivot+1, end+1);
		root.left = makeTree(a, start, pivot - 1, root);
		root.right = makeTree(a, pivot + 1, end, root);
		root.parents = parents;
		return root;
	}

	public void findNext(Node root){
		if(root.right == null){
			System.out.println(root.data+"의 다음 노드 데이터는 "+findAbove(root.parents, root).data);
		}else{
			System.out.println(root.data + "의 다음 노드 데이터는 "+findBelow(root.right).data);
		}
	}

	private Node findAbove(Node parents, Node root){
		if(parents == null) return null;
		if(parents.left == root) return parents;
		return findAbove(parents.parents, parents);
	}

	private Node findBelow(Node root){
		if(root.left == null) return root;
		return findBelow(root.left);
	}
}
