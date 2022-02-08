package org.algorithm.java.hyunjong.Algorithm.LinkedList;

import java.util.HashSet;
import java.util.Iterator;

public class Linked_List_Node_Duplicate {
	Node header = new Node();

	public class Node{
		int data;
		Node next = null;

		public Node(){}

		public Node(int data){
			this.data = data;
		}
	}

	public void append(int data){
		Node n = header;

		while(n.next != null){
			n = n.next;
		}
		n.next = new Node(data);
	}

	public void remove(int data){
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

	public void duplicateDelete_with_buffer(){
		HashSet<Integer> buffer = new HashSet<Integer>();

		Node n = header.next;
		while (n.next != null){
			buffer.add(n.data);
			n = n.next;
		}

		for (Integer node : buffer) {
			System.out.print(node + " ");
		}
		System.out.println();
	}

	public void duplicateDelete_with_out_buffer(){
		Node n = header;

		while (n.next != null){
			Node r = n;

			while(r.next != null){
				if(n.data == r.next.data){
					r.next = r.next.next;
				}else{
					r = r.next;
				}
			}

			n = n.next;
		}
	}
}
