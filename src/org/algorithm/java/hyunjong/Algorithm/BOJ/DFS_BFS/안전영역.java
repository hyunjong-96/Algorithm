package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
// 최대 100개의 N인 2차원 배열과 최대 1부터 100까지의 경우의 수를 구해야하기 때문에
// (100*100)(2차원 배열 크기)*100(1부터 100까지의 높이) = 10,000,000의 값을 계산해야한다면 n^2은 무리고 nlogn의 시간복잡도를 사용해야겠다 생각했다.
// 개인적으로 최대 20,000까지의 식을 계산해야 할때 n^2을 사용할수 있을꺼라 생각하고있다.(보류)

즉 2차원 배열을 모두 순환하면서 h(높이)를 비교해야한다면 직관적으로는 3중 for문이 나올수 있었다.

입력받을때 입력받은 값중 최소의 값과 최대의 값을 받아서 2중 배열에서 높이를 구할때 최소 높이부터 최대 높이까지만 구하도록 범위를 줄여준다.
그리고 높이를 기준으로 2차원 배열을 하나의 for문으로 돌수 있도록 하고 dfs를 실행시켜주고 안전구역 갯수를 count해준다.
2차원 배열을 도는 for문에서 빠져나오게 되면 maxSafeZone의 갯수와 해당 높이의 safeCount를 비교해줘서 큰 값을 maxSafeZone에 저장해준다.
작은 값부터 큰 값까지 for문을 돌고난 뒤의 maxSafeZone 값이 최대 safeZone의 갯수가 된다.
 */
public class 안전영역 {
	static int N;
	static int[][] space;
	static boolean[][] visit;
	static int smallH;
	static int bigH;
	static int[] dX = {0, 0, -1, 1};
	static int[] dY = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		smallH = Integer.MAX_VALUE;
		bigH = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				smallH = Math.min(smallH, h);
				bigH = Math.max(bigH, h);
				space[i][j] = h;
			}
		}

		int count = 0;
		int maxSafeZone = 1;
		for (int h = smallH; h < bigH; h++) {
			visit = new boolean[N][N];
			for (int i = 0; i < N * N; i++) {
				if (!visit[i / N][i % N] && space[i / N][i % N] > h) {
					dfs(i % N, i / N, h);
					count++;
				}
			}
			maxSafeZone = Math.max(count, maxSafeZone);
			count = 0;
		}

		bw.write(String.valueOf(maxSafeZone));
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int h) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dX[i];
			int nextY = y + dY[i];

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextY][nextX] && space[nextY][nextX] > h) {
				dfs(nextX, nextY, h);
			}
		}
	}
}
