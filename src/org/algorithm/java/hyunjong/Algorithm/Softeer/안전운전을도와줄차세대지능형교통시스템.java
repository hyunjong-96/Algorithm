package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 안전운전을도와줄차세대지능형교통시스템 {
	static int N;
	static int T;
	static int[][][] signs;
	static int[][][] signsDetails =
		{
			{{0,1}, {1, 0}, {0, -1}},
			{{-1, 0}, {0, 1}, {1, 0}},
			{{0, -1}, {-1, 0}, {0, 1}},
			{{1, 0}, {0, -1}, {-1, 0}}
		};
	static boolean[][][] check;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		signs = new int[N + 1][N + 1][4];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 4; k++) {
					signs[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		check = new boolean[N + 1][N + 1][4];
		bfs();

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int d = 0; d < 4; d++) {
					if (check[i][j][d]) {
						answer++;
						break;
					}
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1, 1, 2, 0, 0});
		check[1][1][2] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentY = current[0];
			int currentX = current[1];
			int inputD = current[2];
			int currentTurn = current[3];
			int totalTurn = current[4];

			int sign = signs[currentY][currentX][currentTurn];	//신호 번호
			int signD = sign%4;	//해당 신호의 input 방향

			if (inputD != signD || totalTurn == T)
				continue;

			int[][] signOfDetails = signsDetails[signD];
			int s = sign / 4;
			if(sign % 4 ==0) s-=1;

			if (s == 0) {
				for (int i = 0; i < 3; i++) {
					int ny = currentY + signOfDetails[i][0];
					int nx = currentX + signOfDetails[i][1];
					int nd = getNextDir(ny, nx, currentY, currentX);
					int nt = (currentTurn+1) % 4;

					if (ny > 0 && nx > 0 && ny <= N && nx <= N && !check[ny][nx][nd]) {
					// if (ny > 0 && nx > 0 && ny <= N && nx <= N ) {
						check[ny][nx][nd] = true;
						queue.offer(new int[] {ny, nx, nd, nt, totalTurn+1});
					}
				}
			} else if (s == 1) {
				for (int i = 0; i < 2; i++) {
					int ny = currentY + signOfDetails[i][0];
					int nx = currentX + signOfDetails[i][1];
					int nd = getNextDir(ny, nx, currentY, currentX);
					int nt = (currentTurn+1) % 4;

					if (ny > 0 && nx > 0 && ny <= N && nx <= N && !check[ny][nx][nd]) {
					// if (ny > 0 && nx > 0 && ny <= N && nx <= N ) {
						check[ny][nx][nd] = true;
						queue.offer(new int[] {ny, nx, nd, nt, totalTurn+1});
					}
				}
			} else {
				for (int i = 1; i < 3; i++) {
					int ny = currentY + signOfDetails[i][0];
					int nx = currentX + signOfDetails[i][1];
					int nd = getNextDir(ny, nx, currentY, currentX);
					int nt = (currentTurn+1) % 4;

					if (ny > 0 && nx > 0 && ny <= N && nx <= N && !check[ny][nx][nd]) {
					// if (ny > 0 && nx > 0 && ny <= N && nx <= N ) {
						check[ny][nx][nd] = true;
						queue.offer(new int[] {ny, nx, nd, nt, totalTurn+1});
					}
				}
			}
		}
	}

	static int getNextDir(int ny, int nx, int currentY, int currentX) {
		if (ny - currentY > 0)
			return 0;
		else if (ny - currentY < 0)
			return 2;
		else if (nx - currentX > 0)
			return 1;
		else
			return 3;
	}
}
