package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static int[][] map;
	static int[][] group;
	static int[][] distance;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		group = new int[N][N];
		map = new int[N][N];
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
				distance[i][j] = input - 1;
			}
		}

		//group 초기화
		int landMark = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && group[i][j] == 0) {
					dfs(i, j, landMark);
					landMark++;
				}
			}
		}

		//distance 초기화
		bfs();

		//설정된 distance값을 비교하면서 인접해있는 바다의 distance값의 group이 다르면
		// 현재 바다의 distance값과 다른 group의 distance값을 더해서 가장 작은값을 찾는다
		//반복문을 다 돌았을 떄의 min값이 가장 짧은 다리 길이.
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];

					if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
						if(group[i][j] != group[ny][nx]){
							min = Math.min(min, distance[i][j]+distance[ny][nx]);
						}
					}
				}
			}
		}
		System.out.println(min);
	}

	private static void dfs(int y, int x, int landMark) {
		group[y][x] = landMark;

		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (group[ny][nx] == 0 && map[ny][nx] == 1)
					dfs(ny, nx, landMark);
			}
		}
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		//map[][] == 1인 좌표를 큐에넣는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}

		//map[][]==1인 좌표에서 인접해있는 0(바다)을 현재 좌표인 distance[][]+1을 해주고
		// group[][]에 해당 좌표의 그룹 표시를 해준다.
		//땅과 인접해있는 모든 바다의 distance를 1로, group을 인접한 group으로 표시
		//그 이후 distance가 1인 바다와 인접해있는 다른 바다의 distance의 값을 설정 및 group설정을 해가는 식
		while(!queue.isEmpty()){
			int[] position = queue.poll();
			int i = position[0];
			int j = position[1];
			for (int k = 0; k < 4; k++) {
				int ny = i + dy[k];
				int nx = j + dx[k];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					if (distance[ny][nx] == -1) {	//아직 distance초기화가 안된경우
						distance[ny][nx] = distance[i][j] + 1;	//인접한 바다에는 현재의 distance값에 +1을 해준다.
						group[ny][nx] = group[i][j];	//그리고 distance값이 어느 group의 땅과의 거리인지 표시
						queue.add(new int[] {ny, nx});
					}
				}
			}
		}
	}
}
