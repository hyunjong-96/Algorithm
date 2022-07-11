package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최솟값 {
	static int[] trees;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		trees = new int[N * 4];
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(find(1, N, 1, a, b));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int find(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return Integer.MAX_VALUE;
		if (start == end)
			return trees[node];
		if (left <= start && end <= right)
			return trees[node];

		int mid = (start + end) / 2;

		return Math.min(find(start, mid, node * 2, left, right), find(mid + 1, end, node * 2 + 1, left, right));
	}

	static int init(int start, int end, int node) {
		if (start == end)
			return trees[node] = nums[start];

		int mid = (start + end) / 2;

		return trees[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
}
