package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.util.Scanner;

//11724
public class 연결_요소의_갯수 {
	static int[][] check;
	static boolean[] checked;
	static int n;
	static int m;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m= sc.nextInt();
		check = new int[n+1][n+1];
		checked = new boolean[n+1];
		for(int i=0;i<m;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			check[x][y] = check[y][x] = 1;
		}

		int componentCount = 0;
		for(int i=1;i<=n;i++){
			if(!checked[i]){
				dfs(i);
				componentCount++;
			}
		}
		System.out.println(componentCount);
	}

	public static void dfs(int i){
		checked[i]=true;
		for(int j = 1; j<=n;j++){
			if(check[i][j]==1 && !checked[j]){
				dfs(j);
			}
		}
	}
}
