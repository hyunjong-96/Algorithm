package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
완전탐색과 백트래킹으로 3개의 꽃을 심을 수 있는 곳을 찾아서 최소의 비용으로 꽃을 심을수 있는 곳을 찾는다.
 */
public class 꽃길 {
	static int answer;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		for(int i=0;i<N;i++){
			String[] row = br.readLine().split(" ");
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(row[j]);
			}
		}

		answer = Integer.MAX_VALUE;

		setFlower(map, check, N, 0, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setFlower(int[][] map, boolean[][] check, int N, int cost, int depth){
		if(depth == 3){
			answer = Math.min(answer , cost);
			return;
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(checkSetFlower(map, check,N,i,j)){
					int currentCost = setCheck(map, check,i,j,true);
					setFlower(map, check, N, cost+currentCost, depth+1);
					setCheck(map, check,i,j,false);
				}
			}
		}
	}

	static boolean checkSetFlower(int[][] map, boolean[][] check, int N, int y, int x){
		for(int i=0;i<4;i++){
			int ny = dy[i]+y;
			int nx = dx[i]+x;

			if(ny<0 || nx<0 || ny>=N || nx>=N){
				return false;
			}
			if(check[ny][nx]){
				return false;
			}
		}
		return true;
	}

	static int setCheck(int[][] map, boolean[][] check, int y, int x, boolean isCheck){
		int cost = map[y][x];
		for(int i=0;i<4;i++){
			int ny = dy[i]+y;
			int nx = dx[i]+x;
			check[ny][nx]=isCheck;
			cost += map[ny][nx];
		}
		check[y][x] = isCheck;
		return cost;
	}
}
