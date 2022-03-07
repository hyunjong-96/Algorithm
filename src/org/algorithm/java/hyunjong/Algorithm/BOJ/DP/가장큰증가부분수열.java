package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 가장큰증가부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sequence[] = new int[N];
		int dp[] = new int[N];

		for (int i = 0; i < N; i++) {
			int e = sc.nextInt();
			sequence[i] = e;
			dp[i] = e;
		}

		int max;
		for (int i = 1; i < N; i++) {
			max = 0;
			for (int j = 0; j < i; j++) {
				if(sequence[i]>sequence[j]){
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] += max;
		}

		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
