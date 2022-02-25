package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//10844
public class 쉬운계단수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == 1)
					dp[i][j] = 1;
				else {
					if (j == 0)
						dp[i][j] = (dp[i - 1][1])%1000000000;
					else if (j == 9)
						dp[i][j] = (dp[i - 1][8])%1000000000;
					else
						dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%1000000000;
				}
			}
		}

		int sum = 0;
		for (int c = 1; c <= 9; c++) {
			sum+=(dp[N][c]);
			sum%=1000000000;
		}
		System.out.println(sum);
	}
}
