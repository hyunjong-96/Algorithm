package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 플로이드2 {
	static int INF = 1000000000;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		List<Bus>[] edges = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		int[][] map = new int[N + 1][N + 1];
		String[][] corseMap = new String[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for(int j=1;j<=N;j++){
				map[i][j] = INF;
			}
		}
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[a].add(new Bus(b, c, "", 0));
		}

		for (int city = 1; city <= N; city++) {
			dijkstra(city, map[city], corseMap[city], edges);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == INF) map[i][j]=0;
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		for (int city = 1; city <= N; city++) {
			int[] distance = map[city];
			String[] travleCorse = corseMap[city];

			for(int target=1;target<=N;target++){
				if(distance[target] != 0){
					sb.append(travleCorse[target].split(" ").length).append(" ");
					sb.append(travleCorse[target]);
				}
				else{
					sb.append("0");
				}
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start, int[] distance, String[] travelCorse, List<Bus>[] edges) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		pq.offer(new Bus(start, 0, String.valueOf(start), 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Bus current = pq.poll();

			if (visit[current.target])
				continue;
			visit[current.target] = true;

			for (Bus link : edges[current.target]) {
				int nextCost = current.cost + link.cost;
				if (distance[link.target] > current.cost + link.cost) {
					String nextCorse = current.corse + " " + link.target;
					distance[link.target] = nextCost;
					travelCorse[link.target] = nextCorse;

					pq.offer(new Bus(link.target, nextCost, nextCorse, link.target));
				}
			}
		}
	}

	static class Bus implements Comparable<Bus> {
		int target;
		int cost;
		String corse;
		int prevCity;

		public Bus(int target, int cost, String corse, int prevCity) {
			this.target = target;
			this.cost = cost;
			this.corse = corse;
			this.prevCity = prevCity;
		}

		@Override
		public int compareTo(Bus o) {
			int result = this.cost - o.cost;
			if (result == 0)
				result = this.prevCity - o.prevCity;
			return result;
		}
	}
}