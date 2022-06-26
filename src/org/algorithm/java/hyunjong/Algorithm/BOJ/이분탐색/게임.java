package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		long answer = -1;
		int originRate = (int)(((long)Y * 100) / X);
		long start = 0;
		long end = 2000000000;

		while (start < end) {
			long mid = (start + end) / 2;

			int rate = (int)(((long)((Y + mid) * 100) / (X + mid)));

			if (originRate != rate) {
				answer = mid;
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
