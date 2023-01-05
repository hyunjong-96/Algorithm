package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class 보석도둑_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewelry[] jewelries = new Jewelry[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewelries[i] = new Jewelry(M, V);
		}

		Arrays.sort(jewelries, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o1.m-o2.m;
			}
		});

		int[] bags = new int[K];

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bags);

		PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.v - o1.v;
		});

		long answer = 0;
		int jIndex = 0;
		for (int i = 0; i < K; i++) {
			while (jIndex < N && bags[i] >= jewelries[jIndex].m) {
				pq.offer(jewelries[jIndex++]);
			}

			if (!pq.isEmpty())
				answer += pq.poll().v;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static class Jewelry {
		int m;
		int v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}