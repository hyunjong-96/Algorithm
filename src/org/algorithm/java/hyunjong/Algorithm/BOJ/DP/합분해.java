package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 합분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[N + 1][K];

		for (int x = 0; x < K; x++) {
			for (int y = 0; y <= N; y++) {
				if (x == 0) {
					dp[y][x] = 1;
				} else {
					for (int k = 0; k <= y; k++) {
						dp[y][x] += (dp[k][x - 1] % 1000000000);
					}
					dp[y][x] %= 1000000000;
				}
			}
		}
		System.out.println((dp[N][K - 1]) % 1000000000);
	}
}
