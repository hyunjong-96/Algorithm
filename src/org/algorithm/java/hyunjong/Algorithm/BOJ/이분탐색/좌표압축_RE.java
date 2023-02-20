package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class 좌표압축_RE {
	static int[] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] position = new int[N];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(st.nextToken());
			set.add(position[i]);
		}

		pos = new int[set.size()];
		int idx = 0;
		for (int p : set) {
			pos[idx++] = p;
		}
		Arrays.sort(pos);

		for (int i = 0; i < N; i++) {
			int target = position[i];

			int compression = binarySearch(pos, target);
			position[i] = compression;
		}

		StringBuilder sb = new StringBuilder();
		for (int c : position) {
			sb.append(c).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int binarySearch(int[] pos, int target) {
		int start = 0;
		int end = pos.length - 1;

		if(target == pos[0]) return 0;

		while (start < end) {
			int mid = (start + end + 1) / 2;

			if (pos[mid] >= target)
				end = mid - 1;
			else
				start = mid;
		}
		return end+1;
	}
}
