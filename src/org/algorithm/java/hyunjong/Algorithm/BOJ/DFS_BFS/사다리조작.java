package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class 사다리조작 {
	static int N;
	static int M;
	static int H;
	static int[][] map;
	static int answer;
	static boolean finish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[a][b+1] = 2;
		}

		answer = 0;
		for(int i=0;i<=3;i++){
			answer = i;
			dfs(1, 0);
			if(finish) break;
		}

		if(!finish) answer = -1;

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean check(){
		for(int i=1;i<=N;i++){
			int x = i;
			for(int y=1;y<=H;y++){
				if(map[y][x] == 1) x++;
				else if(map[y][x]==2) x--;
			}
			if(i != x) return false;
		}
		return true;
	}
	static void dfs(int y, int count){
		if(finish) return;
		if(count == answer){
			if(check()){
				finish = true;
			}
			return;
		}

		for(int i=y;i<=H;i++){
			for(int j=1;j<N;j++){
				if(map[i][j]==0 && map[i][j+1]==0){
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(i,count+1);
					map[i][j] = map[i][j+1] = 0;
				}
			}
		}
	}
}
