package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조.세그먼트트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기 {
	static long[] tree;
	static long[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		nums = new long[N+1];
		tree = new long[4 * N];

		for (int i = 1; i <= N; i++) {
			long num = Long.parseLong(br.readLine());
			nums[i] = num;
		}

		segmentTreeInit(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int l = 0; l < M + K; l++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long dif = c - nums[b];
				nums[b] = c;
				update(1, N, 1, b, dif);
			} else if(a==2) {
				long sum = sum(1, N, 1, b, (int)c);
				sb.append(sum);
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static long sum(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	static void update(int start, int end, int node, int index, long dif) {
		if (index < start || end < index)
			return;

		tree[node] += dif;

		if (start == end)
			return;

		int mid = (start + end) / 2;
		update(start, mid, node * 2, index, dif);
		update(mid + 1, end, node * 2+1, index, dif);
	}

	static long segmentTreeInit(int start, int end, int node) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;

		return tree[node] = segmentTreeInit(start, mid, node * 2) + segmentTreeInit(mid + 1, end, node * 2 + 1);
	}
}
