package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {
	static int N;
	static int M;
	static int[][] map;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int time = 0;
		while (true) {
			if (time != 0) {
				melt();
			}
			int group = checkGroup();

			if (group > 1) {
				answer = group;
				break;
			} else if (group == 0) {
				break;
			}
			time++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int checkGroup() {
		int group = 0;
		boolean[][] check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j] && map[i][j] != 0) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] {i, j});
					check[i][j] = true;

					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentY = current[0];
						int currentX = current[1];

						for (int d = 0; d < 4; d++) {
							int ny = currentY + dy[d];
							int nx = currentX + dx[d];

							if (ny >= 0 && nx >= 0 && ny < N && nx < M && !check[ny][nx] && map[ny][nx] != 0) {
								queue.offer(new int[]{ny,nx});
								check[ny][nx] = true;
							}
						}
					}

					group++;
				}
			}
		}

		return group;
	}

	static void melt() {
		int[][] cloneMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int ice = map[i][j];
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
							if (map[ny][nx] == 0 && ice > 0)
								ice--;
						}
					}
					cloneMap[i][j] = ice;
				}
			}
		}

		map = cloneMap;
	}
}
