package org.algorithm.java.hyunjong.Algorithm.BOJ.백트래킹;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class N과M_2 {
	static int[] arr;
	static int M;
	static int N;
	static List<String> list;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		list = new ArrayList<>();
		check = new boolean[N];

		Collections.sort(list);
		find(0, 0, "");

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(idx++)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void find(int idx, int depth, String seq) {
		if (depth == M) {
			list.add(seq.trim());
			return;
		}

		for (int i = idx; i <N; i++) {
			if (check[i])
				continue;

			check[i] = true;
			find(i, depth + 1, seq +" "+arr[i]);
			check[i] = false;
		}
	}
}
