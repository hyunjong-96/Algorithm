package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
5개의 돌을 놓았을때의 돌 중 가장 왼쪽에있고, 세로로 놓았다면 가장 위쪽 돌의 좌표를 반환해야한다.
그러므로 가장 왼쪽의 세로축 부터 오른쪽의 좌표를 탐색하면서 해당 좌표에서
왼쪽부분(위, 왼쪽 위, 왼쪽, 왼쪽 아래)과 오른쪽부붙(아래, 오른쪽 아래, 오른쪽, 오른쪽 외)를 비교하여 개수가 5개인지 확인한다.
연속된 돌의 개수가 5개인경우 해당 좌표를 반환한다.
좌표를 탐색할때 세로축에서 오른쪽으로 탐색하기 때문에 가장 왼쪽부터 탐색하게 된다. 그러므로 연속된 돌의 개수가 5개인 좌표를 찾았을때
해당 좌표가 가장 왼쪽 부분이다.
 */
public class 오목 {
	static int[][] board;

	static int[] dy = {-1,-1,0,1};
	static int[] dx = {0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		board = new int[20][20];
		for(int i=1;i<=19;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=19;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] pos = new int[2];
		int result = 0;
		for(int i=1;i<=19;i++){
			for(int j=1;j<=19;j++){
				if(board[j][i] != 0){
					for(int d=0;d<4;d++){
						int ny = j;
						int nx = i;
						int count=1;
						//위, 왼쪽위, 왼쪽, 왼쪽 아래
						while(true){
							ny += dy[d];
							nx += dx[d];
							if(ny>0 && nx>0 && ny<=19 && nx<=19 && board[ny][nx] == board[j][i]) count++;
							else break;
						}
						ny = j;
						nx = i;
						//아래, 오른쪽아래, 오른쪽, 오른쪽 위
						while(true){
							ny -= dy[d];
							nx -= dx[d];
							if(ny>0 && nx>0 && ny<=19 && nx<=19 && board[ny][nx] == board[j][i]) count++;
							else break;
						}

						if(count == 5){
							pos[0] = j;
							pos[1] = i;
							result = board[j][i];
							break;
						}
					}
				}
				if(result != 0) break;
			}
			if(result != 0) break;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result);
		if(result != 0){
			sb.append("\n");
			sb.append(pos[0]).append(" ").append(pos[1]);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
