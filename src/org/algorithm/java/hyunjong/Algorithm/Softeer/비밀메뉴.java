package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 비밀메뉴 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] secret = new int[M];
		int[] use = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			secret[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			use[i] = Integer.parseInt(st.nextToken());
		}

		String result = "normal";
		for (int i = 0; i <= N - M; i++) {
			boolean isContain = true;
			for (int j = 0; j < M; j++) {
				if (use[i + j] != secret[j]) {
					isContain = false;
					break;
				}
			}

			if (isContain) {
				result = "secret";
				break;
			}
		}

		bw.write(result);
		bw.flush();
		bw.close();
	}
}
