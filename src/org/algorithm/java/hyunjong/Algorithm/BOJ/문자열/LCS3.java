package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
substring : 연속되는 공통 부분 문자열
subsequence : 연속되지 않는 공통 부분 문자열
substring 구하는 dp는 각 문자 i,j가 동일할때 i-1,j-1위치에 있는 dp의 값에 +1, 동일하지 않을때는 아무 처리하지 않는다.
subsequence 구하는 dp는 각 문자 i,j가 동일할때 i-1,j-1위치의 dp의 값이 +1,
	동일하지 않을때는 i-1,j나 i,j-1의 dp값 중 큰 값을 dp에 저장한다. 가장 긴 lcs는 dp의 가장 마지막 위치에 있게 된다.
 */
public class LCS3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();

		int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			char c1 = s1.charAt(i-1);
			for (int j = 1; j <= s2.length(); j++) {
				char c2 = s2.charAt(j-1);
				for (int k = 1; k <= s3.length(); k++) {
					char c3 = s3.charAt(k-1);

					if(c1==c2 && c2==c3){
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}else{
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k],dp[i][j][k-1]));
					}
				}
			}
		}

		bw.write(String.valueOf(dp[s1.length()][s2.length()][s3.length()]));
		bw.flush();
		bw.close();
	}
}
