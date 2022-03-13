package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름2 {
	static List<Edge>[] tree;
	static int maxDistance;
	static int index;
	static class Edge {
		int next;
		int distance;

		public Edge(int child, int distance) {
			this.next = child;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parents = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			tree[parents].add(new Edge(child, distance));
			tree[child].add(new Edge(parents, distance));
		}

		dfs(1,0,0);
		dfs(index, 0, 0);

		bw.write(String.valueOf(maxDistance));
		bw.flush();
		bw.close();
	}

	static void dfs(int current, int parents ,int distance){
		if(distance > maxDistance){
			index = current;
			maxDistance = distance;
		}

		for(Edge nextNode : tree[current]){
			if(nextNode.next != parents)
				dfs(nextNode.next, current, nextNode.distance+distance);
		}
	}
}
