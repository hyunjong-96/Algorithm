package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] stairs = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			stairs[i] = sc.nextInt();
		}

		dp[0] = stairs[0];

		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[1] = stairs[1] + stairs[0];
			} else if (i == 2) {
				dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
			} else {
				dp[i] = Math.max(stairs[i-1]+dp[i-3], dp[i-2]) + stairs[i];
			}
		}

		System.out.println(dp[N-1]);
	}
}
