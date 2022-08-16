package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info, edges));
	}

	static List<Integer>[] relation;
	static int answer=0;

	static int solution(int[] info, int[][] edges){
		relation = new ArrayList[info.length];

		for(int[] edge : edges){
			int parents = edge[0];
			int child = edge[1];

			if(relation[parents] == null){
				relation[parents] = new ArrayList<>();
			}
			relation[parents].add(child);
		}

		answer = 0;
		List<Integer> nextNode = new ArrayList<>();
		nextNode.add(0);
		countSheep(0, 0, 0, nextNode, info);

		return answer;
	}

	static void countSheep(int node, int sheepCount, int wolfCount, List<Integer> nextNode, int[] info){
		sheepCount += info[node] ^ 1;
		wolfCount += info[node];

		answer = Math.max(answer, sheepCount);

		if(wolfCount>=sheepCount) return;

		List<Integer> copyNextNode = new ArrayList<>(nextNode);

		copyNextNode.remove(Integer.valueOf(node));

		if(relation[node] != null){
			copyNextNode.addAll(relation[node]);
		}

		for(int next : copyNextNode){
			countSheep(next, sheepCount, wolfCount, copyNextNode, info);
		}
	}
}
