package org.algorithm.java.hyunjong.Algorithm.graph;

import java.util.LinkedList;
import java.util.Stack;

import org.algorithm.java.hyunjong.Algorithm.Queue.Queue;

public class Graph {

	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

		public Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<>();
		}
	}

	Node[] nodes;

	public Graph(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	public void addEdge(int data1, int data2) {
		Node n1 = nodes[data1];
		Node n2 = nodes[data2];

		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}

		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

	public void dfs() {
		dfs(0);
	}

	public void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<>();

		stack.push(root);
		root.marked = true;
		while (!stack.isEmpty()) {
			Node me = stack.pop();

			for (Node adjacentNode : me.adjacent) {
				if (!adjacentNode.marked) {
					adjacentNode.marked = true;
					stack.push(adjacentNode);
				}
			}

			System.out.print(me.data + " ");
		}

		System.out.println();
	}

	public void bfs() {
		bfs(0);
	}

	public void bfs(int index) {
		Queue<Node> queue = new Queue<>();

		Node root = nodes[index];

		queue.add(root);
		root.marked = true;
		while (!queue.isEmpty()) {
			Node me = queue.remove();

			for (Node adjacentNode : me.adjacent) {
				if (!adjacentNode.marked) {
					adjacentNode.marked = true;
					queue.add(adjacentNode);
				}
			}

			System.out.println(me.data + " ");
		}
		System.out.println();
	}

	public void dfsR(int index){
		Node root = nodes[index];
		dfsR(root);
	}

	public void dfsR(){
		dfsR(0);
	}

	public void dfsR(Node n) {
		if (n == null) {
			return;
		}
		n.marked = true;
		System.out.println(n.data);
		for(Node adjacentNode : n.adjacent){
			if(!adjacentNode.marked){
				dfsR(adjacentNode);
			}
		}
	}
}
