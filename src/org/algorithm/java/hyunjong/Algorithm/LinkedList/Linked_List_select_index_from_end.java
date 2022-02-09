package org.algorithm.java.hyunjong.Algorithm.LinkedList;

public class Linked_List_select_index_from_end extends LinkedListNode{
	LinkedListNode node;

	public Linked_List_select_index_from_end(){
		node = new LinkedListNode();
	}

	public void append(int data){
		node.append(data);
	}

	public void delete(int data){
		node.delete(data);
	}

	public void retrieve(){
		node.retrieve();
	}

	public Node get(int k){
		return node.get(k);
	}

	public void KthToLast(int k){
		super.KthToLast(node.header,k);
	}
}
