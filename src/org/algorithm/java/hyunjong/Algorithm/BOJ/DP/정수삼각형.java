package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
삼각형의 깊이마다 부모 노드와의 합이 최대인 경로를 찾아야한다.
삼각형의 각 깊이에서의 첫번째 노드는 깊이-1의 첫번째 노드만 합이 가능하고 마지막 노드는 깊이-1의 마지막 노드만 합이 가능하다.
현재 깊이가 i, 부모의 깊이가 i-1 이고 현재 깊이의 노드의 위치를 j라고 할때
i != 1 && i != i 일때 num[i][j]는 num[i-1][j-1]과 num[i-1][j]를 부모노드로 가지게 된다.
그러므로 dp[i][1]는 dp[i-1][1]과의 합, dp[i][i]는 dp[i-1][i-1]과의 합, 나머지는 dp[i][j] = dp[i-1][j-1]+dp[i-1][j]과의 합이 가능하다.
 */
public class 정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		i : 삼각형의 깊이
		j : 깊이에서의 위치
		 */
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1)	//각 깊이의 첫번째 노드는 부모 노드의 첫번째 노드와만 접근이 가능하다.
					dp[i][j] = dp[i - 1][1] + num[i][j];
				else if (j == i) //각 깊이의 마지막 노드는 부모 노드의 마지막 노드와만 접근이 가능하다.
					dp[i][j] = dp[i - 1][j - 1] + num[i][j];
				else {
					//그 외의 노드들은 왼쪽 부모노드, 오른쪽 부모노드의 값 중 가장 큰 값을 dp[i][j]에 저장하면된다.
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[N][i]);
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
