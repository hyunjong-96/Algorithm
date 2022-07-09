package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//segmentTree를 활용하여 minTree에는 구간에서 가지는 가장 작은 값, maxTree는 구간에서 가지는 가장 큰 값을 저장한다.
//minFind에서 찾고자하는 구간을 찾게되면 그 구간에서의 최소값을 가져온다. 마찬가지로 maxFind에서는 찾고자하는 구간을 찾아서 그 중 큰 값을 가져온다.
public class 최솟값과최댓값 {
	static int[] nums;
	static int[] minTree;
	static int[] maxTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		minTree = new int[4 * N];
		maxTree = new int[4 * N];
		initMinTree(1, N, 1);
		initMaxTree(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// if(a==3 && b==5) System.out.println();
			sb.append(minFind(1, N, 1, a, b));
			sb.append(" ");
			sb.append(maxFind(1, N, 1, a, b));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int maxFind(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return 0;
		else if (left <= start && end <= right)
			return maxTree[node];

		int mid = (start + end) / 2;
		return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
	}

	static int minFind(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return Integer.MAX_VALUE;
		else if (left <= start && end <= right)
			return minTree[node];

		int mid = (start + end) / 2;
		return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
	}

	static int initMinTree(int start, int end, int node) {
		if (start == end)
			return minTree[node] = nums[start];

		int mid = (start + end) / 2;

		return minTree[node] = Math.min(initMinTree(start, mid, node * 2), initMinTree(mid + 1, end, node * 2+1));
	}

	static int initMaxTree(int start, int end, int node) {
		if (start == end)
			return maxTree[node] = nums[start];

		int mid = (start + end) / 2;

		return maxTree[node] = Math.max(initMaxTree(start, mid, node * 2), initMaxTree(mid + 1, end, node * 2 + 1));
	}
}
