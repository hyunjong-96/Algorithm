package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		int start = 0;
		int end = trees[N - 1];
		while (start < end) {
			int mid = (start + end + 1) / 2;

			long sum = 0;
			for (int tree : trees) {
				if (tree - mid > 0) {
					sum += tree - mid;
				}
			}

			if(sum>=M){
				start = mid;
			}else{
				end = mid-1;
			}
		}

		bw.write(String.valueOf(end));
		bw.flush();
		bw.close();
	}
}
