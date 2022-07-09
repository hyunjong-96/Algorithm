package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_ {
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] areaZone;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		areaZone = new boolean[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(true){
			setAreaZone();
			if(!meltCheese()) break;

			time++;
			areaZone = new boolean[N][M];
		}

		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
	}

	static boolean meltCheese(){
		boolean[][] visit = new boolean[N][M];
		int[][] copyBoard = new int[N][M];
		int count=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(board[i][j]==1 && !visit[i][j]){
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{i,j});
					visit[i][j] = true;
					count++;
					while(!queue.isEmpty()){
						int[] current = queue.poll();

						int areaCount=0;
						for(int d=0;d<4;d++){
							int ny = current[0]+dy[d];
							int nx = current[1]+dx[d];
							if(ny>=0&&nx>=0&&ny<N&&nx<M){
								if(board[ny][nx]==1&&!visit[ny][nx]){
									queue.offer(new int[]{ny,nx});
									visit[ny][nx] = true;
									count++;
								}
								if(board[ny][nx]==0 && areaZone[ny][nx]) areaCount++;
							}
						}

						if(areaCount < 2){
							copyBoard[current[0]][current[1]] = 1;
						}
					}
				}
			}
		}
		board = copyBoard;

		return count != 0;
	}

	static void setAreaZone(){
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{0,0});
		areaZone[0][0] = true;

		while(!queue.isEmpty()){
			int[] current = queue.poll();

			for(int d=0;d<4;d++){
				int ny = current[0]+dy[d];
				int nx = current[1]+dx[d];
				if(ny>=0 && nx>=0 && ny<N && nx<M && board[ny][nx] == 0 && !areaZone[ny][nx]){
					queue.offer(new int[]{ny,nx});
					areaZone[ny][nx] = true;
				}
			}
		}
	}
}
