package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[3];

		for (int i = 0; i < N; i++) {
			int r = 0, g = 0, b = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			r = Math.min(dp[1], dp[2]) + Integer.parseInt(st.nextToken());
			g = Math.min(dp[0], dp[2]) + Integer.parseInt(st.nextToken());
			b = Math.min(dp[0], dp[1]) + Integer.parseInt(st.nextToken());

			dp[0] = r;
			dp[1] = g;
			dp[2] = b;
		}

		int min = Math.min(dp[0], Math.min(dp[1], dp[2]));
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}
}
