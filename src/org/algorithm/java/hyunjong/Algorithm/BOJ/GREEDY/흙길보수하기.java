package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 흙길보수하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] pools = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pools[i] = new int[] {start, end};
		}

		Arrays.sort(pools, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int boardCount = 0;
		int board = 0;
		for (int[] pool : pools) {
			int start = pool[0];
			int end = pool[1];

			board = Math.max(board, start);

			if(end <= board) continue;

			int distance = end - board;
			int count = (int) Math.ceil((double)distance/L);

			board += (L*count);

			boardCount += count;
		}

		bw.write(String.valueOf(boardCount));
		bw.flush();
		bw.close();
	}
}
