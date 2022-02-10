package org.algorithm.java.hyunjong.Algorithm.Queue;

public class Queue<T> {
	class Node<T>{
		private T data;
		private Node<T> next;

		public Node(T data){
			this.data = data;
		}
	}

	private Node<T> first;
	private Node<T> last;

	public void add(T data){
		Node<T> newData = new Node<T>(data);

		if(last != null){
			last.next = newData;
		}
		last = newData;

		if(first == null){
			first = last;
		}
	}

	public T remove(){
		if(first == null){
			throw new NullPointerException("queue가 비어있습니다");
		}

		Node<T> removeNode = first;
		first = first.next;

		if(first == null){
			last = null;
		}
		return removeNode.data;
	}

	public T peek(){
		if(first == null){
			throw new NullPointerException("queue가 비어있습니다");
		}
		return first.data;
	}

	public boolean isEmpty(){
		return first == null;
	}
}
