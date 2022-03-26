package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N(세로), M(가로)가 3이상 8이하, 그리고 2초에 메모리 512mb 무조건 브루트포스라는 느낌이 확 왔다.
과정
1. 초기화
2. 벽을 세워주는 모든 경우의 수
3. 벽을 세운후 virus를 배포
4. 해당 벽을 세웠을때의 safe zone 크기 비교
 */
public class 연구소 {
	static int N;
	static int M;
	static int[][] map;
	static int max;
	static int wellCount;
	static List<Point> virus;
	static boolean[][] visit;
	static StringTokenizer st;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i][j] = e;
				if (e == 1)
					wellCount++;
				if (e == 2)
					virus.add(new Point(j, i));
			}
		}

		setWall(0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	/*
	map에서 0인 부분을 찾아 총 3개의 벽을 세우는 과정을 세운다.
	처음에는 3중 for문을 써야하나 싶었지만, N*M의 크기를 통해 각 행,렬을 구할수 있는 기가 막힌 방법을 찾아냈다.
	i를 0부터 N*M까지의 크기로 돌면서 i/M은 y축, i%M은 x축으로 놓고 모든 map을 돌면서 벽을 세워줄수 있다.
	ex) N=7, M =8, i = 9 일때 i/M = 1, i%M = 1이 되므로 좌표(1,1)의 위치를 바라볼수 있게 된다.
	재귀 함수를 통해 세워진 벽의 갯수를 파라미터값으로 넘겨주고 3개의 벽을 세우게 된다면 바이러스를 뿌려주게된다.
	바이러스를 뿌려 safe zone의 최대 갯수를 구하게 되면 마지막 벽을 제거한후
	다음 좌표에 벽을 세워 다시 바이러스를 뿌려주게된다.
	 */
	static void setWall(int count) {
		if (count == 3) {
			spreadVirus();
			return;
		}

		for (int i = 0; i < N * M; i++) {
			if (map[i / M][i % M] == 0) {
				map[i / M][i % M] = 1;
				setWall(count + 1);
				map[i / M][i % M] = 0;
			}
		}
	}

	/*
	3개의 벽이 세워졌을때 바이러스를 살포하게 되면 각 원 점 바이러스 부분에서 부터 bfs를 실행해준다.
	바이러스의 갯수는 바이러스가 살포가는 한 좌표를 찾았을 때 +1을 해주게 된다.
	그렇게 되었을때 이전 max값과 비교할때 N*M - virusCount - wallCount - 설치한 벽의갯수(3) = safe zone과 비교해
	max값을 비교하게된다.
	 */
	static void spreadVirus() {
		int virusCount = virus.size();
		visit = new boolean[N][M];

		Queue<Point> queue = new LinkedList<>();
		for (Point p : virus) {
			visit[p.y][p.x] = true;
			queue.add(new Point(p.x, p.y));
		}

		while (!queue.isEmpty()) {
			Point currentP = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nextX = currentP.x + dx[d];
				int nextY = currentP.y + dy[d];
				if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
					if (!visit[nextY][nextX] && map[nextY][nextX] == 0) {
						queue.add(new Point(nextX, nextY));
						visit[nextY][nextX] = true;
						virusCount++;
					}
				}
			}
		}
		max = Math.max(max, (N * M) - virusCount - wellCount - 3);
	}
}
