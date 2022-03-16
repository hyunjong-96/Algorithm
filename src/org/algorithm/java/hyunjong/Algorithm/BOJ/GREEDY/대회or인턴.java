package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 대회or인턴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//여학생
		int M = Integer.parseInt(st.nextToken());//남학생
		int K = Integer.parseInt(st.nextToken());//인턴

		int max = 0;
		for (int mI = 0; mI <= K; mI++) {
			int gI = K - mI;
			int gL = (N - gI) / 2;
			int mL = M - mI;

			max = Math.max(max, (Math.min(gL, mL)));
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
