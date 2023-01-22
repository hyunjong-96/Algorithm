package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class 만들기1_2 {
	static int[] dp;
	static String[] routes;
	static int MAX_VALUE = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		routes = new String[N + 1];

		Arrays.fill(dp, MAX_VALUE);
		bfs(N);

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(dp[1])).append("\n");
		sb.append(routes[1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void bfs(int N) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(N, 0, String.valueOf(N)));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int num = current.num;
			int depth = current.depth;
			String route = current.route;
			if (num < 1 || dp[num] <= depth)
				continue;

			dp[num] = depth;
			routes[num] = route;

			if (num == 1)
				break;

			if (num % 3 == 0)
				queue.offer(new Node(num / 3, depth + 1, route + " " + (num / 3)));
			if (num % 2 == 0)
				queue.offer(new Node(num / 2, depth + 1, route + " " + (num / 2)));
			queue.offer(new Node(num - 1, depth + 1, route + " " + (num - 1)));
		}
	}

	static class Node {
		int num;
		int depth;
		String route;

		public Node(int num, int depth, String route) {
			this.num = num;
			this.depth = depth;
			this.route = route;
		}
	}
}
