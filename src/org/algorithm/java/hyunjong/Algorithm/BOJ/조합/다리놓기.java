package org.algorithm.java.hyunjong.Algorithm.BOJ.조합;

import java.io.*;
import java.util.StringTokenizer;

/*
조합을 사용하는 문제
nCr = n개중 r개 선택한 경우의 수
기존 공식 = n!/r!(n-r)!
심화 공식
	1) nCr == n-1Cr-1 + n-1Cr
	2) n==r이거나 r==0이라면 nCr는 항상 1이다
이를 파스칼 공식을 이용한것이라고하는데 이를 이용해서 nCr을 반환하는 함수를 만들어준다.
 */
public class 다리놓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] dp = new int[M+1][N+1];
			int answer = pascal(M, N, dp);

			sb.append(String.valueOf(answer));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int pascal(int n, int r, int[][] dp) {
		if(dp[n][r] > 0) return dp[n][r];

		if (n == r || r == 0) {
			dp[n][r] = 1;
			return 1;
		}

		return dp[n][r] = pascal(n - 1, r - 1, dp) + pascal(n - 1, r, dp);
	}
}
