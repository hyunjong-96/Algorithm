package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 거스름돈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int pay = 1000 - N;
		int count = 0;
		while (pay != 0) {
			if (pay >= 500) {
				pay -= 500;
				count++;
			} else if (pay >= 100) {
				pay -= 100;
				count++;
			} else if (pay >= 50) {
				pay -= 50;
				count++;
			} else if (pay >= 10) {
				pay -= 10;
				count++;
			} else if (pay >= 5) {
				pay -= 5;
				count++;
			} else {
				pay -= 1;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
