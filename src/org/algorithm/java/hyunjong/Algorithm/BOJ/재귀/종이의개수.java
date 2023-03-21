package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 종이의개수 {
	static int[][] paper;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = new int[3];
		recursive(0, 0, N);

		StringBuilder sb = new StringBuilder();
		sb.append(count[2]).append("\n");
		sb.append(count[0]).append("\n");
		sb.append(count[1]).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void recursive(int startY, int startX, int N) {
		if (N == 1) {
			int e = getElement(paper[startY][startX]);
			count[e]++;
			return;
		}
		int size = N / 3;

		if (isPaper(startY, startX, N)) {
			int e = getElement(paper[startY][startX]);
			count[e]++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nextY = startY + size * i;
			for (int j = 0; j < 3; j++) {
				int nextX = startX + size * j;
				recursive(nextY, nextX, size);
			}
		}
	}

	static boolean isPaper(int y, int x, int N){
		int compare = paper[y][x];
		boolean isSame = true;

		out:
		for(int i=y;i<y+N;i++){
			for(int j=x;j<x+N;j++){
				if(compare != paper[i][j]){
					isSame = false;
					break out;
				}
			}
		}

		return isSame;
	}

	static int getElement(int element) {
		if (element == -1)
			return 2;
		else
			return element;
	}
}
