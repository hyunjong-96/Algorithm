package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BFS로 풀수있는 토마토 문제이다.
가로M, 세로N의 크기를 가진 토마토 판을 H개를 가지고 있기 때문에 3차원 배열을 사용해야한다.
토마토 판에는 익은 토마토 : 1, 익지 않은 토마토 : 0, 토마토가 없음 : -1로 이루어져있으며
위,아래,앞,뒤,왼,오 로 인접해있는 토마토가 익을수 있게 된다.
처음에 해결하지 못했던 이유가 익은 토마토를 시작으로 인접한 토마토에 접근을 했어야 했는데
익은 토마토 하나에 대한 bfs를 했었다. 그렇게 되면 당연히 다른 익은 토마토에 대한 값이 적용이 되지 않기 때문에 실패.
그래서 bfs 내부에서 초기화 해준 Queue를 전역 변수로 수정하여 전체 토마토 판에서 익은 토마토(1)를 queue에 넣어주고(핵심)
bfs를 실행해 주었더니 성공.
 */
public class 토마토농장 {
	static int M;
	static int N;
	static int H;
	static int[][][] farm;
	static int[] dX = {0, 0, -1, 1, 0, 0};
	static int[] dY = {-1, 1, 0, 0, 0, 0};
	static int[] dH = {0, 0, 0, 0, -1, 1};
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		farm = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 0; m < M; m++) {
					farm[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N * M; i++) {
				if (farm[h][i / M][i % M] == 1) {
					queue.add(new Point(h, i / M, i % M));
				}
			}
		}

		bfs();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N * M; i++) {
				if (farm[h][i / M][i % M] != -1) {
					min = Math.min(min, farm[h][i / M][i % M]);
					max = Math.max(max, farm[h][i / M][i % M]);
				}
			}
		}

		if (max == 1) {
			bw.write("0");
		} else if (min == 0) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(max - 1));
		}
		bw.flush();
		bw.close();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nextX = p.x + dX[i];
				int nextY = p.y + dY[i];
				int nextH = p.h + dH[i];
				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && nextH >= 0 && nextH < H) {
					if (farm[nextH][nextY][nextX] == 0) {
						farm[nextH][nextY][nextX] = farm[p.h][p.y][p.x] + 1;
						queue.add(new Point(nextH, nextY, nextX));
					}
				}
			}
		}
	}

	static class Point {
		int h;
		int y;
		int x;

		public Point(int h, int y, int x) {
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}
}
