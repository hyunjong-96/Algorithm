package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 케빈베이컨의6단계법칙_다잌 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] relation = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			relation[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relation[A].add(B);
			relation[B].add(A);
		}

		int answer = 0;
		int minKavinBakun = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int kavinBakun = dijkstra(relation, i, N);
			if (minKavinBakun > kavinBakun) {
				answer = i;
				minKavinBakun = kavinBakun;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int dijkstra(List<Integer>[] relation, int start, int N) {
		int totalKavinBakun = 0;
		boolean[] check = new boolean[N + 1];
		// PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		// 	return o1[1] - o2[1];
		// });
		Queue<int[]> pq = new ArrayDeque<>();

		pq.offer(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] current = pq.poll();

			if (check[current[0]])
				continue;
			totalKavinBakun += current[1];
			check[current[0]] = true;

			for (int friend : relation[current[0]]) {
				pq.offer(new int[] {friend, current[1] + 1});
			}
		}

		return totalKavinBakun;
	}
}