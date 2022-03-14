package org.algorithm.java.hyunjong.Algorithm.BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 스택 {
	static private MyStack top;
	static private int size;

	static class MyStack {
		int data;
		MyStack next;

		public MyStack(int data, MyStack next) {
			this.data = data;
			this.next = next;
		}
	}

	static void push(int data) {
		top = new MyStack(data, top);
		size++;
	}

	static int pop() {
		if (top == null)
			return -1;
		int result = top.data;
		top = top.next;
		size--;
		return result;
	}

	static int size() {
		return size;
	}

	static int empty() {
		if (top == null)
			return 1;
		return 0;
	}

	static int top() {
		if (top == null)
			return -1;
		return top.data;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String method = st.nextToken();
			int data;
			switch (method) {
				case "push":
					data = Integer.parseInt(st.nextToken());
					push(data);
					break;
				case "pop":
					sb.append(pop());
					sb.append("\n");
					break;
				case "size":
					sb.append(size());
					sb.append("\n");
					break;
				case "empty":
					sb.append(empty());
					sb.append("\n");
					break;
				default:
					sb.append(top());
					sb.append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
