package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class 네트워크연결_크루스칼{
	static int[] union;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		union = new int[N+1];
		List<Edge> edges = new ArrayList<>();
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a,b,c));
		}

		for(int i=1;i<=N;i++){
			union[i]=i;
		}

		Collections.sort(edges);

		int answer = 0;

		for(Edge e : edges){
			if(find(e.start) == find(e.end)) continue;

			answer += e.cost;
			union(e.start, e.end);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int find(int a){
		if(union[a]==a) return a;
		return union[a] = find(union[a]);
	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a>b){
			int tmp = b;
			b = a;
			a = tmp;
		}

		union[b] = a;
	}

	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		public Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o){
			int result = this.cost - o.cost;
			if(result == 0) result = this.start - o.start;
			return result;
		}
	}
}
