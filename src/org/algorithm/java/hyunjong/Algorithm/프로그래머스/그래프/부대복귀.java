package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그래프;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
class Solution {
	public static void main(String[] args) {
		int n = 5;
		int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
		int[] sources = {1, 3, 5};
		int destination = 5;
		int[] result = solution(n, roads, sources, destination);
		System.out.println(Arrays.toString(result));
	}
	static List<Integer>[] edges;
	static int[] map;
	static int INF = 1000000000;
	static public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		edges = new List[n+1];
		map = new int[n+1];
		for(int i=1;i<=n;i++){
			edges[i] = new ArrayList<>();
		}

		for(int i=1;i<=n;i++){
			map[i] = INF;
		}
		map[destination] = 0;
		for(int[] road : roads){
			int a = road[0];
			int b = road[1];
			edges[a].add(b);
			edges[b].add(a);
		}

		dijkstra(destination, n);

		int[] answer = new int[sources.length];
		for(int i=0;i<sources.length;i++){
			answer[i] = map[sources[i]];
			if(answer[i] == INF) answer[i] = -1;
		}
		return answer;
	}

	static void dijkstra(int destination, int n){
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->{
			return o1[1]-o2[1];
		});

		pq.offer(new int[]{destination,0});

		while(!pq.isEmpty()){
			int[] current = pq.poll();
			int node = current[0];
			int distance = current[1];

			for(int link : edges[node]){
				if(map[link] > distance+1){
					pq.offer(new int[]{link,distance+1});
					map[link] = distance+1;
				}
			}
		}
	}
}
