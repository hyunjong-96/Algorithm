package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
치킨 좌표 리스트를 만들어 M개의 치킨 좌표를 탐색하여 M개의 좌표를 탐색하여 값을 얻고나면
백트래킹으로 다음 좌표를 탐색해서 다시 다른 좌표와 M개의 좌표를 탐색하여 값을 얻도록 구현해야한다.

치킨 좌표와 사람의 좌표를 리스트에 넣어서 저장한후
dfs를 통해 현재 치킨 좌표의 index와 몇개의 치킨 좌표를 방문했는지에 대한 cnt를 argument로 호출한다.
cnt == M이 아니라면 현재 치킨좌표부터 리스트의 끝까지 탐색하고 방문여부를 true로 바꿔준다. 그후 반환되면 false(백트래킹)
cnt == M이라면 모든 사람들을 기준으로 방문한 치킨 좌표 M개에 대한 현재 사람과의 최소 치킨거리를 구하고 모든 사람과의 최소 치킨거리의 합을 구한다
모든 사람과의 최소 치킨거리의 합을 구했다면 다른 최소 치킨거리의 합과 비교하여 작은 값을 저장해주게되면 된다.
 */
public class 치킨배달 {
	static int N;
	static int M;
	static int min;
	static List<Point> chicken;
	static List<Point> person;
	static boolean[] visit;

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

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<>();
		person = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int element = Integer.parseInt(st.nextToken());
				if (element == 1) {
					person.add(new Point(j, i));
				} else if (element == 2) {
					chicken.add(new Point(j, i));
				}
			}
		}
		visit = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		dfs(0, 0);

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int ci, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int p = 0; p < person.size(); p++) {
				int minDistance = Integer.MAX_VALUE;
				for (int c = 0; c < chicken.size(); c++) {
					if (visit[c]) {	//방문한 치킨 좌표만 확인
						int distance =
							Math.abs(person.get(p).x - chicken.get(c).x) + Math.abs(person.get(p).y - chicken.get(c).y);
						minDistance = Math.min(distance, minDistance);	//해당 사람좌표와의 최소 치킨거리
					}
				}
				sum += minDistance; //모든 사람좌표에 대한 최소 치킨거리의 합
			}
			min = Math.min(min, sum);	//다른 최소 치킨거리의 합 비교
			return;
		}

		for (int i = ci; i < chicken.size(); i++) {	//현재 치킨좌표에서 cnt == M을 충종하기 위한 반복문
			visit[i] = true;
			dfs(i + 1, cnt + 1);	//현재 치킨좌표의 +1이 아닌 현재 치킨 좌표의 다음 치킨 좌표를 dfs해줘야함(실수한 부분)
			visit[i] = false;
		}
	}
}
