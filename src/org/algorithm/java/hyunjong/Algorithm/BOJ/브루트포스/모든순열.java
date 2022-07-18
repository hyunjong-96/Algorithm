package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 모든순열 {
	static int N;
	static int[] permutation;
	static Set<String> set;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		permutation = new int[N + 1];
		set = new HashSet<>();
		visit = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			permutation[i] = i;
		}

		setPermutation("");

		List<String> list = new ArrayList<>(set);
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			s = s.replace("", " ");
			s = s.substring(1);
			sb.append(s);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void setPermutation(String p) {
		if (p.length() == N) {
			set.add(p);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				setPermutation(p + permutation[i]);
				visit[i] = false;
			}
		}
	}
}
