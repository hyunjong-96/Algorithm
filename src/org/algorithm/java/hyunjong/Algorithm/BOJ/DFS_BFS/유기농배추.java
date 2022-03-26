package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 유기농배추 {
	static int[] moveY = {-1, 1, 0, 0};    //위, 아래, 왼, 오
	static int[] moveX = {0, 0, -1, 1}; //위, 아래, 왼, 오
	static int[][] land;
	static int N;
	static int M;
	static int K;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());    //배추밭 가로
			N = Integer.parseInt(st.nextToken());    //배추밭 세로
			K = Integer.parseInt(st.nextToken());    //배추 갯수

			land = new int[N][M];
			visit = new boolean[N][M];

			for (int j = 0; j < K; j++) {
				StringTokenizer Bt = new StringTokenizer(br.readLine(), " ");
				int Bx = Integer.parseInt(Bt.nextToken());
				int By = Integer.parseInt(Bt.nextToken());
				land[By][Bx] = 1;
			}

			int warm = 0;
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					if (!visit[n][m] && land[n][m] == 1) {
						dfs(m, n);
						warm++;
					}
				}
			}
			sb.append(warm).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			if (-1 < nextX && nextX < M && -1 < nextY && nextY < N) {
				if (!visit[nextY][nextX] && land[nextY][nextX] == 1) {
					dfs(x + moveX[i], y + moveY[i]);
				}
			}
		}
	}
}
