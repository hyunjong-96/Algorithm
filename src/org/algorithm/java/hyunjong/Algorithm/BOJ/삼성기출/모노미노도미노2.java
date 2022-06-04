package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모노미노도미노2 {
	static int N;
	static int[][] board;
	static int[][] blocks;
	static int totalScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[10][10];

		blocks = new int[N][4];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			blocks[i][0] = t;
			blocks[i][1] = x;
			blocks[i][2] = y;
		}

		totalScore = 0;
		for (int t = 0; t < N; t++) {
			move(t);
			scoreCount();
			specialCount();
		}
		int blockCount = blockCount();

		StringBuilder sb = new StringBuilder();
		sb.append(totalScore);
		sb.append("\n");
		sb.append(blockCount);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int blockCount() {
		int count = 0;
		for (int x = 6; x < 10; x++) {
			for (int y = 0; y < 4; y++) {
				if (board[x][y] != 0) {
					count++;
				}
			}
		}

		for (int y = 6; y < 10; y++) {
			for (int x = 0; x < 4; x++) {
				if (board[x][y] != 0) {
					count++;
				}
			}
		}

		return count;
	}

	static void specialBlueCount() {
		int count = 0;
		for (int y = 4; y <= 5; y++) {
			for (int x = 0; x < 4; x++) {
				if (board[x][y] != 0) {
					count++;
					break;
				}
			}
		}

		if (count == 0)
			return;
		for (int y = 9 - count; y >= 4; y--) {
			for (int x = 0; x < 4; x++) {
				board[x][y + count] = board[x][y];
				board[x][y] = 0;
			}
		}
	}

	static void specialGreenCount() {
		int count = 0;
		for (int x = 4; x <= 5; x++) {
			for (int y = 0; y < 4; y++) {
				if (board[x][y] != 0) {
					count++;
					break;
				}
			}
		}

		if (count == 0)
			return;
		for (int x = 9 - count; x >= 4; x--) {
			for (int y = 0; y < 4; y++) {
				board[x + count][y] = board[x][y];
				board[x][y] = 0;
			}
		}
	}

	static void specialCount() {
		specialBlueCount();
		specialGreenCount();
	}

	static int deleteBlueCheck() {
		int score = 0;
		for (int y = 9; y >= 6; y--) {
			boolean isFull = true;
			for (int x = 0; x < 4; x++) {
				if (board[x][y] == 0) {
					isFull = false;
					break;
				}
			}

			if (isFull) {
				score++;
				for (int i = y - 1; i >= 4; i--) {
					for (int j = 0; j < 4; j++) {
						board[j][i+1] = board[j][i];
					}
				}
			}
		}
		return score;
	}

	static int deleteGreenCheck() {
		int score = 0;
		for (int x = 9; x >= 6; x--) {
			boolean isFull = true;
			for (int y = 0; y < 4; y++) {
				if (board[x][y] == 0) {
					isFull = false;
					break;
				}
			}


			if (isFull) {
				score++;
				for (int i = x - 1; i >= 4; i--) {
					for (int j = 0; j < 4; j++) {
						board[i + 1][j] = board[i][j];
					}
				}
			}
		}
		return score;
	}

	static void scoreCount() {
		int score = 0;
		//초록색 : (9,0)부터 (6,0)까지 행을 확인하면서 해당 행이 꽉차있다면 행 지우고 score+1
		score += deleteGreenCheck();
		//파란색 : (0,9)부터 (0,6)까지 열을 확인하면서 해당 열이 꽉차있다면 열 지우고 score+1
		score += deleteBlueCheck();
		totalScore += score;
	}

	static void move(int turn) {
		int t = blocks[turn][0];
		int x = blocks[turn][1];
		int y = blocks[turn][2];

		if (t == 1) {
			oneBlockGreenMove(x, y);
			oneBlockBlueMove(x, y);
		} else if (t == 2) {
			widthBlueMove(x, y + 1);
			widthGreenMove(x, y + 1);
		} else {
			lengthBlueMove(x + 1, y);
			lengthGreenMove(x + 1, y);
		}
	}

	static void lengthBlueMove(int x, int y) {
		while (y < 10 && (board[x - 1][y] == 0 && board[x][y] == 0)) {
			y++;
		}
		y -= 1;
		board[x - 1][y] = 1;
		board[x][y] = 1;
	}

	static void lengthGreenMove(int x, int y) {
		while (x < 10 && board[x][y] == 0) {
			x++;
		}
		x -= 1;
		board[x - 1][y] = 1;
		board[x][y] = 1;
	}

	static void widthBlueMove(int x, int y) {
		while (y < 10 && board[x][y] == 0) {
			y++;
		}
		y -= 1;
		board[x][y - 1] = 1;
		board[x][y] = 1;
	}

	static void widthGreenMove(int x, int y) {
		while (x < 10 && (board[x][y - 1] == 0 && board[x][y] == 0)) {
			x++;
		}
		x -= 1;
		board[x][y - 1] = 1;
		board[x][y] = 1;
	}

	static void oneBlockBlueMove(int x, int y) {
		while (y < 10 && board[x][y] == 0) {
			y++;
		}
		y -= 1;
		board[x][y] = 1;
	}

	static void oneBlockGreenMove(int x, int y) {
		while (x < 10 && board[x][y] == 0) {
			x++;
		}
		x -= 1;
		board[x][y] = 1;
	}
}
