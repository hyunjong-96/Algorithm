package org.algorithm.java.hyunjong.Algorithm.BOJ.분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 풀링222 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		division(N, N);

		bw.write(String.valueOf(map[0][0]));
		bw.flush();
		bw.close();
	}

	static void division(int x, int y) {
		if (x == 0 && y == 0)
			return;

		int tempX = 0;
		int tempY = 0;
		for (int i = 0; i < y; i+=2) {
			tempX = 0;
			for (int j = 0; j < x; j+=2) {
				int num = getSecondNum(i, j);
				map[tempY][tempX] = num;
				tempX++;
			}
			tempY++;
		}

		division(x / 2, y / 2);
	}

	static int getSecondNum(int y, int x){
		List<Integer> list = new ArrayList<>();
		list.add(map[y][x]);
		list.add(map[y+1][x]);
		list.add(map[y][x+1]);
		list.add(map[y+1][x+1]);
		list.sort((o1, o2) -> o2 - o1);

		return list.get(1);
	}
}
