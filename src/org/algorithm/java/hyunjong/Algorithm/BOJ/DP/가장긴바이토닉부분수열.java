package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 가장긴바이토닉부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sequence[] = new int[N];
		int dp[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			sequence[i] = sc.nextInt();
		}

		//왼쪽 파티션 증가 체크
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (sequence[j] < sequence[i]) {
					max = Math.max(max, dp[j][0]);
				}
			}
			dp[i][0] = max + 1;
		}

		for (int i = N - 1; i > -1; i--) {
			int max = 0;
			for (int j = N - 1; j > i; j--) {
				if (sequence[j] < sequence[i]) {
					max = Math.max(max, dp[j][1]);
				}
			}
			dp[i][1] = max + 1;
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			if((dp[i][0]+dp[i][1])>max){
				max = dp[i][0]+dp[i][1];
			}
		}
		System.out.println(max-1);
	}
}
