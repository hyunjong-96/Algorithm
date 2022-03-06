package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 포도주 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int dp[] = new int[N + 1];
		int cost[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}
		dp[1] = cost[1];

		for (int i = 2; i <= N; i++) {
			if (i == 2) {
				dp[i] = dp[i - 1] + cost[i];
			} else {
				dp[i] = Math.max(Math.max(dp[i - 3] + cost[i - 1] + cost[i], dp[i - 2] + cost[i]), dp[i - 1]);
			}
		}

		System.out.println(dp[N]);
	}
	//이 방식을 사용하면
	// public static void main(String[] args) {
	// 	Scanner sc = new Scanner(System.in);
	//
	// 	int N = sc.nextInt();
	// 	int[][] dp = new int[N][2];
	// 	for (int i = 0; i < N; i++) {
	// 		int p = sc.nextInt();
	// 		dp[i][0] = p;
	// 		dp[i][1] = p;
	// 	}
	//
	// 	for (int i = 1; i < N; i++) {
	// 		if (i == 1) {
	// 			dp[i][0] += dp[i - 1][0];
	// 		} else {
	// 			dp[i][0] += dp[i - 1][1];
	// 			dp[i][1] += Math.max(dp[i - 2][0], dp[i - 2][1]);
	// 		}
	// 	}
	//
	// 	int max = -1;
	// 	for (int i = 0; i < N; i++) {
	// 		int compare = Math.max(dp[i][0],dp[i][1]);
	// 		if(compare>max) max = compare;
	// 	}
	// 	System.out.println(max);
	// }
}
