package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int count;
	static int perCount;
	static ArrayList<Integer> perCountList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];

		//초기화
		for (int i = 0; i < N; i++) {
			String rowString = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = rowString.charAt(j)-'0';
			}
		}

		count=0;
		perCountList = new ArrayList<>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if(!checked[row][col] && map[row][col] == 1){
					perCount=0;
					dfs(row, col);
					count++;
					perCountList.add(perCount);
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.write("\n");
		Collections.sort(perCountList);
		for(int perCount : perCountList){
			bw.write(String.valueOf(perCount));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int r, int c){
		if(map[r][c] == 0 || checked[r][c]) return;
		checked[r][c] = true;
		perCount++;
		if(r>0) dfs(r-1,c);
		if(r<N-1) dfs(r+1,c);
		if(c>0) dfs(r,c-1);
		if(c<N-1) dfs(r,c+1);
	}
}
