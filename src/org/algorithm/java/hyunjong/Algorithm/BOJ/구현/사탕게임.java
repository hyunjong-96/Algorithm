package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 사탕게임 {
	static int N;
	static int[][] board;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				//C : 1, P : 2, Z : 3, Y : 4
				Character color = row.charAt(j);

				if (color == 'C') {
					board[i][j] = 1;
				} else if (color == 'P') {
					board[i][j] = 2;
				} else if (color == 'Z') {
					board[i][j] = 3;
				} else if (color == 'Y') {
					board[i][j] = 4;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && board[ny][nx] != board[i][j]) {
						int originPos = board[i][j];
						int nextPos = board[ny][nx];
						board[i][j] = nextPos;
						board[ny][nx] = originPos;

						int count = countCandy();
						max = Math.max(max, count);

						board[i][j] = originPos;
						board[ny][nx] = nextPos;
					}
				}
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	//(0,0)부터 시작해서 N-1까지 좌표를 이동하는데 수평이동과 수직이동을 for문 하나로 동시에 동작한다.
	//j가 1부터 N-1까지 이동할때, 수평이동은 [i][j], 수직이동은 [j][i]으로 동작한다.
	//j가 이동할때 [i][j] 또는 [j][i]값이 이전 값과 다르게 나온다면 개수와 값을 갱신시키고 maxCount에 큰 값을 갱신하고 이어서 동작한다.
	static int countCandy() {
		int maxCount = 1;

		for(int i=0;i<N;i++){
			int currentH = board[i][0];
			int currentV = board[0][i];
			int countH = 1;
			int countV = 1;

			for(int j=1;j<N;j++){
				//수평이동
				//수평이동중 이전과 다른 값이 나오게 되면 값과 개수를 갱신해준다.
				if(currentH != board[i][j]){
					maxCount = Math.max(maxCount, countH);

					currentH = board[i][j];
					countH = 1;
				}else countH++;

				//수직이동
				//수직이동 중 이전과 다른 값이 나오게 되면 값과 개수를 갱신해준다.
				if(currentV != board[j][i]){
					maxCount = Math.max(maxCount, countV);

					currentV = board[j][i];
					countV = 1;
				}else countV++;

				maxCount = Math.max(maxCount, Math.max(countH, countV));
			}
		}

		return maxCount;
	}
}
