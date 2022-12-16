package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] loss = new long[N];
		for (int i = 0; i < N; i++) {
			loss[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(loss);

		int start = 0;
		int end = N - 1;
		if (N % 2 != 0)
			end = N - 2;

		long max = getMaxLoss(start, end, loss);
		if (N % 2 != 0)
			max = Math.max(max, loss[N - 1]);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	static long getMaxLoss(int start, int end, long[] loss) {
		long max = 0;

		while (start < end) {
			max = Math.max(max, (loss[start] + loss[end]));
			start++;
			end--;
		}

		return max;
	}
}