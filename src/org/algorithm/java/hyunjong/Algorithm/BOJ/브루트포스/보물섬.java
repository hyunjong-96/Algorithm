package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {
	static int L;
	static int W;
	static char[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[L][W];

		for (int i = 0; i < L; i++) {
			String row = br.readLine();
			for (int j = 0; j < W; j++) {
				char c = row.charAt(j);
				map[i][j] = c;
			}
		}

		answer = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void bfs(int y, int x) {
		boolean[][] visit = new boolean[L][W];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {y, x});
		visit[y][x] = true;

		int hour = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = current[0] + dy[d];
					int nx = current[1] + dx[d];
					if (ny >= 0 && nx >= 0 && ny < L && nx < W && !visit[ny][nx] && map[ny][nx] != 'W') {
						visit[ny][nx] = true;
						queue.offer(new int[] {ny, nx});
					}
				}
			}
			hour++;
		}

		// if(hour == 5){
		// 	System.out.println();
		// }
		answer = Math.max(answer, hour-1);
	}
}
