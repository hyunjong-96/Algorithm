package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내려가기 {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1};
	static int max;
	static int min;
	static int[][][] valueMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		valueMap = new int[N][3][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				valueMap[i][j][0] = valueMap[i][j][1] = map[i][j];
			}
		}

		max = 0;
		min = Integer.MAX_VALUE;
		dp();

		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append(" ");
		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dp() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				int minValue = Integer.MAX_VALUE;
				int maxValue = 0;
				for(int d=0;d<3;d++){
					int nx = j+dx[d];
					if(nx>=0 && nx<3){
						int minSum = map[i][j] + valueMap[i+1][nx][0];
						int maxSum = map[i][j] + valueMap[i+1][nx][1];
						minValue = Math.min(minValue, minSum);
						maxValue = Math.max(maxValue, maxSum);
					}
				}

				valueMap[i][j][0] = minValue;
				valueMap[i][j][1] = maxValue;
			}
		}
		max = Math.max(Math.max(valueMap[0][0][1], valueMap[0][1][1]), valueMap[0][2][1]);
		min = Math.min(Math.min(valueMap[0][0][0], valueMap[0][1][0]), valueMap[0][2][0]);
	}
}
