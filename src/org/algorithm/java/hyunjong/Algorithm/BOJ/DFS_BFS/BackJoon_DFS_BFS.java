package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1260
public class BackJoon_DFS_BFS {
	static int[][] check; //간선 연결 상태
	static boolean[] checked;    //확인 여부
	static int n;    //정점개수
	static int m;    //간선개수
	static int v;    //시작정점

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		check = new int[n + 1][n + 1];
		checked = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			check[x][y] = check[y][x] = 1;
		}

		dfs(v);
		System.out.println();
		checked = new boolean[n+1];
		bfs();
	}

	public static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= n; j++) {
			if(check[i][j] == 1 && !checked[j]){
				dfs(j);
			}
		}
	}

	public static void bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		checked[v] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			for(int i =1;i<=n;i++){
				if(!checked[i] && check[node][i] == 1){
					queue.add(i);
					checked[i] = true;
				}
			}
			System.out.print(node+" ");
		}
	}
}
