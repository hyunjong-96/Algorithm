package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어스톰 {
	static int N;
	static int Q;
	static int[] L;
	static int[][] map;
	static int mapSize;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		mapSize = (int)Math.pow(2, N);

		map = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		L = new int[Q];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			start(i);
		}
		checkIceGroup(sb);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void checkIceGroup(StringBuilder sb) {
		boolean[][] visit = new boolean[mapSize][mapSize];
		int iceCount = 0;
		int iceGroupRange = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				iceCount += map[i][j];
				if (map[i][j] != 0 && !visit[i][j]){
					iceGroupRange = Math.max(iceGroupRange, bfs(i, j, visit));
				}
			}
		}

		sb.append(iceCount);
		sb.append('\n');
		sb.append(iceGroupRange);
	}

	static int bfs(int y, int x, boolean[][] visit) {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {y, x});
		visit[y][x] = true;

		int groupSize = 1;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];
				if (ny >= 0 && nx >= 0 && ny < mapSize && nx < mapSize && !visit[ny][nx] && map[ny][nx] > 0) {
					queue.offer(new int[] {ny, nx});
					visit[ny][nx] = true;
					groupSize++;
				}
			}
		}

		return groupSize;
	}

	static void start(int turn) {
		int l = L[turn];

		moveIce(l);

		removeIce();
	}

	static void removeIce() {
		int[][] cloneMap = mapClone();
		int adjacentIce = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				adjacentIce = 0;
				if (map[i][j] == 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (ny >= 0 && nx >= 0 && nx < mapSize && ny < mapSize && map[ny][nx] > 0) {
						adjacentIce++;
					}
				}

				if (adjacentIce < 3) {
					cloneMap[i][j]--;
				}
			}
		}

		map = cloneMap;
	}

	static void moveIce(int l) {
		int rangSize = (int)Math.pow(2, l);
		int[][] cloneMap = new int[mapSize][mapSize];

		for (int r = 0; r < mapSize; r += rangSize) {
			for (int c = 0; c < mapSize; c += rangSize) {
				for(int i = 0;i<rangSize;i++){
					for(int j = 0;j<rangSize;j++){
						cloneMap[r+j][c+rangSize-i-1] = map[r+i][c+j];
					}
				}
			}
		}

		map = cloneMap;
	}

	static int[][] mapClone() {
		int[][] cloneMap = new int[mapSize][mapSize];

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				cloneMap[i][j] = map[i][j];
			}
		}
		return cloneMap;
	}
}
