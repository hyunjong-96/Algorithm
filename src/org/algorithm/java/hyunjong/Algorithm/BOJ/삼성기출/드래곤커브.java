package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {
	static boolean[][] map = new boolean[101][101];
	static List<Integer>[] listOfGeneral;
	static Point[] generals;
	static int N;
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		listOfGeneral = new ArrayList[N];
		generals = new Point[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			generals[i] = new Point(x, y, g);
			listOfGeneral[i] = new ArrayList<>();
			listOfGeneral[i].add(d);
			map[y][x] = true;
			int ny = y+dy[d];
			int nx = x+dx[d];
			generals[i].y = ny;
			generals[i].x = nx;
			map[ny][nx] = true;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < generals[i].general; j++) {
				int size = listOfGeneral[i].size()-1;
				for (int d = size; d >= 0; d--) {
					int nd = (listOfGeneral[i].get(d) + 1) % 4;
					int ny = generals[i].y + dy[nd];
					int nx = generals[i].x + dx[nd];
					if (ny < 0 || nx < 0 || nx > 100 || ny > 100)
						continue;
					generals[i].y = ny;
					generals[i].x = nx;
					map[generals[i].y][generals[i].x] = true;
					listOfGeneral[i].add(nd);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					count++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static class Point {
		int x;
		int y;
		int general;

		public Point(int x, int y, int general) {
			this.x = x;
			this.y = y;
			this.general = general;
		}
	}
}
