package org.algorithm.java.hyunjong.Algorithm.graph;

import java.util.LinkedList;

public class IsThereAWay {

	public class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

		public Node(int data){
			this.data = data;
			adjacent = new LinkedList<>();
			marked = false;
		}
	}

	private Node[] nodes;

	public IsThereAWay(int size){
		nodes = new Node[size];

		for(int i = 0; i<size;i++){
			nodes[i]= new Node(i);
		}
	}

	public void addEdge(int d1, int d2){
		Node n1 = nodes[d1];
		Node n2 = nodes[d2];

		if(!n1.adjacent.contains(n2)){
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)){
			n2.adjacent.add(n1);
		}
	}

	public boolean search(int a, int b){
		return search(nodes[a], nodes[b]);
	}

	//bfs
	public boolean search(Node start, Node end){
		LinkedList<Node> q = new LinkedList<>();

		q.add(start);
		start.marked = true;

		while(!q.isEmpty()){
			Node enqueue = q.pollFirst();
			if(enqueue.equals(end)) return true;
			for(Node adjacentNode : enqueue.adjacent){
				if(!adjacentNode.marked){
					q.add(adjacentNode);
					adjacentNode.marked = true;
				}
			}
		}
		return false;
	}
}
