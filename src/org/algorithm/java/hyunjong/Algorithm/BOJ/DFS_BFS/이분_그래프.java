package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1707
public class 이분_그래프 {
	// static int[][] check;
	static LinkedList<Integer>[] graph;
	// static boolean[] checked;
	// static int k; //테스트케이스 수
	// static int v;    //정점 수
	// static int e;    //간선 수
	static int[] color;    //노드의 색 red:1, blue:-1
	static boolean flag;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			graph = new LinkedList[v];
			color = new int[v];
			for(int j=0;j<v;j++){
				graph[j] = new LinkedList<>();
			}
			for (int j = 0; j < e; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[x-1].push(y);
				graph[y-1].push(x);
			}

			flag = true;
			for (int n = 0; n < v; n++) {
				bfs(n);
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void bfs(int n) {
		if (color[n] == 0) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(n);
			color[n] = 1;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for(int next : graph[cur]){
					if(color[next-1]==0){
						queue.add(next-1);
						color[next-1] = color[cur]*-1;
					}else if(color[cur]==color[next-1]){
						flag = false;
						break;
					}
				}
			}
		}
	}

	// public static void main(String[] args) throws IOException {
	// 	Scanner sc = new Scanner(System.in);
	// 	int k = sc.nextInt();
	//
	// 	for (int i = 0; i < k; i++) {
	// 		int v = sc.nextInt();
	// 		int e = sc.nextInt();
	// 		check = new int[v + 1][v + 1];
	// 		// checked = new boolean[v + 1];
	// 		color = new int[v + 1];
	// 		flag = true;
	// 		for (int j = 0; j < e; j++) {
	// 			int x = sc.nextInt();
	// 			int y = sc.nextInt();
	// 			check[x][y] = check[y][x] = 1;
	// 		}
	//
	// 		for (int n = 1; n <= v; n++) {
	// 			bfs(n);
	// 		}
	// 		if (flag)
	// 			System.out.println("YES");
	// 		else
	// 			System.out.println("NO");
	// 	}
	// }
	//
	// public static void bfs(int n) {
	// 	if (color[n] == 0) {
	// 		Queue<Integer> queue = new LinkedList<>();
	// 		queue.add(n);
	// 		color[n] = 1;
	// 		while (!queue.isEmpty()) {
	// 			int p = queue.poll();
	// 			for (int l = 1; l <= check.length-1; l++) {
	// 				if (color[l]==0&& check[p][l] == 1) {
	// 					queue.add(l);
	// 					color[l] = color[p] * -1;
	// 				}
	// 				if (color[l]!=0 && check[p][l] == 1 && color[p] == color[l]) {
	// 					flag = false;
	// 					break;
	// 				}
	// 			}
	// 		}
	// 	}
	// }
}
