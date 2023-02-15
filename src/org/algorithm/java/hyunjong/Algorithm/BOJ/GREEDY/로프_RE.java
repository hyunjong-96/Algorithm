package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.Arrays;

public class 로프_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int max = 0;
		int count = 1;
		for (int i = N-1; i >= 0; i--) {
			int weightPerRope = arr[i] * count++;
			max = Math.max(max, weightPerRope);
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}