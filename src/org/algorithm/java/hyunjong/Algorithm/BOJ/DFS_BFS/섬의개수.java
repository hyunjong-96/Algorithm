package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//4963
public class 섬의개수 {
	static int[][] map;
	static boolean[][] visited;
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int[] mapInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			w = mapInfo[0];
			h = mapInfo[1];
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				map[i] = row;
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			bw.write(String.valueOf(count));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y) {
		if (map[x][y] == 0 || visited[x][y])
			return;

		visited[x][y] = true;

		if (y > 0)
			dfs(x, y - 1);//왼쪽
		if (y < w - 1)
			dfs(x, y + 1);//오른쪽
		if (x > 0)
			dfs(x - 1, y);//위
		if (x < h - 1)
			dfs(x + 1, y);//아래
		if (x > 0 && y > 0)
			dfs(x - 1, y - 1);//왼쪽 대각선 위
		if (x < h - 1 && y > 0)
			dfs(x + 1, y - 1);//왼쪽 대각선 아래
		if (x > 0 && y < w - 1)
			dfs(x - 1, y + 1);//오른쪽 대각선 위
		if (x < h - 1 && y < w - 1)
			dfs(x + 1, y + 1);//오른쪽 대각선 아래
	}
}
