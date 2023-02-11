package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의합 {
	static int count;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		count = 0;
		find(0, 0L, S, N);

		if(S==0) count--;

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static void find(int idx, long sum, int target, int N) {
		if (sum == target) {
			count++;
		}


		for (int i = idx; i < N; i++) {
			find(i + 1, sum + seq[i], target, N);
		}
	}
}