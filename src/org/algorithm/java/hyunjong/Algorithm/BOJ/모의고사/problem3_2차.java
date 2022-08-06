package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem3_2차 {
	public static void main(String[] args) {
		// int n = 3;
		int n = 5;
		// int[][] roads = {{1, 2}, {2, 3}};
		int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
		// int[] sources = {2, 3};
		int[] sources = {1, 3, 5};
		// int destination = 1;
		int destination = 5;

		int[] result = solution(n,roads,sources,destination);

		for(int i=0;i<sources.length;i++){
			System.out.println(result[i]);
		}
	}

	static List<Integer>[] map;
	static int[] time;
	static int[] solution(int n, int[][] roads, int[] sources, int destination){
		map = new List[n+1];
		time = new int[n+1];
		for(int i=1;i<=n;i++){
			map[i] = new ArrayList<>();
		}

		for(int[] road : roads){
			int a = road[0];
			int b = road[1];

			map[a].add(b);
			map[b].add(a);
		}

		for(int i = 1;i<=n;i++){
			time[i] = -1;
		}
		time[destination] = 0;

		int[] answer = new int[sources.length];
		bfs(n, destination);
		for(int i=0;i<sources.length;i++){
			answer[i] = time[sources[i]];
		}

		return answer;
	}

	static void bfs(int n, int destination){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n+1];

		queue.offer(destination);

		while(!queue.isEmpty()){
			int current = queue.poll();

			visit[current] = true;

			for(int linked : map[current]){
				if(visit[linked]) continue;
				visit[linked] = true;
				queue.offer(linked);
				time[linked] = time[current]+1;
			}
		}
	}
}
