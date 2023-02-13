package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 코딩테스트세트 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			long[] tests = new long[2 * N - 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 2 * N - 1; i++) {
				tests[i] = Long.parseLong(st.nextToken());
			}

			long testSet = binarySearch(tests, N);
			sb.append(String.valueOf(testSet)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean isAvailable(long[] tests, long tmpSet, int N) {
		long[] copyTests = copy(tests);

		for (int i = 0; i < 2*N-2; i += 2) {
			if (copyTests[i] >= tmpSet) {
				copyTests[i + 2] += copyTests[i + 1];
			} else if (copyTests[i] + copyTests[i + 1] >= tmpSet) {
				copyTests[i + 2] += copyTests[i] + copyTests[i + 1] - tmpSet;
			} else {
				return false;
			}
		}
		return copyTests[2*N - 2] >= tmpSet;
	}

	static long binarySearch(long[] tests, int N) {
		long start = 0;
		long end = (long)(2 * Math.pow(10, 12));

		while (start < end) {
			long mid = (start + end +1) / 2;

			if (isAvailable(tests, mid, N)) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}

		return start;
	}

	static long[] copy(long[] tests) {
		long[] copy = new long[tests.length];

		for (int i = 0; i < tests.length; i++) {
			copy[i] = tests[i];
		}

		return copy;
	}
}
