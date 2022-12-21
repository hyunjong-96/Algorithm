package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.위상정렬;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class 줄세우기 {
	static int[] indegree;
	static List<Integer>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		edges = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edges[A].add(B);
			edges[B].add(A);
			indegree[B]++;
		}

		Queue<Integer> result = topologySort(N);

		StringBuilder sb = new StringBuilder();
		while (!result.isEmpty()) {
			sb.append(result.poll()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static Queue<Integer> topologySort(int N) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			result.offer(current);

			for (int link : edges[current]) {
				if (indegree[link] == 0)
					continue;

				indegree[link]--;

				if (indegree[link] == 0) {
					queue.offer(link);
				}
			}
		}

		return result;
	}
}