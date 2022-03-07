package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 가장긴감소하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sequence[] = new int[N];
		int dp[] = new int[N];

		for (int i = 0; i < N; i++) {
			sequence[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if(sequence[j]>sequence[i]){
					max = Math.max(dp[j],max);
				}
			}
			dp[i] = max+1;
		}

		int max=0;
		for(int i=0;i<N;i++){
			if(dp[i]>max){
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
