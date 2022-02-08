package org.algorithm.java.hyunjong.Algorithm.LinkedList;

public class Linked_List_One_Way {
	int data;
	Linked_List_One_Way next = null;

	public Linked_List_One_Way(int data){
		this.data = data;
	}

	public void append(int data){
		Linked_List_One_Way end = new Linked_List_One_Way(data);
		Linked_List_One_Way n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	public void delete(int data){
		Linked_List_One_Way n = this;

		while(n.next != null){
			if(n.next.data == data){
				n.next = n.next.next;
			}else{
				n = n.next;
			}
		}
	}

	public void retrieve(){
		Linked_List_One_Way n = this;

		while (n.next != null){
			System.out.print(n.data+ " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
