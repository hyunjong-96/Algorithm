package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Set<String> set = new LinkedHashSet<>();

		for (int i = 0; i < L; i++) {
			String request = br.readLine();

			if (set.contains(request)) {
				set.remove(request);
			}
			set.add(request);
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append(s).append("\n");
			if (++count == K)
				break;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
