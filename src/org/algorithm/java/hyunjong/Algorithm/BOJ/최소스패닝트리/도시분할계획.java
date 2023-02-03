package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class 도시분할계획 {
	static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {a, b, c});
		}

		union = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			union[i] = i;
		}

		int prevCost = 0;
		int result = 0;
		while (!pq.isEmpty()) {
			int[] current = pq.poll();

			if (find(current[0]) == find(current[1]))
				continue;

			union(current[0], current[1]);

			prevCost = current[2];
			result += current[2];
		}

		bw.write(String.valueOf(result - prevCost));
		bw.flush();
		bw.close();
	}

	static void union(int o1, int o2) {
		o1 = find(union[o1]);
		o2 = find(union[o2]);

		if (o1 < o2) {
			union[o2] = o1;
		} else {
			union[o1] = o2;
		}
	}

	static int find(int o1) {
		if (union[o1] == o1)
			return o1;
		return union[o1] = find(union[o1]);
	}
}