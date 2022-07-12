package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간곱구하기 {
	static long[] tree;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		tree = new long[N * 4];
		num = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			num[i] = n;
		}

		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(1, N, 1, b, c);
			} else {
				long result = find(1, N, 1, b, c)%1000000007;
				sb.append(result);
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static long find(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return 1;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return (find(start, mid, node * 2, left, right) * find(mid + 1, end, node * 2 + 1, left, right))%1000000007;
	}

	static long update(int start, int end, int node, int idx, int dif) {
		if (idx < start || end < idx)
			return tree[node];

		if (start == end && start == idx)
			return tree[node] = dif;

		int mid = (start + end) / 2;

		return tree[node] = (update(start, mid, node * 2, idx, dif) * update(mid + 1, end, node * 2 + 1, idx, dif))%1000000007;
	}

	static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = num[start];

		int mid = (start + end) / 2;

		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1))%1000000007;
	}
}
