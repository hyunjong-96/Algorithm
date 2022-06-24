package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중량제한 {
	static int N;
	static int M;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int start;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(a, b, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int answer = cruscal();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int cruscal() {
		for (int i = 0; i < M; i++) {
			Edge e = pq.poll();

			if (find(e.u) != find(e.v)) {
				union(e.u, e.v);
				if(find(parents[start]) == find(parents[end])){
					return e.cost;
				}
			}
		}
		return -1;
	}

	static void union(int v1, int v2){
		v1 = find(v1);
		v2 = find(v2);

		if(v1 > v2){
			parents[v1] = v2;
		}else{
			parents[v2] = v1;
		}
	}

	static int find(int v) {
		if (parents[v] == v)
			return v;
		else
			return find(parents[v]);
	}

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o1) {
			return o1.cost - this.cost;
		}
	}
}
