package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class 바이러스_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer>[] edges = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}

		int result = bfs(N, edges);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static int bfs(int N, List<Integer>[] edges) {
		boolean[] check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(1);
		check[1] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			count++;

			for (int link : edges[current]) {
				if (!check[link]) {
					check[link] = true;
					queue.offer(link);
				}
			}
		}
		return count - 1;
	}
}
