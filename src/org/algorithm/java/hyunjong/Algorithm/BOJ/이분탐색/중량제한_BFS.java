package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 중량제한_BFS {
	static int N;
	static int M;
	static List<Edge>[] graph;
	static int max;
	static int start;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		max = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Edge(a, b, c));
			graph[b].add(new Edge(b, a, c));
			max = Math.max(max, c);
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int answer = binarySearch();
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int binarySearch(){
		int left = 0;
		int right = max;
		while(left<=right){
			int mid = (left+right)/2;

			if(bfs(mid)){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return right;
	}

	static boolean bfs(int tempCost){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1];

		visit[start] = true;
		queue.offer(start);

		while(!queue.isEmpty()){
			int v = queue.poll();
			if(v == end) return true;
			for(Edge e : graph[v]){
				if(!visit[e.v] && e.cost >= tempCost){
					queue.offer(e.v);
					visit[e.v] = true;
				}
			}
		}
		return false;
	}

	static class Edge {
		int u;
		int v;
		int cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
}
