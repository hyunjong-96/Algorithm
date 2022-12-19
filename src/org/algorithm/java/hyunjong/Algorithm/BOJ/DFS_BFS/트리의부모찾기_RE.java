package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class 트리의부모찾기_RE {
	static boolean[] check;
	static int[] parents;
	static List<Integer>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		check = new boolean[N + 1];
		edges = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int E1 = Integer.parseInt(st.nextToken());
			int E2 = Integer.parseInt(st.nextToken());

			edges[E1].add(E2);
			edges[E2].add(E1);
		}

		setParents(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void setParents(int current) {

		for (int link : edges[current]) {
			if (check[link])
				continue;

			check[link] = true;
			parents[link] = current;
			setParents(link);
		}
	}
}