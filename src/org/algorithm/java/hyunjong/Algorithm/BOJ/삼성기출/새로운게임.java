package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 새로운게임 {
	static int N;
	static int K;
	static int[][] board;
	static List<Unit>[][] unitBoard;
	static Unit[] units;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		units = new Unit[K + 1];
		unitBoard = new List[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				unitBoard[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			if (d == 2) {
				d = 3;
			} else if (d == 3) {
				d = 0;
			} else if (d == 4) {
				d = 2;
			}

			Unit unit = new Unit(i + 1, y, x, d);
			unitBoard[y][x].add(unit);
			units[i + 1] = unit;
		}

		int answer = -1;
		for (int turn = 1; turn <= 1000; turn++) {
			if (start()) {
				answer = turn;
				break;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean start() {
		for (int u = 1; u <= K; u++) {
			Unit current = units[u];

			int currentY = current.y;
			int currentX = current.x;
			if (unitBoard[currentY][currentX].get(0).num != current.num)
				continue;

			int ny = currentY + dy[current.d];
			int nx = currentX + dx[current.d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 2) {
				int nd = (current.d + 2) % 4;
				ny = currentY + dy[nd];
				nx = currentX + dx[nd];
				current.d = nd;

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 2) {
					continue;
				}
			}

			if (board[ny][nx] == 1) {
				int size = unitBoard[currentY][currentX].size();
				for (int i = size-1; i >= 0; i--) {
					Unit unit = unitBoard[currentY][currentX].get(i);
					unit.y = ny;
					unit.x = nx;
					unitBoard[ny][nx].add(unit);
				}
				unitBoard[currentY][currentX].clear();
			} else {
				int size = unitBoard[currentY][currentX].size();
				for (int i = 0; i < size; i++) {
					Unit unit = unitBoard[currentY][currentX].get(i);
					unit.y = ny;
					unit.x = nx;
					unitBoard[ny][nx].add(unit);
				}
				unitBoard[currentY][currentX].clear();
			}

			if(unitBoard[ny][nx].size()>=4) return true;
		}
		return false;
	}

	static class Unit {
		int num;
		int y;
		int x;
		int d;

		public Unit(int num, int y, int x, int d) {
			this.num = num;
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
