package org.algorithm.java.hyunjong.Algorithm;

import java.io.*;
import java.util.StringTokenizer;
public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=M;j++){
				dp[i][j] = dp[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for(int k=0;k<K;k++){
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int sum = 0;
			for(int r = i;r<=x;r++){
				sum += dp[r][y]-dp[r][j-1];
			}
			sb.append(sum).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}