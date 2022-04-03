package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
모든 테트리미노를 구현한 뒤 조건에 맞도록 대칭시키려고 했는데 경우의 수가 너무 많아서 하다가 포기했다.
더 좋은 방법으로 dfs를 통해 'ㅗ' 계열의 테트리미노를 제외하고는 만들수 있는걸 알았다
dfs로 상하좌우로 방문하지 않은 좌표를 이동하면서 백트래킹을 하면 도형이 나오는 것이였다.(신기했다ㅋㅋ)
그리고 'ㅗ'계열의 테트리미노같은 경우 'ㅏ','ㅗ',ㅓ','ㅜ'를 할수 있도록 각각 x, y가 배열 범위에서 벗어나지 않는 한에서
필터링을 해주고 해당 도형 안의 값들의 합을 비교해주면 된다.
 */
public class 테트리미노 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int ans;

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		for (int i = 0; i < N * M; i++) {
			visit[i / M][i % M] = true;
			dfs(i / M, i % M, 1, map[i / M][i % M]);
			check(i / M, i % M);
			visit[i / M][i % M] = false;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static void dfs(int y, int x, int count, int sum) {
		//deph가 4일때는 더이상 좌표로 이동하지 않고 방문했던 좌표 값들의 합을 ans와 비교.
		if (count >= 4) {
			ans = Math.max(sum, ans);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			//범위를 벗어나거나 방문했다면 해당 다음 좌표 움직임 취소
			if (nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx])
				continue;

			//백트래킹
			visit[ny][nx] = true;
			dfs(ny, nx, count + 1, sum + map[ny][nx]);
			visit[ny][nx] = false;
		}
	}

	//'ㅗ'계열의 테트리미노를 탐색하는 함수
	static void check(int y, int x) {
		//'ㅜ'
		/*
		하나만 예시를 보여주자면
		(y,x)
		(y+1,x)(y+1,x+1)
		(y+2,x)
		을 만족하는 좌표를 조건을 통해서 걸러주고 해당 테트로미노에 포함되는 값을의 합을 ans와 비교해주면된다.
		 */
		if (y < N - 1 && x < M - 2) {
			ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
		}
		//'ㅏ'
		if (y < N - 2 && x < M - 1) {
			ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
		}
		//'ㅗ'
		if (y > 0 && x < M - 2) {
			ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
		}
		//'ㅓ'
		if (y < N - 2 && x > 0) {
			ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);
		}
	}

}
