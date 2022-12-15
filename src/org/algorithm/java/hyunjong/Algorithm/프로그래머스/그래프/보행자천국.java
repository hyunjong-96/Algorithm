package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그래프;

class 보행자천국 {
	static int MOD = 20170805;
	static int[][] city_map;
	static int M;
	static int N;
	static int answer;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static int[][] direction = {{0, 1}, {1, 0}};

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		System.out.println(solution(m, n, cityMap));
	}

	static public int solution(int m, int n, int[][] cityMap) {
		city_map = cityMap;
		M = m;
		N = n;
		answer = 0;

		moveDirection(0, 0, 0);
		return answer;
	}

	static void moveDirection(int y, int x, int d) {
		if (y == M - 1 && x == N - 1) {
			answer++;
			return;
		}

		int condition = city_map[y][x];

		if (condition != 1) {
			for (int i = 0; i < 2; i++) {
				if (condition == 2 && i == 1)
					break;

				int newD = direction[d][i];
				int ny = y + dy[newD];
				int nx = x + dx[newD];

				if (ny >= 0 && nx >= 0 && ny < M && nx < N && city_map[ny][nx] != 1) {
					moveDirection(ny, nx, newD);
				}
			}
		}
	}
}
