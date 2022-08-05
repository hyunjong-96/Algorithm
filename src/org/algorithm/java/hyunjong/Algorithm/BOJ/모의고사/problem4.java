package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

//시간초과
public class problem4 {
	static int[][] beginning;
	static int[][] target;
	static int answer;

	public static void main(String[] args) {
		int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
		// int[][] beginning = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
		// int[][] target = {{1, 0, 1}, {0, 0, 0}, {0, 0, 0}};

		int solution = solution(beginning, target);
		System.out.println(solution);
	}

	static int solution(int[][] b, int[][] t) {
		beginning = b;
		target = t;
		answer = Integer.MAX_VALUE;
		turn(beginning, 0, 0, 0, 0, 0);
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		return answer;
	}

	static void turn(int[][] board, int colCheck, int rowCheck, int colIdx, int rowIdx, int turn) {
		if (turn == beginning.length + beginning[0].length)
			return;

		if (checkBoard(board)) {
			answer = Math.min(answer, turn);
			return;
		}

		if (colCheck < beginning.length) {
			for (int i = colIdx; i < beginning.length; i++) {
				int[][] copyBoard = cloneBoard(board);

				turnCol(copyBoard, i);

				turn(copyBoard, colCheck+1, rowCheck, i + 1, rowIdx, turn + 1);
			}
		}

		if (rowCheck < beginning[0].length) {
			for (int i = rowIdx; i < beginning[0].length; i++) {
				int[][] copyBoard = cloneBoard(board);

				turnRow(copyBoard, i);

				turn(copyBoard, colCheck, rowCheck+1, colIdx, i + 1, turn + 1);
			}
		}
	}

	static void turnRow(int[][] board, int row) {
		for (int i = 0; i < beginning.length; i++) {
			if (board[i][row] == 1)
				board[i][row] = 0;
			else
				board[i][row] = 1;
		}
	}

	static void turnCol(int[][] board, int col) {
		for (int i = 0; i < beginning[0].length; i++) {
			if (board[col][i] == 1)
				board[col][i] = 0;
			else
				board[col][i] = 1;
		}
	}

	static int[][] cloneBoard(int[][] board) {
		int[][] copyBoard = new int[beginning.length][beginning[0].length];

		for (int i = 0; i < beginning.length; i++) {
			for (int j = 0; j < beginning[0].length; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}

		return copyBoard;
	}

	static boolean checkBoard(int[][] board) {
		for (int i = 0; i < beginning.length; i++) {
			for (int j = 0; j < beginning[0].length; j++) {
				if (board[i][j] != target[i][j])
					return false;
			}
		}

		return true;
	}
}
