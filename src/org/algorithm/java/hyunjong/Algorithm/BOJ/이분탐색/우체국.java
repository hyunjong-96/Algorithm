package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 우체국 {
	static int N;
	static int[][] village;
	static long[] sum;
	static int pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		village = new int[N][2];
		sum = new long[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			village[i] = new int[] {x, a};
		}

		Arrays.sort(village, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		sum[0] = village[0][1];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + village[i][1];
		}

		pos = village[N-1][0];
		binarySearch();

		bw.write(String.valueOf(pos));
		bw.flush();
		bw.close();
	}

	static void binarySearch() {
		int start = 0;
		int end = N - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			long leftSum = sum[mid];
			long rightSum = sum[N - 1] - sum[mid];

			if(leftSum >= rightSum){
				end = mid-1;
				pos = Math.min(pos, village[mid][0]);
			}else{
				start = mid+1;
			}
		}
	}
}
