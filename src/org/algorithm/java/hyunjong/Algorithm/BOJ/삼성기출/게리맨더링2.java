package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링2 {
	static int N;
	static int[][] map;
	static boolean[][] lineMap;
	static int[][] rangeMap;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;
		setPointAndLine();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void countUserNumber() {
		int selector1 = 0;
		int selector2 = 0;
		int selector3 = 0;
		int selector4 = 0;
		int selector5 = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int selector = rangeMap[i][j];

				if (selector == 1) {
					selector1 += map[i][j];
				} else if (selector == 2) {
					selector2 += map[i][j];
				} else if (selector == 3) {
					selector3 += map[i][j];
				} else if (selector == 4) {
					selector4 += map[i][j];
				} else {
					selector5 += map[i][j];
				}
			}
		}
		// System.out.println("----------------------------");
		// System.out.println(
		// 	"1 : " + selector1 + " 2: " + selector2 + " 3: " + selector3 + " 4: " + selector4 + " 5: " + selector5);
		int[] selectors = new int[] {selector1, selector2, selector3, selector4, selector5};
		Arrays.sort(selectors);
		int max = selectors[4];
		int min = selectors[0];
		// System.out.println("gap :" + (max - min));
		// System.out.println("----------------------------");

		answer = Math.min(answer, max - min);
	}

	static void setRange(int x, int y, int d1, int d2) {
		rangeMap = new int[N + 1][N + 1];

		//1
		// setSelector1(x, y, d1, d2);
		for(int i=1;i<x+d1;i++){
			for(int j=1;j<=y;j++){
				if(lineMap[i][j]) break;
				rangeMap[i][j] = 1;
			}
		}

		//2
		// setSelector2(x, y, d1, d2);
		for(int i=1;i<=x+d2;i++){
			for(int j=N;j>y;j--){
				if(lineMap[i][j]) break;
				rangeMap[i][j] = 2;
			}
		}

		//3
		// setSelector3(x, y, d1, d2);
		for(int i=x+d1;i<=N;i++){
			for(int j=1;j<y-d1+d2;j++){
				if(lineMap[i][j]) break;
				rangeMap[i][j] = 3;
			}
		}

		//4
		// setSelector4(x, y, d1, d2);
		for(int i= x+d2+1;i<=N;i++){
			for(int j=N;j>=y-d1+d2;j--){
				if(lineMap[i][j]) break;
				rangeMap[i][j] = 4;
			}
		}

	}

	static void setLine(int x, int y, int d1, int d2) {
		lineMap = new boolean[N + 1][N + 1];

		//1 & 4
		for (int i = 0; i <= d1; i++) {
			lineMap[x + i][y - i] = true;
			lineMap[x + d2 + i][y + d2 - i] = true;
		}

		//2 & 3
		for (int i = 0; i <= d2; i++) {
			lineMap[x + i][y + i] = true;
			lineMap[x + d1 + i][y - d1 + i] = true;
		}
	}

	// static void setSelector1(int x, int y, int d1, int d2) {
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	boolean[][] visit = new boolean[N + 1][N + 1];
	// 	queue.add(new int[] {1, 1});
	//
	// 	while (!queue.isEmpty()) {
	// 		int[] current = queue.poll();
	//
	// 		for (int i = 0; i < 4; i++) {
	// 			int ny = current[0] + dy[i];
	// 			int nx = current[1] + dx[i];
	//
	// 			if (ny >= 1 && ny < x + d1 && nx >= 1 && nx <= y && !visit[ny][nx] && !lineMap[ny][nx]) {
	// 				visit[ny][nx] = true;
	// 				queue.add(new int[] {ny, nx});
	// 				rangeMap[ny][nx] = 1;
	// 			}
	// 		}
	// 	}
	// }
	//
	// static void setSelector2(int x, int y, int d1, int d2) {
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	boolean[][] visit = new boolean[N + 1][N + 1];
	// 	queue.add(new int[] {0, N});
	//
	// 	while (!queue.isEmpty()) {
	// 		int[] current = queue.poll();
	// 		for (int i = 0; i < 4; i++) {
	// 			int ny = current[0] + dy[i];
	// 			int nx = current[1] + dx[i];
	// 			if (ny >= 1 && ny <= x + d2 && nx > y && nx <= N && !visit[ny][nx] && !lineMap[ny][nx]) {
	// 				visit[ny][nx] = true;
	// 				queue.add(new int[] {ny, nx});
	// 				rangeMap[ny][nx] = 2;
	// 			}
	// 		}
	// 	}
	// }
	//
	// static void setSelector3(int x, int y, int d1, int d2) {
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	boolean[][] visit = new boolean[N + 1][N + 1];
	// 	queue.add(new int[] {N, 0});
	//
	// 	while (!queue.isEmpty()) {
	// 		int[] current = queue.poll();
	// 		for (int i = 0; i < 4; i++) {
	// 			int ny = current[0] + dy[i];
	// 			int nx = current[1] + dx[i];
	// 			if (ny >= x + d1 && ny <= N && nx >= 1 && nx < y - d1 + d2 && !visit[ny][nx] && !lineMap[ny][nx]) {
	// 				visit[ny][nx] = true;
	// 				queue.add(new int[] {ny, nx});
	// 				rangeMap[ny][nx] = 3;
	// 			}
	// 		}
	// 	}
	// }
	//
	// static void setSelector4(int x, int y, int d1, int d2) {
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	boolean[][] visit = new boolean[N + 1][N + 1];
	// 	queue.add(new int[] {N, N});
	//
	// 	while (!queue.isEmpty()) {
	// 		int[] current = queue.poll();
	// 		for (int i = 0; i < 4; i++) {
	// 			int ny = current[0] + dy[i];
	// 			int nx = current[1] + dx[i];
	// 			if (ny > x + d2 && ny <= N && nx >= y - d1 + d2 && nx <= N && !visit[ny][nx] && !lineMap[ny][nx]) {
	// 				visit[ny][nx] = true;
	// 				queue.add(new int[] {ny, nx});
	// 				rangeMap[ny][nx] = 4;
	// 			}
	// 		}
	// 	}
	// }

	static void setPointAndLine() {
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {

				for (int d1 = 1; d1 <= N; d1++) {
					if (y - d1 < 1)
						break;
					for (int d2 = 1; d2 <= N; d2++) {

						if (x + d1 + d2 > N || y + d2 > N)
							break;
						// System.out.println("x : " + x + " y : " + y + " d1 : " + d1 + " d2 : " + d2);
						// if (x == 3 && y == 3 && d1 == 1 && d2 == 1) {
						// 	System.out.println("ji");
						// }
						setLine(x, y, d1, d2);
						setRange(x, y, d1, d2);
						countUserNumber();
					}
				}
			}
		}
	}
}
