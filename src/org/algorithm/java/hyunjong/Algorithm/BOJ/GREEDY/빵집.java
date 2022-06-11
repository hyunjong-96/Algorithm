package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 빵집 {
	static int R;
	static int C;
	static String[][] map;
	static boolean[][] visit;

	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new String[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			// st = new StringTokenizer(br.readLine());
			String[] row = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = row[j];
			}
		}

		int count = 0;

		for (int r = 0; r < R; r++) {
			// boolean[][] cloneVisit = cloneVisit(visit);
			if (dfs(r, 0)) {
				// visit = cloneVisit;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static boolean dfs(int r, int c) {
		if (c == C - 1) {
			return true;
		}
		visit[r][c] = true;

		for (int d = 0; d < 3; d++) {
			int ny = r + dy[d];
			int nx = c + dx[d];

			if (ny >= 0 && nx >= 0 && ny < R && nx < C && !visit[ny][nx] && !map[ny][nx].equals("x")) {
				if(dfs(ny, nx)){
					return true;
				}
				// else{
				// 	visit[ny][nx] = false;
				// }
			}
		}
		return false;
	}
}
