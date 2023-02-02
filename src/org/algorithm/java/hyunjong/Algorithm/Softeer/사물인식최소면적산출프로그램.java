package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 사물인식최소면적산출프로그램 {
	static Point[] colors;
	static int result;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		colors = new Point[N + 1];

		for (int i = 1; i <= K; i++) {
			colors[i] = new Point();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			colors[k].pointList.add(new int[] {x, y});
		}

		result = Integer.MAX_VALUE;
		for (int[] point : colors[1].pointList) {
			dfs(point[0], point[1], point[0], point[1], 2, Integer.MAX_VALUE, K);
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static void dfs(int minX, int minY, int maxX, int maxY, int color, int size, int K) {
		if (color > K) {
			result = Math.min(result, size);
			return;
		}

		for (int[] point : colors[color].pointList) {
			int compareX = point[0];
			int compareY = point[1];

			int tmpMinX = minX;
			int tmpMinY = minY;
			int tmpMaxX = maxX;
			int tmpMaxY = maxY;

			if (compareX < minX)
				tmpMinX = compareX;
			else if (compareX > maxX)
				tmpMaxX = compareX;

			if (compareY < minY)
				tmpMinY = compareY;
			else if (compareY > maxY)
				tmpMaxY = compareY;

			int tmpSize = (tmpMaxX - tmpMinX) * (tmpMaxY - tmpMinY);
			if (tmpSize < result) {
				dfs(tmpMinX, tmpMinY, tmpMaxX, tmpMaxY, color + 1, tmpSize, K);
			}
		}
	}

	static class Point {
		List<int[]> pointList;

		public Point() {
			pointList = new ArrayList<>();
		}
	}
}
