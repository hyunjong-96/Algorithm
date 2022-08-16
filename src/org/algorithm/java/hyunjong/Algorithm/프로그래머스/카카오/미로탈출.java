package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

import java.util.HashMap;
import java.util.PriorityQueue;

public class 미로탈출 {
	public static void main(String[] args) {
		int n = 3, start = 1, end = 3;
		int[][] roads = new int[][] {{1,2,2},{3,2,3}};
		int[] traps = new int[] {2};
		System.out.println(solution(n,start,end,roads, traps));
	}

	static int INF = 100000000;
	static int[][] graph = new int[1001][1001];
	static int solution(int n, int start, int end, int[][] roads, int[] traps){
		for(int i=1;i<1001;i++){
			for(int j=1;j<1001;j++){
				if(i==j){
					graph[i][j] = 0;
				}else{
					graph[i][j] = INF;
				}
			}
		}

		for(int i=0;i< roads.length;i++){
			int[] road = roads[i];
			int p = road[0];
			int q = road[1];
			int s = road[2];

			if(graph[p][q] > s){
				graph[p][q] = s;
			}
		}

		return dijkstra(n, start, end, traps);
	}

	static int dijkstra(int n, int start, int end, int[] traps){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, start, 0));
		boolean[][] visit = new boolean[n+1][1<<10];

		while(!pq.isEmpty()){
			Node current = pq.poll();

			if(visit[current.node][current.state]) continue;
			if(current.node == end) return current.cost;
			visit[current.node][current.state] = true;

			boolean currentTrapped = false;
			HashMap<Integer, Boolean> trapped = new HashMap<>();
			//현재 노드의 상태가 trap이 켜져있는지 아닌지 확인
			for(int t = 0; t<traps.length;t++){
				int dit = 1 << t;
				if((current.state & dit) != 0){
					//켜져있고 현재 노드가 트랩 노드라면 state에서 해당 트랩노드를 끈다.
					if(current.node == traps[t]){
						current.state &= ~dit;
					}
					//켜져있고 현재 노드가 트랩 노드가 아니라면 trapped에 켜져있는 트랩을 넣는다.
					else{
						trapped.put(traps[t], true);
					}
				}else{
					//꺼져있고 현재 노드가 트랩 노드라면 trapped에 트랩을 넣고 currentTrapped를 false, state변경
					if(current.node == traps[t]){
						currentTrapped = true;
						trapped.put(traps[t],true);
						current.state |= dit;
					}
				}
			}

			for(int v = 1;v<=n;v++){
				if(current.node == v) continue;

				boolean nextTrapped = trapped.containsKey(v);
				if(currentTrapped == nextTrapped){
					if(graph[current.node][v] != INF){
						pq.add(new Node(current.cost+graph[current.node][v], v, current.state));
					}
				}else{
					if(graph[v][current.node] != INF){
						pq.add(new Node(current.cost+graph[v][current.node], v, current.state));
					}
				}
			}
		}
		return INF;
	}

	static class Node implements Comparable<Node>{
		int cost;
		int node;
		int state;
		public Node(int cost, int node, int state){
			this.cost = cost;
			this.node = node;
			this.state = state;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
