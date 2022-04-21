package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {
	static int[][] map;
	static int N;
	static int M;
	static int virusCount;
	static int wallCount;
	static List<Point> virusList;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virusList = new ArrayList<>();
		virusCount = N*M;
		wallCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i][j] = e;
				if (e == 2) {
					virusList.add(new Point(j, i));
				}
				if (e == 1)
					wallCount++;
			}
		}

		setWall(0, 0);
		int res = (N * M) - (wallCount + 3 + virusCount);
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	//벽세우기 dfs
	static void setWall(int count, int x) {
		if (count >= 3) {
			virusCount = Math.min(virusCount, spreadVirus());
			return;
		}

		for (int i = x; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 2 || map[j][i] == 1)
					continue;
				map[j][i] = 1;
				setWall(count + 1, i);
				map[j][i] = 0;
			}
		}
	}

	//바이러스 뿌리기 bfs
	static int spreadVirus() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		for (Point point : virusList) {
			queue.offer(point);
			visit[point.y][point.x] = true;
		}
		int count = virusList.size();
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || visit[ny][nx])
					continue;
				visit[ny][nx] = true;
				count++;
				queue.offer(new Point(nx, ny));
			}
		}
		return count;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
