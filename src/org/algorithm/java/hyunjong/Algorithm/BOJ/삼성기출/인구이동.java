package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

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

public class 인구이동 {
	static int N;
	static int L;
	static int R;
	static int[][] map;
	static int[][] groupMap;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int res = 0;

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			int group = 1;
			groupMap = new int[N][N];
			visit = new boolean[N][N];
			List<List<Point>> pointLists = new ArrayList<>();
			pointLists.add(new ArrayList<>());
			for (int i = 0; i < N * N; i++) {
				if (!visit[i / N][i % N]) {
					List<Point> groupList = makeGroup(i % N, i / N, group);
					if (groupList.size() > 0) {
						group++;
						pointLists.add(groupList);
					}
				}
			}
			if (pointLists.size() == 1)
				break;

			for (int g = 1; g < pointLists.size(); g++) {
				setMove(pointLists.get(g));
			}
			res++;
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	static void setMove(List<Point> groupList){
		int sum = 0;
		for(Point p : groupList){
			sum += map[p.y][p.x];
		}
		for(Point p : groupList){
			map[p.y][p.x] = sum/groupList.size();
		}
	}

	static List<Point> makeGroup(int x, int y, int groupNumber) {
		List<Point> pointList = new ArrayList<>();
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[y][x] = true;
		boolean flag = false;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx]) {
					int gap = Math.abs(map[p.y][p.x] - map[ny][nx]);
					if (gap >= L && gap <= R) {
						if (p.y == y && p.x == x && !flag) {
							//위,오른쪽 검색사 시작 좌표 두번 들어감
							//시작 좌표를 넣어줘야
							flag = true;
							pointList.add(new Point(x, y));
							groupMap[p.y][p.x] = groupNumber;
						}

						visit[ny][nx] = true;
						groupMap[ny][nx] = groupNumber;
						queue.offer(new Point(nx, ny));
						pointList.add(new Point(nx, ny));
					}
				}
			}
		}
		return pointList;
	}


	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
