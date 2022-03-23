package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치함수 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		dp = new int[41][41];
		for(int i=0;i<=40;i++){
			setDp(i);
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N][0]).append(" ").append(dp[N][1]);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void setDp(int i) {
		if (i == 0)
			dp[0][0] = 1;
		else if (i == 1)
			dp[1][1] = 1;
		else {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
	}
}
