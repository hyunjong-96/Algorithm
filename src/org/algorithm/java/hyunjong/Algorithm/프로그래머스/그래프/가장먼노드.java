package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그래프;

import java.util.LinkedList;
import java.util.Queue;

/*
bfs를 통해 가장 거리가 먼 노드의 갯수를 구할수있다.
bfs로 1 노드를 시작으로 방문하지 않은 자식 노드들을 순환하며 자신의 distance에서 +1을 해주어 queue에 저장.
queue에서 노드를 꺼낼때 현재 선언되어있는 maxDistance보다 크다면 해당 distance를 maxDistance에 재선언해준다, maxCount=0
그리고 maxDistance와 현재 노드의 distance가 같다면 maxCount를 +1해줌.
 */
public class 가장먼노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n,vertex));
	}

	static LinkedList<Integer>[] edge;
	static boolean[] visit;
	static int maxCount;
	static int maxDistance;

	static int solution(int N, int[][] vertex){
		edge = new LinkedList[N+1];
		visit = new boolean[N+1];
		for(int i=0;i<N+1;i++){
			edge[i] = new LinkedList<>();
		}
		for(int i=0;i<vertex.length;i++){
			int[] e = vertex[i];
			edge[e[0]].add(e[1]);
			edge[e[1]].add(e[0]);
		}

		bfs();

		int answer = maxCount;
		return answer;
	}

	static void bfs(){
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visit[1] = true;

		maxDistance=0;
		maxCount=0;
		while(!queue.isEmpty()){
			Node n = queue.poll();

			if(n.distance > maxDistance){
				maxDistance = n.distance;
				maxCount=0;
			}
			if(n.distance == maxDistance){
				maxCount++;
			}
			LinkedList<Integer> ll = edge[n.num];
			for(int child : ll){
				if(!visit[child]){
					visit[child] = true;
					queue.add(new Node(child, n.distance+1));
				}
			}
		}
	}

	static class Node{
		int num;
		int distance;
		public Node(int num, int distance){
			this.num = num;
			this.distance = distance;
		}
	}
}
