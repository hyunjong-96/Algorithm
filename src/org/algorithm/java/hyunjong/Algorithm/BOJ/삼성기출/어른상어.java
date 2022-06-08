package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 어른상어 {
	static int[][] map;
	static int[][] range;
	static int[][][] move;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static Shark[] sharks;
	static int N;
	static int M;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		range = new int[N][N];
		move = new int[M + 1][4][4];
		sharks = new Shark[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					range[i][j] = K;
					sharks[map[i][j]] = new Shark(map[i][j], i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < M + 1; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int s = 1; s < M + 1; s++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					move[s][i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}

		int answer = -1;
		int time = 0;
		while (time++ < 1000) {

			if (start()) {
				answer = time;
				break;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean start() {
		//map : 상어, range : 냄새, move : 상어별 움직의 우선순위

		moveShark();

		boolean isOnlyStrongShark = true;
		//냄새 -1;
		disCountSmell();
		setSharkSmell();

		int outCount = 0;
		for (int i = 2; i < M + 1; i++) {
			if (sharks[i].isOut) {
				outCount++;
			}
		}
		if (outCount < M - 1)
			isOnlyStrongShark = false;

		return isOnlyStrongShark;
	}

	static void setSharkSmell() {
		for (Shark shark : sharks) {
			if (shark == null)
				continue;
			if (shark.isOut)
				continue;

			range[shark.y][shark.x] = K;
			map[shark.y][shark.x] = shark.num;
		}
	}

	static void disCountSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (range[i][j] != 0) {
					range[i][j]--;
					if (range[i][j] == 0)
						map[i][j] = 0;
				}
			}
		}
	}

	static void moveShark() {
		int[][] cloneMap = cloneArr(map);
		int[][] cloneRange = cloneArr(range);
		for (int s = 1; s < M + 1; s++) {
			Shark shark = sharks[s];
			if (shark.isOut)
				continue;
			for (int i = 0; i < 8; i++) {
				int nd = move[shark.num][shark.d][i % 4];
				int ny = shark.y + dy[nd];
				int nx = shark.x + dx[nd];
				//빈 공간
				if (i < 4) {

					if (ny < N && nx < N && ny >= 0 && nx >= 0 && map[ny][nx] == 0) {
						if (cloneMap[ny][nx] != 0) {
							shark.isOut = true;
							break;
						}
						cloneMap[ny][nx] = shark.num;
						// cloneRange[ny][nx] = K;

						shark.d = nd;
						shark.y = ny;
						shark.x = nx;
						break;
					}
				}
				//자신 영역
				else {
					if (ny < N && nx < N && ny >= 0 && nx >= 0 && map[ny][nx] == shark.num) {
						cloneMap[ny][nx] = shark.num;
						// cloneRange[ny][nx] = K;

						shark.d = nd;
						shark.y = ny;
						shark.x = nx;
						break;
					}
				}
			}
		}
		map = cloneMap;
		range = cloneRange;
	}

	static int[][] cloneArr(int[][] arr) {
		int[][] cloneArr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cloneArr[i][j] = arr[i][j];
			}
		}

		return cloneArr;
	}

	static class Shark {
		int num;
		int y;
		int x;
		int d;
		boolean isOut;

		public Shark(int num, int y, int x) {
			this.num = num;
			this.y = y;
			this.x = x;
			isOut = false;
		}
	}
}
