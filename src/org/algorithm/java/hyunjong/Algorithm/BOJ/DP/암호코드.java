package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 암호코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String pw = br.readLine();
		int N = pw.length();
		String[] sArray = pw.split("");

		int[] encode = new int[N + 1];
		for (int i = 0; i < N; i++) {
			encode[i + 1] = Integer.parseInt(sArray[i]);
		}

		if (encode[1] == 0) {
			bw.write('0');
			bw.flush();
			bw.close();

			return;
		}

		long[] dp = new long[N + 1];
		dp[1] = 1;
		dp[0] = 1;

		for (int i = 2; i <= N; i++) {
			if (encode[i] == 0) {
				if (encode[i - 1] == 1 || encode[i - 1] == 2) {
					dp[i] = dp[i - 2];
				} else {
					break;
				}
			} else {
				if (encode[i - 1] == 0) {
					dp[i] = dp[i - 1];
				} else {
					int combinationResult = combination(encode[i - 1], encode[i]);
					if (combinationResult >= 10 && combinationResult <= 26) {
						dp[i] = dp[i-2];
					}
					dp[i] += dp[i-1]%1000000;
				}
			}
		}

		bw.write(String.valueOf(dp[N] % 1000000));
		bw.flush();
		bw.close();
	}

	static private int combination(int a, int b) {
		String com = String.valueOf(a) + String.valueOf(b);
		return Integer.parseInt(com);
	}
}
