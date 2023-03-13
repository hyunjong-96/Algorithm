package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 세수의합_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] U = new int[N];
		for (int i = 0; i < N; i++) {
			U[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(U);

		Set<Integer> set = initSet(U, N);
		String result = "";
		out:
		for (int k = N - 1; k >= 0; k--) {
			for (int z = 0; z < N; z++) {
				if (set.contains(U[k] - U[z])) {
					result = String.valueOf(U[k]);
					break out;
				}
			}
		}

		bw.write(result);
		bw.flush();
		bw.close();
	}

	static Set<Integer> initSet(int[] U, int N) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				set.add(U[i]+U[j]);
			}
		}

		return set;
	}
}
