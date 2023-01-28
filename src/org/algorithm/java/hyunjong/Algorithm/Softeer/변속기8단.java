package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 변속기8단 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] change = new int[8];
		for (int i = 0; i < 8; i++) {
			change[i] = Integer.parseInt(st.nextToken());
		}

		boolean isAsc = true;
		boolean isDesc = true;
		int ascValue = 1;
		int descValue = 8;

		for (int i = 0; i < 8; i++) {
			if (change[i] != ascValue++)
				isAsc = false;
			if (change[i] != descValue--)
				isDesc = false;
		}

		String result = "";
		if (isAsc)
			result = "ascending";
		else if (isDesc)
			result = "descending";
		else
			result = "mixed";

		bw.write(result);
		bw.flush();
		bw.close();
	}
}