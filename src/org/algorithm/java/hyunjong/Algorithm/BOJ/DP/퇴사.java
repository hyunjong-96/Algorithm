package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;
public class 퇴사{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		for(int i=1;i<=N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());

		}
		int[] dp = new int[N+2];

		for(int i=N;i>0;i--){
			if(i+T[i] > N+1) dp[i] = dp[i+1];
			else{
				dp[i] = Math.max(dp[i+T[i]]+P[i], dp[i+1]);
			}
		}

		bw.write(String.valueOf(dp[1]));
		bw.flush();
		bw.close();
	}
}
