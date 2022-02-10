package org.algorithm.java.hyunjong.Algorithm.Queue;

public class QueueByStack<T> {

	Stack<T> newStack = new Stack<>();
	Stack<T> oldStack = new Stack<>();

	public void add(T data){
		newStack.push(data);
	}

	public T remove(){
		// if(oldStack.isEmpty()){
		// 	if(newStack.isEmpty()){
		// 		throw new NullPointerException("큐가 비어있습니다");
		// 	}
		//
		// 	while(!newStack.isEmpty()){
		// 		oldStack.push(newStack.pop());
		// 	}
		// }
		shiftStack();
		return oldStack.pop();
	}

	public T peek(){
		// if(oldStack.isEmpty()){
		// 	if(newStack.isEmpty()){
		// 		throw new NullPointerException("큐가 비어있습니다");
		// 	}
		//
		// 	while(!newStack.isEmpty()){
		// 		oldStack.push(newStack.pop());
		// 	}
		// }
		shiftStack();

		return oldStack.peek();
	}

	public boolean isEmpty(){
		return oldStack.isEmpty() && newStack.isEmpty();
	}

	private void shiftStack(){
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}

	class Stack<T>{
		Node<T> top;

		public T pop(){
			if(top == null){
				throw new NullPointerException("스택이 비어있습니다");
			}

			Node<T> result = top;
			top = top.next;

			return result.data;
		}

		public void push(T data){
			Node<T> newData = new Node<T>(data);

			if(top != null){
				newData.next = top;
			}
			top = newData;
		}

		public T peek(){
			if(top == null){
				throw new NullPointerException("스택이 비어있습니다");
			}

			return top.data;
		}

		public boolean isEmpty(){
			return top == null;
		}
	}

	class Node<T>{
		T data;
		Node<T> next;

		public Node(T data){
			this.data = data;
		}
	}
}
