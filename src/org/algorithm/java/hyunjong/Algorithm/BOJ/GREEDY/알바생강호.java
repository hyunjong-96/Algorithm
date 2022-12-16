package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.Arrays;

public class 알바생강호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long sum = 0;
		for (int i = 0; i < N; i++) {
			int tip = arr[N-1-i]-i;
			if(tip > 0) sum += tip;
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
