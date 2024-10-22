package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그래프;

import java.util.ArrayList;
import java.util.List;

public class 모두0으로만들기 {
	public static void main(String[] args) {
		int[] a = {-2, 8, -5, -5, -3, 0, 5, 2};
		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}};
		System.out.println(solution(a,edges));
	}
	static long answer;
	static long sum;
	static int N;
	static long[] longA;
	static List<Integer>[] edge;
	static boolean[] check;
	static public long solution(int[] a, int[][] edges) {
		N = a.length;
		initEdge(a, edges);

		//6번 해결
		// if(sum != 0) return -1;

		answer = 0;
		dfs(a, 0);

		//모든 트리를 순환했을때 result가 0이아니라면 0을 만들 수 없는경우
		return answer;
	}

	//dfs로 트리 끝까지 이동하고 자식 노드의 값을 자신의 노드값을 더해서 부모 노드에게 반환
	static public long dfs(int[] a,int idx){
		long num = a[idx];
		check[idx] = true;
		for(int i=0;i<edge[idx].size();i++){
			int next = edge[idx].get(i);
			if(check[next]) continue;
			num += dfs(a, next);
		}

		//콜론을 이용한 반복
		// for(int e : edge[idx]){
		//     if(check[e]) continue;
		//     num += dfs(a, e);
		// }

		answer += Math.abs(num);
		return num;
	}

	//인접리스트 만들기
	static public void initEdge(int[] a, int[][] edges){
		edge = new List[N];
		check = new boolean[N];
		sum = 0;
		for(int i=0;i<N;i++){
			edge[i] = new ArrayList<>();
			sum += a[i];
		}


		for(int[] e : edges){
			int u = e[0];
			int v = e[1];

			edge[u].add(v);
			edge[v].add(u);
		}
	}
}
