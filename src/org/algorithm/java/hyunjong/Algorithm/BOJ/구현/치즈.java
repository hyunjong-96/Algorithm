package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
	static int N;
	static int M;
	static int[][] board;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		int time = 0;
		int prevCheeseCount = 0;
		while (true) {
			int cheeseCount = countCheese();
			if (cheeseCount == 0) {
				sb.append(time);
				sb.append("\n");
				sb.append(prevCheeseCount);
				break;
			}
			prevCheeseCount = cheeseCount;

			meltCheese();

			time++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void meltCheese() {
		int[][] copyBoard = copyBoard();
		boolean[][] visit = new boolean[N][M];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for(int d=0;d<4;d++){
				int ny = current[0] + dy[d];
				int nx = current[1] + dx[d];
				if(ny>=0 && nx>=0 && ny<N && nx<M && !visit[ny][nx]){
					if(board[ny][nx] == 1){
						copyBoard[ny][nx] = 0;
					}else{
						queue.offer(new int[]{ny,nx});
					}
					visit[ny][nx] = true;
				}
			}
		}

		board = copyBoard;
	}

	static int countCheese() {
		boolean[][] visit = new boolean[N][M];

		int cheeseCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !visit[i][j]) {
					Queue<int[]> queue = new LinkedList<>();

					queue.offer(new int[] {i, j});
					visit[i][j] = true;
					cheeseCount++;

					while (!queue.isEmpty()) {
						int[] current = queue.poll();

						for (int d = 0; d < 4; d++) {
							int ny = current[0] + dy[d];
							int nx = current[1] + dx[d];

							if (ny > 0 && nx > 0 && ny < N && nx < M && board[ny][nx] == 1 && !visit[ny][nx]) {
								queue.offer(new int[] {ny, nx});
								visit[ny][nx] = true;
								cheeseCount++;
							}
						}
					}
				}
			}
		}

		return cheeseCount;
	}

	static int[][] copyBoard() {
		int[][] copyBoard = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
		return copyBoard;
	}
}
