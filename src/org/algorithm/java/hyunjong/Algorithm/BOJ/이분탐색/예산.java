package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] local = new int[N];

		int maxLocal = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			local[i] = Integer.parseInt(st.nextToken());
			maxLocal = Math.max(maxLocal, local[i]);
		}
		int M = Integer.parseInt(br.readLine());

		int answer = divide(local, M, maxLocal);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int divide(int[] local, int M, int maxLocal) {
		int start = 0;
		int end = maxLocal;

		while (start < end) {
			int mid = (start + end) / 2 + 1;

			int sum = 0;
			for (int i = 0; i < local.length; i++) {
				sum += Math.min(local[i], mid);
			}

			if(sum <= M){
				start = mid;
			}else{
				end = mid-1;
			}
		}

		return start;
	}
}
