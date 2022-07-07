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

	//세그먼트 트리의 특정 구간 합
	//시간 복잡도 : O(logN)
	//start : 구간의 시작점, end : 구간의 끝 점
	//left : 구간 합의 시작점, right : 구간 합의 끝 점
	//node : 현재 정점
	//합을 구하려는 구간에 start와 end가 없다면 0
	//포함되어있다면 해당 구간의 합을 반환한다.
	//그렇지 않다면 구간을 변경하여 합을 구하려는 구간에 start와 end가 포함되도록 재귀
	static long sum(int start, int end, int node, int left, int right) {
		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	//세그먼트 트리의 특정 노드 값 수정
	//시간 복잡도 : O(logN)
	//수정하려는 곳이 범위(start~end)에 존재하면 수정하려는 값을 트리의 값에 수정한다.(start==end==idx 일 때 까지)
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
	//세그먼트 트리 초기화
	//배열의 범위를 start~mid, mid+1~end로 나누어서 각 범위의 합을 저장
	static long segmentTreeInit(int start, int end, int node) {
		if (start == end)
			return tree[node] = nums[start];

		int mid = (start + end) / 2;

		return tree[node] = segmentTreeInit(start, mid, node * 2) + segmentTreeInit(mid + 1, end, node * 2 + 1);
	}
}
