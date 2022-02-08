package org.algorithm.java.hyunjong.Algorithm.LinkedList;

public class Linked_List_Node {
	Node header = new Node();

	class Node{
		int data;
		Node next = null;

		public Node(){}

		public Node(int data){
			this.data = data;
		}
	}

	public void append(int data){
		Node n = header;
		Node end = new Node(data);
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	public void delete(int data){
		Node n = header;

		while(n.next != null){
			if(n.next.data == data){
				n.next = n.next.next;
			}else{
				n = n.next;
			}
		}
	}

	public void retrieve(){
		Node n = header.next;	//header에 아무것도 넣지않으면 npe 발생

		while(n.next != null){
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
