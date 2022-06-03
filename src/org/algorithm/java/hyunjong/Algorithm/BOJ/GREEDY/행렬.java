package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행렬 {
	static int N;
	static int M;
	static int[][] A;
	static int[][] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(row[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				B[i][j] = Integer.parseInt(row[j]);
			}
		}

		int answer = 0;
		for (int i = 0; i < N * M; i++) {
			if (A[i / M][i % M] != B[i/M][i%M]) {
				if (!change(i/M, i%M)) {
					answer = -1;
					break;
				} else {
					answer++;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static boolean change(int y, int x) {
		if (y + 2 >= N || x + 2 >= M)
			return false;

		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				A[i][j] = 1 - A[i][j];
			}
		}

		return true;
	}
}
