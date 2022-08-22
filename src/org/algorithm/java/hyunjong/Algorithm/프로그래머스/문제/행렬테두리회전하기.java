package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;


/*
queries 길이만큼 반복하면서 (x1,y1)부터 시계방향으로 돌린다. 그 중 최소 값을 저장해서 배열에 저장한다.
회전시키는 배열의 값을 cloneBoard에 저장하고 회전이 끝난다면 cloneBoard를 board로 재선언한다.
자바는 call by value이기 때문에 함수를 만들었을 때 min이나 cloneBoard 둘 중 하나를 선택해야하는데
함수를 사용하지 않고 바로 생 구현했다.
 */
public class 행렬테두리회전하기 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

		int[] result = solution(rows, columns, queries);
		for(int i=0;i< queries.length;i++){
			System.out.println(result[i]);
		}
	}

	static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] board = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = num++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int[][] cloneBoard = cloneBoard(board, rows, columns);

			int min = Integer.MAX_VALUE;

			int[] query = queries[i];
			int x1 = query[0]-1;
			int y1 = query[1]-1;
			int x2 = query[2]-1;
			int y2 = query[3]-1;

			for (int y = y1; y < y2; y++) {
				cloneBoard[x1][y + 1] = board[x1][y];
				min = Math.min(min, board[x1][y]);
			}

			for (int x = x1; x < x2; x++) {
				cloneBoard[x + 1][y2] = board[x][y2];
				min = Math.min(min, board[x][y2]);
			}

			for (int y = y2; y > y1; y--) {
				cloneBoard[x2][y - 1] = board[x2][y];
				min = Math.min(min, board[x2][y]);
			}

			for (int x = x2; x > x1; x--) {
				cloneBoard[x - 1][y1] = board[x][y1];
				min = Math.min(min, board[x][y1]);
			}

			board = cloneBoard;

			answer[i] = min;
		}

		return answer;
	}

	static int[][] cloneBoard(int[][] board, int rows, int columns) {
		int[][] cloneBoard = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cloneBoard[i][j] = board[i][j];
			}
		}
		return cloneBoard;
	}
}
