package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N_Queen {
	static int[][] board;
	static int[] col;
	static int answer;

	//위,왼,아래,오,왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽 아래
	static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		col = new int[N];
		answer = 0;
		setQueen(0, N, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setQueen(int count, int N, int y) {
		if (count == N) {
			// if (validation(N))
			answer++;
			return;
		}

		for (int j = 0; j < N; j++) {
			if(validation(y,j,N)){
				col[y] = j;
				setQueen(count+1, N, y+1);
			}
			// if (board[y][j] == 0 && validation(y,j,N)) {
			// 	board[y][j] = 1;
			// 	setQueen(count + 1, N, y + 1);
			// 	board[y][j] = 0;
			// }
		}

	}

	static boolean validation(int y, int x, int N){
		for(int r=0;r<y;r++){
			if(col[r]==x) return false;
			if((y-r)==Math.abs(x-col[r])) return false;
		}
		return true;
		// for(int d=0;d<8;d++){
		// 	int ny = y+dy[d];
		// 	int nx = x+dx[d];
		// 	while(ny>=0&&nx>=0&&ny<N&&nx<N){
		// 		if(board[ny][nx]==1) return false;
		//
		// 		ny+=dy[d];
		// 		nx+=dx[d];
		// 	}
		// }
		// return true;
	}
}
