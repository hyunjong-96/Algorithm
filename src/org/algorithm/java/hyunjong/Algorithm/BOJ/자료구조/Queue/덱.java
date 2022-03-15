package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덱 {
	static class Deque {
		class Node {
			private int data;
			private Node next;
			private Node prev;

			public Node(int data) {
				this.data = data;
			}
		}

		private Node front;
		private Node back;
		int size = 0;

		void push_front(int data) {
			Node newNode = new Node(data);
			if (front == null) {
				back = newNode;
			} else {
				front.prev = newNode;
			}
			newNode.next = front;
			front = newNode;
			size++;
		}

		void push_back(int data) {
			Node newNode = new Node(data);
			if (back == null) {
				push_front(data);
				return;
			} else {
				back.next = newNode;
			}
			newNode.prev = back;
			size++;
			back = newNode;
		}

		int pop_front() {
			if (size == 0) {
				return -1;
			}

			Node element = front;
			Node nextNode = front.next;

			if (nextNode != null) {
				nextNode.prev = null;
			}
			front = nextNode;
			size--;

			if (front == null) {
				back = null;
			}

			return element.data;
		}

		int pop_back() {
			if (size == 0) {
				return -1;
			}

			Node element = back;
			Node prevNode = back.prev;

			if (prevNode != null) {
				prevNode.next = null;
			}
			back = prevNode;
			size--;

			if (back == null) {
				front = null;
			}

			return element.data;
		}

		int size() {
			return size;
		}

		int empty() {
			return size == 0 ? 1 : 0;
		}

		int front() {
			return size == 0 ? -1 : front.data;
		}

		int back() {
			return size == 0 ? -1 : back.data;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Deque deque = new Deque();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String method = st.nextToken();

			switch (method) {
				case "push_front":
					deque.push_front(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.push_back(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					sb.append(deque.pop_front()).append("\n");
					break;
				case "pop_back":
					sb.append(deque.pop_back()).append("\n");
					break;
				case "front":
					sb.append(deque.front()).append("\n");
					break;
				case "back":
					sb.append(deque.back()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.empty()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
