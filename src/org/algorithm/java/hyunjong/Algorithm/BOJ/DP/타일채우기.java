package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 타일채우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		if (N >= 2)
			dp[2] = 3;
		int subSum = 0;
		for (int i = 4; i <= N; i += 2) {
			subSum += dp[i - 4] * 2;
			dp[i] = (dp[i - 2] * 3) + subSum;
			// if (i == 2) {
			// 	dp[2] = 3;
			// }else if (i == 4)
			// 	dp[4] = 11;
			// else {
			// 	for (int j = 0; j < i - 2; j += 2) {
			// 		dp[i] += dp[j] * 2;
			// 	}
			// 	dp[i] += dp[i - 2] * 3 ;
			// }
		}

			System.out.println(dp[N]);
	}
}
