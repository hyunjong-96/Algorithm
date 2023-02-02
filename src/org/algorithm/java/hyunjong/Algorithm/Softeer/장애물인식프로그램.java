package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 장애물인식프로그램 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			// StringTokenizer st = new StringTokenizer(br.readLine(),"");
			String[] row = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}

		boolean[][] checkMap = new boolean[N][N];
		List<Integer> blockCount = new ArrayList<>();
		int block = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !checkMap[i][j]) {
					blockCount.add(count(N, map, checkMap, i, j));
					block++;
				}
			}
		}

		Collections.sort(blockCount);

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(block)).append("\n");
		for (int count : blockCount) {
			sb.append(String.valueOf(count));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int count(int N, int[][] map, boolean[][] checkMap, int startY, int startX) {
		int[] dy = new int[] {-1, 0, 1, 0};
		int[] dx = new int[] {0, 1, 0, -1};

		Queue<int[]> queue = new LinkedList<>();
		checkMap[startY][startX] = true;
		queue.offer(new int[] {startY, startX});

		int count = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			count++;

			for (int d = 0; d < 4; d++) {
				int ny = current[0] + dy[d];
				int nx = current[1] + dx[d];

				if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == 1 && !checkMap[ny][nx]) {
					queue.offer(new int[] {ny, nx});
					checkMap[ny][nx] = true;
				}
			}
		}

		return count;
	}
}
