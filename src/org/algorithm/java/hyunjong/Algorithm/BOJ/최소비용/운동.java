package org.algorithm.java.hyunjong.Algorithm.BOJ.최소비용;

import java.io.*;
import java.util.StringTokenizer;

public class 운동 {
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] dp = new int[V + 1][V + 1];

		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				dp[i][j] = INF;
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[a][b] = c;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}

		int result = INF;
		for (int i = 1; i <= V; i++) {
			result = Math.min(result, dp[i][i]);
		}
		if(result == INF) result = -1;

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
