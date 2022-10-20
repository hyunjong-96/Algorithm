package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
모든 섬을 잇는데 최소의 비용을 찾는 문제이므로 크루스칼을 이용해 MST(최소 신장 트리)를 구한다.
1. 주어진 간선의 비용에 대해서 정렬
2. 정렬된 간선에 대해서 union여부를 판단하고 사이클 발생시 해당 간선은 무시한다.
	그렇지 않다면 두 정점을 union하고 총 비용을 갱신한다.
3. 문제에 모든 섬은 연결될수 있도록 주어지기 때문에 연결여부를 확인하지 않고 총 비용을 반환한다.
 */
public class 섬연결하기 {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));
	}

	static int INF = 100000000;

	static public int solution(int n, int[][] costs) {
		// int[][] map = new int[n][n];
		// for(int i=0;i<n;i++){
		//     Arrays.fill(map[i], INF);
		// }

		List<List<int[]>> map = new ArrayList<>();
		for(int i=0;i<n;i++){
			map.add(new ArrayList<>());
		}

		for(int i=0;i<n;i++){
			int i1 = costs[i][0];
			int i2 = costs[i][1];
			int c = costs[i][2];
			map.get(i1).add(new int[]{i2,c});
			map.get(i2).add(new int[]{i1,c});
		}

		int[] cost = new int[n];
		for(int i=0;i<n;i++){
			cost[i] = INF;
		}

		dijkstra(map, cost);

		int answer = 0;
		for(int i=1;i<n;i++){
			answer += cost[i];
		}
		return answer;
	}

	static public void dijkstra(List<List<int[]>> map, int[] cost){
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[]o2)->{
			return o1[1]-o2[1];
		});

		//0:E, 1:C
		pq.offer(new int[]{0,0});

		while(!pq.isEmpty()){
			int[] current = pq.poll();

			for(int[] link : map.get(current[0])){
				if(cost[link[0]] > link[1]+current[1]){
					cost[link[0]] = link[1]+current[1];
					pq.offer(new int[]{link[0], link[1]+current[1]});
				}
			}
		}
	}
}
