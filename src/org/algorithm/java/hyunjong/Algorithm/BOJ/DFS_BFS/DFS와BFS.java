package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		List<Integer>[] edges = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}

		for(int i=1;i<=N;i++){
			Collections.sort(edges[i]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dfs(edges, V, N)).append("\n");
		sb.append(bfs(edges, V, N)).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static String dfs(List<Integer>[] edges, int V, int N) {
		boolean[] check = new boolean[N + 1];
		StringBuilder sb = new StringBuilder();

		recursive(edges, check, sb, V);

		return sb.toString();
	}

	static void recursive(List<Integer>[] edges, boolean[] check, StringBuilder sb, int node) {
		if (check[node])
			return;
		check[node] = true;
		sb.append(node).append(" ");

		for (int link : edges[node]) {
			if (check[link])
				continue;
			recursive(edges, check, sb, link);
		}
	}

	static String bfs(List<Integer>[] edges, int V, int N) {
		boolean[] check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		queue.offer(V);
		check[V] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");

			for (int link : edges[current]) {
				if (check[link])
					continue;
				check[link] = true;
				queue.offer(link);
			}
		}

		return sb.toString();
	}
}
