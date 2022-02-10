package org.algorithm.java.hyunjong.Algorithm.stack;

public class Stack<T> {

	class Node<T> {
		private T data;
		private Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	public T pop(){
		if(top == null){
			throw new NullPointerException("stack이 비어있습니다.");
		}

		T result = top.data;
		top = top.next;

		return result;
	}

	public void push(T data){
		Node<T> newData = new Node<T>(data);
		newData.next = top;
		top = newData;
	}

	public T peek(){
		if(top == null){
			throw new NullPointerException("stack이 비어있습니다.");
		}
		return top.data;
	}

	public boolean isEmpty(){
		return top == null;
	}
}
