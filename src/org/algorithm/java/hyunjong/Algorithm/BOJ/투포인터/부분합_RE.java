package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 부분합_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 1;
		int prefixSum = seq[0];
		int result = 100000;
		while (end <= N && start<end) {
			if (prefixSum < S) {
				if(end>=N) break;
				prefixSum += seq[end++];
			} else {
				result = Math.min(result, end - start);
				prefixSum -= seq[start++];
			}
		}

		result = result == 100000 ? 0 : result;

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}