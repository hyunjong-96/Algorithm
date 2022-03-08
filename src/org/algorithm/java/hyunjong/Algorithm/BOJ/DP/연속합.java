package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sequence = new int[N];
		long[] dp = new long[N];

		for(int i=0;i<N;i++){
			sequence[i] = sc.nextInt();
		}
		dp[0] = sequence[0];

		for (int i = 1; i < N; i++) {
			//자기자신, 자기자신+바로 뒤의 값, 자기자신+연속된값 중 가장 큰값을 dp에 저장
			dp[i] = Math.max(sequence[i], Math.max(dp[i-1]+sequence[i], sequence[i]+sequence[i-1]));
		}

		long max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			if(dp[i]>max) max = dp[i];
		}
		System.out.println(max);
	}
}
