package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 전광판 {
	static int[][][] number;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		numberInit();
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();

			int[] aArr = new int[5];
			int[] bArr = new int[5];
			Arrays.fill(aArr, 10);
			Arrays.fill(bArr, 10);

			int idx = 0;
			for (int i = 5 - A.length(); i < 5; i++) {
				aArr[i] = Integer.parseInt(String.valueOf(A.charAt(idx++)));
			}
			idx = 0;
			for (int i = 5 - B.length(); i < 5; i++) {
				bArr[i] = Integer.parseInt(String.valueOf(B.charAt(idx++)));
			}

			int count = 0;
			for (int i = 0; i < 5; i++) {
				count += pushCount(aArr[i], bArr[i]);
			}
			sb.append(count).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int pushCount(int a, int b) {
		int count = 0;

		if (a == b)
			return count;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (number[a][i][j] != number[b][i][j])
					count++;
			}
		}
		return count;
	}

	static void numberInit() {
		number = new int[11][][];

		number[0] = new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 0, 0}, {1, 0, 1}, {0, 1, 0}};
		number[1] = new int[][] {{0, 0, 0}, {0, 0, 1}, {0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
		number[2] = new int[][] {{0, 1, 0}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {0, 1, 0}};
		number[3] = new int[][] {{0, 1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, 1}, {0, 1, 0}};
		number[4] = new int[][] {{0, 0, 0}, {1, 0, 1}, {0, 1, 0}, {0, 0, 1}, {0, 0, 0}};
		number[5] = new int[][] {{0, 1, 0}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 1, 0}};
		number[6] = new int[][] {{0, 1, 0}, {1, 0, 0}, {0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
		number[7] = new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
		number[8] = new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
		number[9] = new int[][] {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}, {0, 0, 1}, {0, 1, 0}};
		number[10] = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	}
}
