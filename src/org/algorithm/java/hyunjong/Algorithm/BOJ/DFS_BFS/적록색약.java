package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
bfs문제
색약인 경우와 색약이 아닌 경우의 bfs를 구하면 된다.
색약이 아닌 경우 bfs가 시작되는 좌표의 색의 그룹으로 시작하고 그룹이 시작될때마다 count를 세어준다(count = 그룹 갯수)
색약인 경우 bfs가 시작되는 좌표의 색이 R || G 일때 인접하는 색이 R || G일때 하나의 그룹으로 생각하고 그룹으로 묶어준다.
시작되는 좌표의 색이 B인 경우에는 B와 인접한 색이 B일 때만 그룹으로 묶어주고 count를 세어준다
두 번의 bfs를 실행하고 나면 각 각의 그룹 갯수가 나타난다.
 */
public class 적록색약 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int N;
	static char[][] image;
	static boolean[][] visit;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		image = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				image[i][j] = row.charAt(j);
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[j][i]) {
					bfs(i, j);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		visit = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[j][i]) {
					bfs2(i, j);
					count++;
				}
			}
		}
		sb.append(count);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	//색약x
	static void bfs(int x, int y) {
		visit[y][x] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));

		char currentColor = image[y][x];
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextY][nextX]) {
					if (currentColor == image[nextY][nextX]) {
						visit[nextY][nextX] = true;
						queue.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}

	//색약
	static void bfs2(int x, int y) {
		visit[y][x] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));

		char currentColor = image[y][x];
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextY][nextX]) {
					if((currentColor == 'R' || currentColor == 'G') && (image[nextY][nextX] == 'R' || image[nextY][nextX] =='G') ){
						visit[nextY][nextX] = true;
						queue.add(new Point(nextX, nextY));
					}else if(currentColor == 'B' && image[nextY][nextX] == 'B'){
						visit[nextY][nextX] = true;
						queue.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}
}
