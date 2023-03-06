package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class RGB거리_RE {
	static int answer;
	static int[][] colors;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		colors = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MAX_VALUE;

		for (int i = 1; i < N; i++) {
			colors[i][0] += Math.min(colors[i - 1][1], colors[i - 1][2]);
			colors[i][1] += Math.min(colors[i - 1][0], colors[i - 1][2]);
			colors[i][2] += Math.min(colors[i - 1][0], colors[i - 1][1]);
		}

		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, colors[N - 1][i]);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
