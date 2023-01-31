package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;


public class 거리합구하기 {
	static int N;
	static List<int[]>[] edges;
	static long[] subtreeSize;
	static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		edges = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			edges[x].add(new int[] {y, t});
			edges[y].add(new int[] {x, t});
		}

		subtreeSize = new long[N + 1];
		distance = new long[N + 1];

		dfs1(1, 0);
		dfs2(1, 0);

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++){
			sb.append(distance[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dfs1(int current, int parents) {
		subtreeSize[current] = 1;

		for (int[] link : edges[current]) {
			int child = link[0];
			if (child != parents) {
				int cost = link[1];

				dfs1(child, current);
				subtreeSize[current] += subtreeSize[child];
				distance[current] += distance[child] + cost * subtreeSize[child];
			}
		}

		return;
	}

	static void dfs2(int current, int parents) {

		for (int[] link : edges[current]) {
			int child = link[0];
			if (child != parents) {
				int cost = link[1];
				distance[child] = distance[current] + cost*(N-2*subtreeSize[child]);
				dfs2(child, current);
			}
		}
	}
}