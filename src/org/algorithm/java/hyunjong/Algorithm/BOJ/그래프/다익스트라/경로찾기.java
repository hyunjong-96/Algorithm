package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class 경로찾기{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> G = new ArrayList<>();
		for(int i=0;i<N;i++){
			G.add(new ArrayList<>());
		}
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				int node = Integer.parseInt(st.nextToken());
				if(node == 1){
					G.get(i).add(j);
				}
			}
		}

		int[][] graph = new int[N][N];
		for(int i=0;i<N;i++){
			dijkstra(G, N, graph, i);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dijkstra(List<List<Integer>> G, int N, int[][] graph, int start){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N];

		queue.offer(start);


		while(!queue.isEmpty()){
			int current = queue.poll();

			for(int link : G.get(current)){
				if(!visit[link]){
					queue.offer(link);
					visit[link] = true;
					graph[start][link] = 1;
				}
			}
		}
	}
}
