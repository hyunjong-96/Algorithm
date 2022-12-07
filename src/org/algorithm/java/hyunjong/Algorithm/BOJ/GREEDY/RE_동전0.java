package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.StringTokenizer;

public class RE_동전0 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		answer = 0;
		makeCoin(coins, N, K, 0);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void makeCoin(int[] coins, int N, int K, int count) {
		if(K <= 0) answer = count;
		for (int i = N - 1; i >= 0; i--) {
			if (K / coins[i] >0) {
				makeCoin(coins, N, K%coins[i], count+K/coins[i]);
				break;
			}
		}
	}
}
