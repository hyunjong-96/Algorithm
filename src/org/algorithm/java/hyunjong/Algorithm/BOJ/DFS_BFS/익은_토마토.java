package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//7576
public class 익은_토마토 {
	static int[][] box;
	static int M;//box의 가로
	static int N;//box의 세로
	static int[][] days;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = size[0];
		N = size[1];
		box = new int[N][M];
		days = new int[N][M];
		// ripen = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					queue.add(new int[] {i, j});
					days[i][j] = 0;
					// ripen[i][j] = true;
				}
				if (box[i][j] == -1) {
					days[i][j] = -1;
					// ripen[i][j] = true;
				}
			}
		}
		bfs(queue);

		boolean flag = true;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0){
					flag = false;
					break;
				}
				if(days[i][j]>max){
					max = days[i][j];
				}
			}
		}

		if(!flag) bw.write("-1");
		else bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	private static void bfs(Queue<int[]> queue) {
		while (!queue.isEmpty()) {

			int[] tomatoIndex = queue.poll();
			int x = tomatoIndex[0];
			int y = tomatoIndex[1];
			int curDay = days[x][y];
			if (y > 0 && box[x][y - 1] == 0) {
				queue.add(new int[] {x, y - 1});//왼쪽
				days[x][y - 1] = curDay + 1;
				box[x][y - 1] = 1;
			}
			if (y < M - 1 && box[x][y + 1] == 0) {
				queue.add(new int[] {x, y + 1});//오른쪽
				days[x][y + 1] = curDay + 1;
				box[x][y + 1] = 1;
			}
			if (x > 0 && box[x - 1][y] == 0) {
				queue.add(new int[] {x - 1, y});//위
				days[x - 1][y] = curDay + 1;
				box[x - 1][y] = 1;
			}
			if (x < N - 1 && box[x + 1][y] == 0) {
				queue.add(new int[] {x + 1, y});//아래
				days[x + 1][y] = curDay + 1;
				box[x + 1][y] = 1;
			}
		}
	}
}

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.Queue;
// 	public class Main{
// 		static int[][] box;
// 		static boolean[][] ripen;
// 		static int M;//box의 가로
// 		static int N;//box의 세로
// 		static int day;
//
// 		public static void main(String[] args) throws IOException {
// 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 			int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
// 			M = size[0];
// 			N = size[1];
// 			box = new int[N][M];
// 			ripen = new boolean[N][M];
// 			for (int i = 0; i < N; i++) {
// 				box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
// 			}
//
// 			boolean flag = true;
// 			day = 0;
// 			bfs();
// 			for (int i = 0; i < N; i++) {
// 				for (int j = 0; j < M; j++) {
// 					if (!ripen[i][j]) {
// 						flag = false;
// 						break;
// 					}
// 				}
// 			}
// 			if (flag)
// 				bw.write(String.valueOf(day));
// 			else
// 				bw.write("-1");
// 			bw.flush();
// 			bw.close();
// 		}
//
// 		private static void bfs() {
// 			Queue<int[]> queue = new LinkedList<>();
//
// 			for (int i = 0; i < N; i++) {
// 				for (int j = 0; j < M; j++) {
// 					if (box[i][j] == 1) {
// 						queue.add(new int[] {i, j});
// 						ripen[i][j] = true;
// 					}
// 					if (box[i][j] == -1) {
// 						ripen[i][j] = true;
// 					}
// 				}
// 			}
//
// 			while (!queue.isEmpty()) {
// 				LinkedList<int[]> ripenTomato = new LinkedList<>();
// 				while (!queue.isEmpty()) {
// 					ripenTomato.add(queue.poll());
// 				}
// 				for (int[] index : ripenTomato) {
// 					int x = index[0];
// 					int y = index[1];
// 					ripen[x][y] = true;
// 					if (y > 0 && !ripen[x][y - 1] && box[x][y - 1] != -1)
// 						queue.add(new int[] {x, y - 1});//왼쪽
// 					if (y < M - 1 && !ripen[x][y + 1] && box[x][y + 1] != -1)
// 						queue.add(new int[] {x, y + 1});//오른쪽
// 					if (x > 0 && !ripen[x - 1][y] && box[x - 1][y] != -1)
// 						queue.add(new int[] {x - 1, y});//위
// 					if (x < N - 1 && !ripen[x + 1][y] && box[x + 1][y] != -1)
// 						queue.add(new int[] {x + 1, y});//아래
// 				}
// 				if (!queue.isEmpty())
// 					day++;
//
// 			}
// 		}
// 	}
