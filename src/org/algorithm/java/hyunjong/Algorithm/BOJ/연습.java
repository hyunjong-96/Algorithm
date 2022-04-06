package org.algorithm.java.hyunjong.Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 연습 {
	static int N;
	static int M;
	static int[][] gas_map;
	static boolean[][] visit;
	static int ans;
	static List<Point> gas;
	static int wallCount;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas_map = new int[N][M];
		gas = new ArrayList<>();
		wallCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int e = Integer.parseInt(st.nextToken());
				gas_map[i][j] = e;
				if (e == 2) {
					gas.add(new Point(i, j));
				}
				if (e == 1) {
					wallCount++;
				}
			}
		}

		ans = Integer.MIN_VALUE;
		//3개 벽놓기
		setWall(0);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static void setWall(int cnt){
		if(cnt>=3){
			bfs();
			return;
		}

		for(int i=0;i<N*M;i++){
			if(gas_map[i/M][i%M] == 0){
				gas_map[i/M][i%M] = 1;
				setWall(cnt+1);
				gas_map[i/M][i%M] = 0;
			}
		}
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		visit = new boolean[N][M];
		for (Point p : gas) {
			queue.add(p);
			visit[p.y][p.x] = true;
		}

		int virusCount= gas.size();
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (ny >= 0 && nx >= 0 && ny < N && nx < M && gas_map[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx]=true;
					queue.add(new Point(ny, nx));
					virusCount++;
				}
			}
		}
		ans = Math.max(ans, (N*M)-wallCount-virusCount-3);
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
