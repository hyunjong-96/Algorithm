package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐 {
	static class MyQueue {

		public MyQueue(){}
		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}

		Node front;
		Node back;
		int size;

		void push(int data) {
			Node newNode = new Node(data);
			if (back == null) {
				front = newNode;
			}
			else{
				back.next = newNode;
			}
			back = newNode;
			size++;
		}

		int pop() {
			if (front == null)
				return -1;
			Node node = front;
			front = front.next;
			if (front == null) {
				back = null;
			}
			size--;

			return node.data;
		}

		int size() {
			return size;
		}

		int empty() {
			return front == null ? 1 : 0;
		}

		int front() {
			return front != null ? front.data : -1;
		}

		int back() {
			return back != null ? back.data : -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		MyQueue queue = new MyQueue();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String method = st.nextToken();

			switch (method){
				case "push":
					queue.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(queue.pop()).append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					sb.append(queue.empty()).append("\n");
					break;
				case "front":
					sb.append(queue.front()).append("\n");
					break;
				case "back":
					sb.append(queue.back()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
