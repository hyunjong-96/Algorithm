package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//9465
public class 스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] dp;
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			dp = new int[2][];
			int[] firstRow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] secondRow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dp[0] = firstRow;
			dp[1] = secondRow;

			for (int i = 1; i < N; i++) {
				if(i == 1){
					dp[0][1] += dp[1][0];
					dp[1][1] += dp[0][0];
				}else{
					dp[0][i] += Math.max(dp[1][i-2],dp[1][i-1]);
					dp[1][i] += Math.max(dp[0][i-2],dp[0][i-1]);
				}
			}

			bw.write(String.valueOf(Math.max(dp[0][N-1],dp[1][N-1])));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
