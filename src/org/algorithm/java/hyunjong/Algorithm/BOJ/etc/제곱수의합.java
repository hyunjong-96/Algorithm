package org.algorithm.java.hyunjong.Algorithm.BOJ.etc;

import java.util.Scanner;

public class 제곱수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		dp[1]=1;

		for (int i = 2; i <= N; i++) {
			dp[i] = i;
			for (int j = 2; j*j <= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}

		System.out.println(dp[N]);
	}
}
