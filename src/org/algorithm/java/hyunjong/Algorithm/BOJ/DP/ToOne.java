package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//1463
public class ToOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			if(i+1<N+1){
				if(dp[i+1]==0) dp[i+1] = dp[i]+1;
				else if(dp[i+1]>dp[i]+1) dp[i+1] = dp[i]+1;
			}
			if(i*2<N+1){
				if(dp[i*2]==0) dp[i*2] = dp[i]+1;
				else if(dp[i*2]>dp[i]+1) dp[i*2] = dp[i]+1;
			}
			if(i*3<N+1){
				if(dp[i*3]==0) dp[i*3]=dp[i]+1;
				else if(dp[i*3]>dp[i]+1) dp[i*3] = dp[i]+1;
			}
		}

		System.out.println(dp[N]);
	}
}
