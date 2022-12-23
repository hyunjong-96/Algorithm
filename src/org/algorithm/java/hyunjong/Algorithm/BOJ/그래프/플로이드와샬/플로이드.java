package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.플로이드와샬;

import java.io.*;
import java.util.StringTokenizer;

public class 플로이드 {
	static int N;
	static int M;
	static int[][] city;
	static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		city = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					city[i][j] = 0;
				else
					city[i][j] = INF;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			city[a][b] = Math.min(city[a][b],c);
		}

		floydWarshall();

		StringBuilder sb = new StringBuilder();
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(city[r][c] == INF) city[r][c]=0;
				sb.append(city[r][c]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					city[r][c] = Math.min(city[r][c], city[r][k] + city[k][c]);
				}
			}
		}
	}
}