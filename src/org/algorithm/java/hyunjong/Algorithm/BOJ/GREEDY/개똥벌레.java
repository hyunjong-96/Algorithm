package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 개똥벌레 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] bottom = new int[H];
		int[] top = new int[H];

		for (int i = 1; i <= N; i++) {
			int size = Integer.parseInt(br.readLine());
			if (i % 2 != 0) {
				bottom[size - 1] += 1;
			} else {
				top[(H - 1) - (size - 1)] += 1;
			}
		}

		int bottomSum = 0;
		int topSum = 0;
		for (int i = 0; i < H; i++) {
			bottomSum += bottom[H - 1 - i];
			bottom[H - 1 - i] = bottomSum;

			topSum += top[i];
			top[i] = topSum;
		}

		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < H; i++) {
			int sum = bottom[i] + top[i];

			if (sum < min) {
				count = 1;
				min = sum;
			}else if(sum == min){
				count++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(min);
		sb.append(" ");
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
