package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
	static int R;
	static int C;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		Queue<int[]> fireQueue = new LinkedList<>();
		Queue<int[]> jiuQueue = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = row[j].charAt(0);
				if (map[i][j] == 'J') {
					jiuQueue.offer(new int[]{i,j});
				}
				if (map[i][j] == 'F') {
					fireQueue.offer(new int[]{i,j});
				}
			}
		}

		int result = move(map, jiuQueue, fireQueue);

		String answer = result == 0 ? "IMPOSSIBLE" : String.valueOf(result);

		bw.write(answer);
		bw.flush();
		bw.close();
	}

	static int move(char[][] map, Queue<int[]> jiuQueue, Queue<int[]> fireQueue) {

		int count = 0;
		while (!jiuQueue.isEmpty()) {

			int fireSize = fireQueue.size();

			for (int i = 0; i < fireSize; i++) {
				int[] current = fireQueue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = current[0] + dy[d];
					int nx = current[1] + dx[d];

					if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != '#' && map[ny][nx] != 'F') {
						map[ny][nx] = 'F';
						fireQueue.offer(new int[] {ny, nx});
					}
				}
			}

			int jiuSize = jiuQueue.size();

			for (int i = 0; i < jiuSize; i++) {
				int[] current = jiuQueue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = current[0] + dy[d];
					int nx = current[1] + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
						return count + 1;
					}

					if (map[ny][nx] != 'F' && map[ny][nx] != '#' && map[ny][nx] != 'J') {
						jiuQueue.offer(new int[] {ny, nx});
						map[ny][nx] = 'J';
					}
				}
			}

			count++;
		}

		return 0;
	}
}
