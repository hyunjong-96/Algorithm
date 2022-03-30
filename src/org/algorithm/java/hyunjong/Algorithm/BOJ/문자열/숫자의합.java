package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String numString = br.readLine();

		int sum=0;
		for (int i = 0; i < N; i++) {
			sum += numString.charAt(i) - '0';
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
