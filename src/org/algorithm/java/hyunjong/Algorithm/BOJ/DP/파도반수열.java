package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		long[] P;
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			P = new long[N + 1];

			P[1] = 1;

			for (int j = 1; j <= N; j++) {
				if(j == 1||j==2||j==3) P[j] = 1;
				else if(j==4) P[j] = 2;
				else{
					P[j] = P[j-1] + P[j-5];
				}
			}
			System.out.println(P[N]);
		}
	}
}
