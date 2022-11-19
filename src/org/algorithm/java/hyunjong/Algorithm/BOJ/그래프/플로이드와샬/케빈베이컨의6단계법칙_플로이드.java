package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.플로이드와샬;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 케빈베이컨의6단계법칙_플로이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] relations = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(relations[i], 100000000);
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relations[A][B] = 1;
			relations[B][A] = 1;
		}

		floydwashall(relations, N);

		int answer = 0;
		int minKavinBakun = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int kavinBakun = 0;
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				kavinBakun += relations[i][j];
			}

			if (minKavinBakun > kavinBakun) {
				answer = i;
				minKavinBakun = kavinBakun;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void floydwashall(int[][] relations, int N) {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(relations[i][j] > relations[i][k]+relations[j][k]){
						relations[i][j] = relations[i][k]+relations[j][k];
					}
				}
			}
		}
	}
}