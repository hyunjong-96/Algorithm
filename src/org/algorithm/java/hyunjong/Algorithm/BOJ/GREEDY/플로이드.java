package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/*
플로이드 워셜 알고리즘은
다익스트라 알고리즘과 달리 음수 사이클이 없는 그래프에서 모든 정점에서 각 모든 정점까지의 최단거리를 모두 구할수 있는 알고리즘
출발 노드에서 각 노드까지의 거리를 1차원 배열을 통해 최단 거리를 저장하는 다익스트라와는 달리
출발 노드가 아닌 모든 노드에서 모든 노드까지의 최단 거리를 모두 저장하기 위해 2차원 배열을 사용하는 플로이드 워셜이다.(DP)

알고리즘 순서
1. 최단거리를 저장할 2차원 배열에 자신을 거쳐가는 좌표를 제외하고 INF(무한대의 값)으로 초기화 한다.
2. 주어진 노드와 인접 노드 그리고 간선의 가중치를 통해 2차원 배열에 최단거리를 갱신한다.
3. 각 거쳐가는 노드 k와 i노드에서 j노드까지의 거리를 비교하여 더 작은 값을 graph[i][j]에 갱신해준다.

플로이드 워셜 알고리즘은 3중for문을 사용하기 떄문에 약 1000개의 N값 이상의 값이 들어오게 되면 시간초과가 발생할수 있으므로
잘 생각하고 접근해보자.
 */
public class 플로이드{
	static int INF = 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] graph = new int[N+1][N+1];

		for(int i=0;i<N+1;i++){
			for(int j=0;j<N+1;j++){
				if(i==j) continue;
				graph[j][i] = INF;
			}
		}
		//a:출발도시, b:도착도시, c:버스비용
		//graph 초기화
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = Math.min(graph[a][b],c);
		}
		//각 거쳐갈 노드
		for(int k=1;k<N+1;k++){
			//i노드에서 j노드
			for(int i=1;i<N+1;i++){
				for(int j=1;j<N+1;j++){
					if(graph[i][j] > graph[i][k]+graph[k][j]){
						graph[i][j] = graph[i][k]+graph[k][j];
					}
				}
			}
		}

		//접근할수 없는 노드인 경우 INF의 값이 배열에 저장되어 있는데
		//문제에서 접근할수 없는 노드의 경우 0을 출력하라고 했다.
		for(int i=1;i<N+1;i++){
			for(int j=1;j<N+1;j++){
				if(graph[i][j]==INF){
					sb.append(0).append(" ");
				}else{
					sb.append(graph[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}