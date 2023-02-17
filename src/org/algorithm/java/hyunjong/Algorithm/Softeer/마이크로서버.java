package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 마이크로서버 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int count = getServer(arr, N);
			sb.append(count).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int getServer(int[] arr, int N) {
		int serverCount = 0;
		int start = 0;
		int end = N - 1;

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] > 600) {
				serverCount++;
				end--;
			}
			if (arr[i] == 300) {
				start = i + 1;
				break;
			}
		}

		int num300 = start;

		while (start <= end) {
			if (start == end) {
				if (num300 > 0)
					num300--;
				serverCount++;
				break;
			}

			if (arr[start] + arr[end] <= 900) {
				serverCount++;
				start++;
				end--;
			} else if (num300 > 0) {
				serverCount++;
				end--;
				num300--;
			} else {
				serverCount++;
				end--;
			}

		}

		if (num300 > 0) {
			serverCount += (num300 + 2) / 3;
		}

		return serverCount;
	}
}
