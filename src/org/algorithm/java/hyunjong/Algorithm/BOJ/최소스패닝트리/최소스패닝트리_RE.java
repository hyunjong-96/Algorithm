package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최소스패닝트리_RE {
	static int[] union;
	static List<Edge> edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		union = new int[V + 1];
		// PriorityQueue<Edge> pq = new PriorityQueue<>();
		edgeList = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			union[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(A,B,C));
		}
		Collections.sort(edgeList);

		long result = mst(V);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static int mst(int V) {
		int result = 0;
		int count=0;
		for(Edge link : edgeList){
			if(find(link.a) != find(link.b)){
				union(link.a, link.b);
				result+= link.cost;

				if(++count == V-1) return result;
			}
		}

		return result;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			union[b] = a;
		} else {
			union[a] = b;
		}
	}

	static int find(int a) {
		if (union[a] == a)
			return a;

		return union[a] = find(union[a]);
	}

	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}