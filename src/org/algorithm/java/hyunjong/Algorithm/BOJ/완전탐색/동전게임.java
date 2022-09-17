package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
동전을 뒤집는 방향을 각 한번씩만 뒤집을 수 있다고 가정하였다.
예를 들어 첫번째 행을 뒤집고 첫번째 열을 뒤집고 그 다음 첫번째 행을 다시 뒤집는걸 제한하였다. (백트래킹)
그리고 해당 방향을 뒤집고 난 경우를 모두 다 확인했다면 visit를 풀어주고 다음 방향을 뒤집었을때 visit를 풀어줬던 방향을 선택할 수 있게 해준다.
 */
public class 동전게임 {
	static int answer;
	static int[][] dy={{0,0,0},{1,1,1},{2,2,2},{0,1,2},{0,1,2},{0,1,2},{0,1,2},{0,1,2}};
	static int[][] dx={{0,1,2},{0,1,2},{0,1,2},{0,0,0},{1,1,1},{2,2,2},{0,1,2},{2,1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			boolean[][] coins = new boolean[3][3];
			for (int i = 0; i < 3; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0;j<3;j++){
					coins[i][j] = row[j].equals("H");
				}
			}

			boolean[] visit = new boolean[8];
			answer = Integer.MAX_VALUE;
			change(coins, visit, 0);
			if(answer == Integer.MAX_VALUE) answer = -1;
			sb.append(answer);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void change(boolean[][] coins, boolean[] visit, int depth){
		int hCount=0;
		int tCount=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(coins[i][j]) hCount++;
				else tCount++;
			}
		}
		if(hCount == 0 || tCount == 0){
			answer = Math.min(answer, depth);
			return;
		}

		for(int i=0;i<8;i++){
			if(visit[i]) continue;
			visit[i] = true;
			for(int j=0;j<3;j++){
				int cy = dy[i][j];
				int cx = dx[i][j];
				coins[cy][cx] = !coins[cy][cx];
			}
			change(coins, visit, depth+1);
			for(int j=0;j<3;j++){
				int cy = dy[i][j];
				int cx = dx[i][j];
				coins[cy][cx] = !coins[cy][cx];
			}
			visit[i] = false;
		}
	}
}
