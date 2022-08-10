package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
https://loosie.tistory.com/229
dp[i] = do[i-j*j]+dp[j*j]
i 값의 특정 값의 제곱의 합으로 구할 수 있는 최소의 개수로 구해야한다.
dp[1]일때 1^1로 1이고 dp[4]일때 2^2로 1이고 dp[5]일때 2^2+1^1로 dp[5]는 dp[5 - 2^2] + 2^2로 구할 수 있다.
dp[j*j]는 j의 제곱으로 1개의 제곱으로 나타낼수 있기 때문에 1로 고정값이다.
dp[11339]는 105^2+15^2+8^2+5^2으로 구할 수 있지만 104^2+17^2+5^2가 최소의 값으로 3이다.
즉, dp[i-j*j]를 구할때 j를 1부터 j*j<=i가 될때까지 모든 경우의 수를 구해서 최소값을 dp[i]로 넣어줘야한다.
 */
public class FourSquares {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		for(int i=1;i<=N;i++){
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++){
				min = Math.min(min, dp[i-j*j]);
			}
			dp[i]= min+1;
		}

		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
	}
}
