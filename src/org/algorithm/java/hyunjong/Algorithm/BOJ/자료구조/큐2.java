package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 큐2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		MyQueue queue = new MyQueue();

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String method = st.nextToken();

			switch (method) {
				case "push": {
					int e = Integer.parseInt(st.nextToken());
					queue.push(e);
					break;
				}
				case "pop": {
					sb.append(queue.pop());
					sb.append("\n");
					break;
				}
				case "size": {
					sb.append(queue.size());
					sb.append("\n");
					break;
				}
				case "empty": {
					sb.append(queue.empty());
					sb.append("\n");
					break;
				}
				case "front": {
					sb.append(queue.front());
					sb.append("\n");
					break;
				}
				case "back": {
					sb.append(queue.back());
					sb.append("\n");
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class MyQueue {
		List<Integer> ll;

		public MyQueue() {
			ll = new LinkedList<>();
		}

		public void push(int e) {
			ll.add(e);
		}

		public int pop() {
			int result = -1;
			if (!ll.isEmpty()) {
				result = ll.remove(0);
			}
			return result;
		}

		public int size() {
			return ll.size();
		}

		public int empty() {
			return ll.isEmpty() ? 1 : 0;
		}

		public int front() {
			int result = -1;
			if (!ll.isEmpty())
				result = ll.get(0);
			return result;
		}

		public int back() {
			int result = -1;
			if (!ll.isEmpty())
				result = ll.get(ll.size() - 1);
			return result;
		}
	}
}
