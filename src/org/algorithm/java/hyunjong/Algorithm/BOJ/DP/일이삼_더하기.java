package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//9095
public class 일이삼_더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] ts = new int[T];
		for (int i = 0; i < T; i++) {
			ts[i] = sc.nextInt();
		}

		for (int N : ts) {
			int[] dp = new int[N + 1];
			dp[1] = 1;

			for (int i = 2; i <= N; i++) {
				if(i==2) {dp[i] = 2; continue;}
				if(i==3) {dp[i] = 4; continue;}

				dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
			}
			System.out.println(dp[N]);
		}
	}
}
