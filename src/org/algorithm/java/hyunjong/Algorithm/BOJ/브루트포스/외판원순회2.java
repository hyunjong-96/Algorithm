package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백트래킹을 이용해서 0부터 N까지 모든 도시를 방문했을 때의 최소값을 구한다.
//다른 도시로 이동하지 못하는 경우가 있는데 그 값은 0으로 나타내기 때문에 map[row][i] == 0이면 이동하지 않는다.(순회할수 있는 값은 반드시 주어지기 때문에 이동하지 않아도 결국 이동하는 경로는 존재한다.)
//
//모든 도시를 돌았을 때 시작하는 도시로의 이동값이 0이라면 이동할 수 없기 때문에 비용계산은 하지 않는다.(출발한 도시로 다시 와야한다)

public class 외판원순회2 {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			visit[i] = true;
			setCost(i, 0, 0, i);
			visit[i] = false;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setCost(int row, int sum, int dept, int start) {
		if (dept == N-1 && map[row][start] != 0) {
			answer = Math.min(answer, sum+map[row][start]);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i] && map[row][i] != 0) {
				visit[i] = true;
				setCost(i, sum + map[row][i], dept + 1, start);
				visit[i] = false;
			}
		}
	}
}
