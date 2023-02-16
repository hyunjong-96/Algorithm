package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 이미지프로세싱 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] map = new int[H + 1][W + 1];
		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			processing(map, i, j, c, H, W);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void processing(int[][] map, int i, int j, int c, int H, int W) {
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] check = new boolean[H + 1][W + 1];

		int sameColor = map[i][j];
		queue.offer(new int[] {i, j});
		check[i][j] = true;
		map[i][j] = c;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int y = current[0];
			int x = current[1];
			// check[y][x] = true;
			// map[y][x] = c;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny > 0 && nx > 0 && ny <= H && nx <= W && map[ny][nx] == sameColor && !check[ny][nx]) {
					check[ny][nx] = true;
					map[ny][nx] = c;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
}
