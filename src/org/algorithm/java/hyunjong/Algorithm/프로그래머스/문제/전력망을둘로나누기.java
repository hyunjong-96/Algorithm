package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.ArrayList;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/86971

전력망의 송신탑을 인접리스트로 초기화 해준다.
최대 100개의 송신탑이 있으므로 완탐이 가능할것같다는 생각이 들었다.

각 송신탑을 돌면서 연결된 송신탑과의 연결을 하나하나 끊는다.
	끊는 것은 boolean[][] 타입으로 선언하여 true이면 끊겼다고 생각한다.
	그리고 방문했음을 나타낼수도 있다.

끊어진 두 송신탑부터 dfs를 수행하여 각 송신탑에서 연결된 송신탑 개수를 반환한다.
최대한 비슷한 개수의 송신탑을 가지며 차이 개수를 구하라 하였으니 두 송신탑에 연결된 송신탑의 차가 최소가 되는 것을 반환한다.

각 송신탑을 돌면서 연결된 송신탑을 하나씩 끊어주는데 인접 리스트이기 때문에 O(100+99)
	근데 구현에서는 중복되는 연결된 송신탑을 끊어주는 것을 구현하지 못해서 아마 O(100^2)일꺼다
그리고 두개의 송신탑에서 dfs를 해주니까 O(v+e)
	결국 두 송신탑이 나뉘어졌기 때문에 반반이라고 생각하면 한개의 dfs가 발생했다고 생각했다.
	(확신이 안섬)
 */
public class 전력망을둘로나누기 {
	public static void main(String[] args) {
		int n = 7;
		int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		System.out.println(solution(n, wires));
	}

	static int solution(int n, int[][] wires){
		List<Integer>[] link = new List[101];
		for(int i=0;i<=100;i++){
			link[i] = new ArrayList<>();
		}

		for(int[] wire : wires){
			int v1 = wire[0];
			int v2 = wire[1];

			link[v1].add(v2);
			link[v2].add(v1);
		}

		int answer = cut(link);

		return answer;
	}

	static int cut(List<Integer>[] link){
		boolean[][] visit = new boolean[101][101];
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=100;i++){
			for(int l : link[i]){
				visit[i][l] = true;
				visit[l][i] = true;
				int v1Count = count(link, visit, i);
				int v2Count = count(link, visit, l);
				visit[i][l] = false;
				visit[l][i] = false;

				min = Math.min(min, Math.abs(v1Count-v2Count));
			}
		}

		return min;
	}

	static int count(List<Integer>[] link, boolean[][] visit, int v){
		int count = 1;
		for(int l : link[v]){
			if(!visit[v][l] && !visit[l][v]){
				visit[v][l] = true;
				visit[l][v] = true;
				count += count(link, visit, l);
				visit[v][l] = false;
				visit[l][v] = false;
			}
		}

		return count;
	}
}
