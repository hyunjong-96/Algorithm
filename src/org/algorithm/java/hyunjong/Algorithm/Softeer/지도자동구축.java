package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 지도자동구축 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int prevP = 2;
		int result = 4;

		for (int i = 1; i <= N; i++) {
			int currentP = prevP + (prevP - 1);
			result = (currentP * prevP) + (currentP * (prevP - 1));
			prevP = currentP;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
