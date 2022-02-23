package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 순열_사이클 {
	static LinkedList<Integer>[] graph;
	static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			graph = new LinkedList[N];
			checked = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[j] = new LinkedList<>();
				graph[j].push(Integer.parseInt(st.nextToken()));
			}

			int count = 0;
			for (int k = 0; k < graph.length; k++) {
				if (!checked[k]) {
					bfs(k);
					count++;
				}
			}
			bw.write(String.valueOf(count));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs(int index) {
		Queue<Integer> queue = new LinkedList();
		queue.add(index);
		checked[index] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				if (!checked[next - 1]) {
					queue.add(next - 1);
					checked[next - 1] = true;
				}
			}
		}
	}
}
