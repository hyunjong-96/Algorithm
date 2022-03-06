package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

//최장 증가 부분 수열(LIS, Longest Increasing Subsequence)
//최장 증가 부분 수열이란, 주어진 수열에서 각 원소가 이전 원소보다 크다는 조건을 만족하는 수열의 길이.
public class 가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Ai[] = new int[N];
		int dp[] = new int[N];

		for (int i = 0; i < N; i++) {
			Ai[i] = sc.nextInt();
			dp[i] = 1;
		}

		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(Ai[j]<Ai[i]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}

			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
}