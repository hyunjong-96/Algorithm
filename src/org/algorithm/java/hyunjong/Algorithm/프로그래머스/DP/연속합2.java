package org.algorithm.java.hyunjong.Algorithm.프로그래머스.DP;

import java.io.*;
import java.util.StringTokenizer;
/*
2차원 배열을 이용한 dp 문제.

do[i][0]은 특정 원소를 삭제하지않고 연속합의 최대값 저장
dp[i][1]은 특정 원소를 삭제한 연속합의 최대값 저장

dp[i][0]은 이전 연속합에 자신을 더한것과 자신값 중 더 큰것으로 저장한다. (전자는 이전부터 현재까지의 합, 후자는 이전부터 현재의 합이 현재 값보다 작아지는경우)
	전자 : dp[i][0]+seq[i]
	후자 : seq[i]
dp[i][1]은 현재값을 삭제하거나 이전에서 어떤 값이 삭제된 경우 현재값은 삭제할 수 없기때문에
	전자 : dp[i-1][0]
	후자 : dp[i-1][1]+seq[i]

첫번째 원소값으로 초기화하고 dp[i][0]과 dp[i][1], answer 중 더 큰값으로 갱신해나가면서 반복
 */
public class 연속합2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][2];
		dp[0][0] = seq[0];
		int answer = dp[0][0];
		for(int i=1;i<N;i++){
			dp[i][0] = Math.max(dp[i-1][0]+seq[i],seq[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+seq[i]);
			answer = Math.max(answer,Math.max(dp[i][0],dp[i][1]));
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
