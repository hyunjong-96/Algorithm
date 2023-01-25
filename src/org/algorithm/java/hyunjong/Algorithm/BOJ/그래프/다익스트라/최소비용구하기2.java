package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최소비용구하기2 {
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Bus>[] edges = new List[N + 1];
		int[] distance = new int[N + 1];
		String[] route = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
			distance[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges[start].add(new Bus(end, cost, ""));
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start, end, edges, distance, route, N);

		StringBuilder sb = new StringBuilder();
		sb.append(distance[end]).append("\n");
		sb.append(route[end].split(" ").length).append("\n");
		sb.append(route[end]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start, int end, List<Bus>[] edges, int[] distance, String[] route, int N) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];

		pq.offer(new Bus(start, 0, String.valueOf(start)));

		while (!pq.isEmpty()) {
			Bus current = pq.poll();

			if (check[current.des])
				continue;

			check[current.des] = true;
			if (current.des == end)
				break;

			for (Bus link : edges[current.des]) {
				int nextCost = current.cost + link.cost;
				String nextRoute = current.route + " " + String.valueOf(link.des);
				if (distance[link.des] > nextCost) {
					distance[link.des] = nextCost;
					route[link.des] = nextRoute;
					pq.offer(new Bus(link.des, nextCost, nextRoute));
				}
			}
		}
	}

	static class Bus implements Comparable<Bus> {
		int des;
		int cost;
		String route;

		public Bus(int des, int cost, String route) {
			this.des = des;
			this.cost = cost;
			this.route = route;
		}

		@Override
		public int compareTo(Bus o) {
			return this.cost - o.cost;
		}
	}
}
