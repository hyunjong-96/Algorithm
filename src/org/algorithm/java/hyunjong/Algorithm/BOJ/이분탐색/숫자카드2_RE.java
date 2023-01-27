package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 숫자카드2_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] counts = new int[10000001];
		int[] mCounts = new int[10000001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n >= 0)
				counts[n]++;
			else
				mCounts[Math.abs(n)]++;
		}
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());

			if (target >= 0) {
				sb.append(counts[target]);
			} else {
				sb.append(mCounts[Math.abs(target)]);
			}
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
