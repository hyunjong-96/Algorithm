package org.algorithm.java.hyunjong.Algorithm.LinkedList;

public class LinkedListNode {
	Node header = new Node();

	public class Node {
		int data;
		Node next = null;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}
	}

	public void append(int data) {
		Node n = header;
		Node end = new Node(data);
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void delete(int data) {
		Node n = header;

		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	public void retrieve() {
		Node n = header.next;    //header에 아무것도 넣지않으면 npe 발생

		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}

	//뒤에서 k번째에 있는 노드의 data를 찾음
	public void KthToLast(Node first, int k) {
		Node node = first;
		int length = 0;

		if(first.next != null){
			while (node.next != null) {
				length++;
				node = node.next;
			}

			if (length > 0) {
				length++;
			}

			node = first;
			for (int i = 0; i < length - k; i++) {
				node = node.next;
			}
		}

		System.out.println("뒤에서 " + k + "째 node의 값은 " + node.data);
	}
}
