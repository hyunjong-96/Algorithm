package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int outSand;

	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	static int[][] sy = {{-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
		{1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
	static int[][] sx = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
		{1, -1, 2, 1, -1, -2, 1, -1, 0}};
	static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		outSand = 0;
		start();
		bw.write(String.valueOf(outSand));
		bw.flush();
		bw.close();
	}

	static void start() {
		int y = N / 2;
		int x = N / 2;

		int move = 1;
		int count = 0;
		int dir = 0;
		while (true) {

			for (int i = 1; i <= move; i++) {
				y += dy[dir];
				x += dx[dir];

				// if (y == 0 && x == 0)
				// 	return;
				if(y<0 || x<0 || y>=N || x>=N) return;

				spraySand(dir, y, x);

			}

			if (++count == 2) {
				move++;
				count = 0;
			}
			dir = (dir + 1) % 4;
		}
	}

	static void spraySand(int dir, int y, int x) {
		int totalSpraySand = 0;
		for (int i = 0; i < 9; i++) {
			int ny = y + sy[dir][i];
			int nx = x + sx[dir][i];
			int sand = map[y][x];
			int spraySand = (sand * sandRatio[i])/100;
			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				map[ny][nx] += spraySand;
			} else {
				outSand += spraySand;
			}
			totalSpraySand += spraySand;
		}

		int ny = y + dy[dir];
		int nx = x + dx[dir];
		int sand = map[y][x];
		int spreadSand = sand - totalSpraySand;
		if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
			map[ny][nx] += spreadSand;
		}else{
			outSand += spreadSand;
		}

		map[y][x] = 0;
	}
}
