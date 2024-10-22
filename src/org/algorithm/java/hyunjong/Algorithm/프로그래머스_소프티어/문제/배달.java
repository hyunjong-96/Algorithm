package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
출발지점부터 각 마을까지의 최소 비용을 구하는 다익스트라 문제
List<Node>[] linked : 각 마을과 연결되어있는 마을과 거리 (인접 리스트)
int[] distance : 출발마을인 1번 마을과 각 마을과의 최소 거리 배열 (자기자신 [1]은 항상 0이다) [1]을 제외하고 모두 INF로 초기화

pq에 이동하려는 마을의 비용 기준 오름차순 정렬한다.
만약 이동하려는 마을의 현재 최소 비용(distance[v]) 가 현재까지 걸린 시간 + 이동해서 걸릴 시간보다 크다면 distance값을 갱신해주고
pq에 이동할 마을 정보와 해당 마을까지 걸린 시간을 저장한다. 그럼 pq에서 최소 시간인 값을 꺼내어 비교한다.

distance에서 K이하로 걸린 시간을 찾아서 count해준다.
 */
public class 배달 {
	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		System.out.println(solution(N,road,K));
	}
	static int INF = 100000000;

	static int solution(int N, int[][] road, int K){

		List<Node>[] linked = new List[N+1];

		for(int i=1;i<=N;i++){
			linked[i] = new ArrayList<>();
		}

		for(int i=0;i<road.length;i++){
			int a = road[i][0];
			int b = road[i][1];
			int c = road[i][2];

			linked[a].add(new Node(b,c));
			linked[b].add(new Node(a,c));
		}

		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		dijkstra(distance, linked, N);

		int answer = 0;
		for(int i=0;i<distance.length;i++){
			if(distance[i] <= K) answer++;
		}

		return answer;
	}

	static void dijkstra(int[] distance, List<Node>[] linked, int N){
		PriorityQueue<Node> pq = new PriorityQueue<>( (Node o1, Node o2) -> {
			return o1.cost - o2.cost;
		});
		boolean[] visit = new boolean[N+1];

		pq.offer(new Node(1,0));

		while(!pq.isEmpty()){
			Node current = pq.poll();

			if(visit[current.village]) continue;

			visit[current.village] = true;

			for(Node l : linked[current.village]){
				if(distance[l.village] > current.cost + l.cost){
					distance[l.village] = current.cost + l.cost;
					pq.offer(new Node(l.village, current.cost+l.cost));
				}
			}
		}
	}

	static class Node{
		int village;
		int cost;
		public Node(int village, int cost){
			this.village = village;
			this.cost = cost;
		}
	}
}
