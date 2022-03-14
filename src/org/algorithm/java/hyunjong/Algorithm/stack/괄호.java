package org.algorithm.java.hyunjong.Algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호 {
	static MyStack<String>[] stackArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		stackArray = new MyStack[N];
		for (int i = 0; i < N; i++) {
			stackArray[i] = new MyStack<>();
			String[] array = br.readLine().split("");

			for (String s : array) {
				if(!stackArray[i].isEmpty()){
					if(stackArray[i].peek().equals("(") && s.equals(")")) stackArray[i].pop();
					else stackArray[i].push(s);
				}else stackArray[i].push(s);
			}
		}

		for (int i = 0; i < N; i++) {
			MyStack<String> currentStack = stackArray[i];

			if(currentStack.isEmpty()) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}

		System.out.println(sb);
	}

	static class MyStack<T> {

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
}
