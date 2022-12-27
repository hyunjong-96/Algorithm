package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class 최단경로{
	static int[] cost;
	static int INF = 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<int[]>[] edges = new List[V+1];
		for(int i=1;i<=V;i++){
			edges[i] = new ArrayList<>();
		}

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[u].add(new int[]{v,w});
			// edges[v].add(new int[]{u,w});
		}

		cost = new int[V+1];
		Arrays.fill(cost, INF);
		dijkstra(edges, cost, K);

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++){
			if(i==K){
				sb.append("0");
			}else{
				if(cost[i]==INF){
					sb.append("INF");
				}else{
					sb.append(cost[i]);
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] dijkstra(List<int[]>[] edges, int[] cost, int start){
		boolean[] check = new boolean[edges.length];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			return o1[1]-o2[1];
		});
		pq.offer(new int[]{start,0});

		while(!pq.isEmpty()){
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentCost = current[1];

			if(check[currentNode]) continue;
			check[currentNode] = true;

			for(int[] link : edges[currentNode]){
				int linkNode = link[0];
				int linkCost = link[1];
				if(linkCost+currentCost < cost[linkNode]){
					pq.offer(new int[]{linkNode, linkCost+currentCost});
					cost[linkNode] = linkCost+currentCost;
				}
			}
		}

		return cost;
	}
}

