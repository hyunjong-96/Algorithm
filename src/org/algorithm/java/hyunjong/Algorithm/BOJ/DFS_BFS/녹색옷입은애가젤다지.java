package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] map;
	static int[][] costMap;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int depth = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			sb.append("Problem ").append(depth++).append(": ");

			map = new int[N][N];
			costMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					costMap[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra();
			// dfs(0, 0, map[0][0]);
			sb.append(costMap[N - 1][N - 1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		pq.offer(new int[] {0, 0, map[0][0]});

		while (!pq.isEmpty()) {
			int[] current = pq.poll();


			for (int d = 0; d < 4; d++) {
				int ny = current[0] + dy[d];
				int nx = current[1] + dx[d];

				if (ny >= 0 && nx >= 0 && ny < N && nx < N && costMap[ny][nx] > current[2]+map[ny][nx]){
					costMap[ny][nx] = current[2]+map[ny][nx];
					pq.offer(new int[]{ny,nx,costMap[ny][nx]});
				}
			}
		}

	}
}