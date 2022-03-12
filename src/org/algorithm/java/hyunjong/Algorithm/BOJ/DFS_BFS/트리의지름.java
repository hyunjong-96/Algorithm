package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {
	static int V, maxDistance, index;
	static List<Edge>[] tree;
	static boolean[] visit;

	static class Edge {
		int child;
		int distance;

		Edge(int child, int distance) {
			this.child = child;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parents = Integer.parseInt(st.nextToken());
			while (true) {
				int child = Integer.parseInt(st.nextToken());
				if (child == -1)
					break;
				int distance = Integer.parseInt(st.nextToken());

				tree[parents].add(new Edge(child, distance));
				tree[child].add(new Edge(parents, distance));
			}
		}
		visit = new boolean[V + 1];
		dfs(1, 0, 0);
		visit = new boolean[V + 1];
		dfs(index, 0, 0);

		bw.write(String.valueOf(maxDistance));
		bw.flush();
		bw.close();
	}

	static void dfs(int node, int parents, int distance) {
		visit[node] = true;

		if (distance > maxDistance) {
			index = node;
			maxDistance = distance;
		}
		for (Edge info : tree[node]) {
			if (!visit[info.child] && info.child != parents) {
				dfs(info.child, node, distance + info.distance);
			}
		}
	}
}
