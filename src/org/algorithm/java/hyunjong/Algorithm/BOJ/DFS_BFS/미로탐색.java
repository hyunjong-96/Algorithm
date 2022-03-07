package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {
	static int[][] map;
	static int[][] visit;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		map = new int[N + 1][M + 1];
		visit = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			char[] rowArr = row.toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = rowArr[j - 1] - '0';
			}
		}
		dfs();

		bw.write(String.valueOf(visit[N][M]));
		bw.flush();
		bw.close();
	}

	private static void dfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {1, 1});
		visit[1][1] = 1;

		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int y = position[0];
			int x = position[1];

			if (y - 1 > 0 && visit[y - 1][x] == 0 && map[y - 1][x] != 0) {//위
				queue.add(new int[] {y - 1, x});
				visit[y - 1][x] = visit[y][x] + 1;
			}
			if (x - 1 > 0 && visit[y][x - 1] == 0 && map[y][x - 1] != 0) {//왼
				queue.add(new int[] {y, x - 1});
				visit[y][x - 1] = visit[y][x] + 1;
			}
			if (y + 1 <= N && visit[y + 1][x] == 0 && map[y + 1][x] != 0) {//아래
				queue.add(new int[] {y + 1, x});
				visit[y + 1][x] = visit[y][x] + 1;
			}
			if (x + 1 <= M && visit[y][x + 1] == 0 && map[y][x + 1] != 0) {//오른쪽
				queue.add(new int[] {y, x + 1});
				visit[y][x + 1] = visit[y][x] + 1;
			}
		}
	}
}
