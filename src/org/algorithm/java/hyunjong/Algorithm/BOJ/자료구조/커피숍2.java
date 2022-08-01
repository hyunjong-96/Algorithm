package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
배열의 구간정보를 구해야할 때 N = 100000 이상일때 logN으로 구간정보(최소,최대,합)를 구할 수 있다.
 */
public class 커피숍2 {
	static long[] tree;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new long[4 * N];

		init(1, 1, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			long answer = sum(1, 1, N, x, y);
			update(1, 1, N, a, b);
			sb.append(answer);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) / 2;

		return tree[node] = init(2 * node, start, mid) + init(2 * node + 1, mid + 1, end);
	}

	static long sum(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return sum(2 * node, start, mid, left, right) + sum(2 * node + 1, mid + 1, end, left, right);
	}

	static long update(int node, int start, int end, int index, long val) {
		if (index < start || end < index)
			return tree[node];

		if (start == end) {
			arr[index] = val;
			return tree[node] = val;
		}

		int mid = (start + end) / 2;

		return tree[node] = update(2 * node, start, mid, index, val) + update(2 * node + 1, mid + 1, end, index, val);
	}
}
