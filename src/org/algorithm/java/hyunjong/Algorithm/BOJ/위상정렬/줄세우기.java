package org.algorithm.java.hyunjong.Algorithm.BOJ.위상정렬;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class 줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		List<Integer>[] edges = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());

			indegree[back]++;
			edges[front].add(back);
		}

		Queue<Integer> result = topologicSort(indegree, edges);
		StringBuilder sb = new StringBuilder();
		while (!result.isEmpty()) {
			sb.append(result.poll()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static Queue<Integer> topologicSort(int[] indegree, List<Integer>[] edges) {
		Queue<Integer> result = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			result.offer(current);

			for (int edge : edges[current]) {
				indegree[edge]--;

				if (indegree[edge] == 0) {
					queue.offer(edge);
				}
			}
		}

		return result;
	}
}