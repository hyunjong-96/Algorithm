package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//11057
public class 오르막수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][10];

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];//dp[N][i]값은 N-1자리의 i값부터 9까지의 오르막 개수들의 합.
					dp[i][j] %= 10007;
				}
			}
		}

		int result=0;
		for(int i=0;i<10;i++){
			result+=dp[N][i] % 10007;
		}
		System.out.println(result%10007);
	}
}
