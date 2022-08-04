package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문자열에 연속 부분문자열이 2개 이상인 것 중 가장 긴 부분 문자열을 찾는 문제.
연속 부분문자열이기 때문에 Longest Common Substring을 이용해서 연속 부분문자열을 찾았고
부분문자열의 길이의 개수를 구하기 위해 lengthArr이란 배열을 만들어서 부분문자열의 길이를 lengthArr에 저장
그 후, lengthArr에 저장된 부분문자열 길이중 2개 이상이고 가장 큰 길이를 반환.
 */
public class Cubeditor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int[] lengthArr = new int[s.length() + 1];
		int[][] dp = new int[s.length() + 1][s.length() + 1];

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					lengthArr[dp[i][j]]++;
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= s.length(); i++) {
			if(lengthArr[i]>=2) answer = i;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
