package org.algorithm.java.hyunjong.Algorithm.BOJ.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static List<int[]>[] graph;
	static int[] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new int[] {to, cost});
		}

		cost = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			cost[i] = 1000000000;
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, N);

		bw.write(String.valueOf(cost[end]));
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start, int N) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		boolean[] visit = new boolean[N + 1];

		pq.offer(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentCity = current[0];
			int currentCost = current[1];

			if(visit[currentCity]) continue;
			visit[currentCity] = true;

			for(int[] linked : graph[currentCity]){
				int linkedCity = linked[0];
				int linkedCost = linked[1];

				if(currentCost+linkedCost < cost[linkedCity]){
					cost[linkedCity] = currentCost+linkedCost;
					pq.offer(new int[]{linkedCity, currentCost+linkedCost});
				}
			}
		}
	}
}
