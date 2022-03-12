package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	static List<List<Integer>> tree;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList(N + 1);
		visit = new int[N + 1];

		visit[0] = -1;
		visit[1] = -1;

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			tree.get(first).add(end);
			tree.get(end).add(first);
		}

		bfs();

		for (int i = 2; i <= N; i++) {
			bw.write(String.valueOf(visit[i]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			List<Integer> edgeList = tree.get(node);
			for (int child : edgeList) {
				if (visit[child] == 0) {
					queue.add(child);
					visit[child] = node;
				}
			}
		}
	}
}
