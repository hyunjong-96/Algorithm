package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
public class 서강그라운드{
	static int N;
	static int M;
	static int R;
	static int[] items;
	static List<int[]>[] edges;
	static int[][] dist;
	static int INF = 10000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		items = new int[N+1];
		edges = new List[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
			items[i] = Integer.parseInt(st.nextToken());
			edges[i] = new ArrayList<>();
		}

		for(int i=0;i<R;i++){
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			edges[a].add(new int[]{b,l});
			edges[b].add(new int[]{a,l});
		}

		dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				dist[i][j] = INF;
			}
		}

		for(int i=1;i<=N;i++){
			dijkstra(i);
		}

		int answer = 0;
		for(int i=1;i<=N;i++){
			int maxValue = 0;
			for(int j=1;j<=N;j++){
				if(dist[i][j]<=M) maxValue += items[j];
			}

			answer = Math.max(answer, maxValue);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start){
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});

		dist[start][start] = 0;
		pq.offer(new int[]{start,0});

		while(!pq.isEmpty()){
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentDist = current[1];

			for(int[] link : edges[currentNode]){
				int linkNode = link[0];
				int linkDist = link[1];
				if(dist[start][linkNode] > currentDist+linkDist){
					dist[start][linkNode] = currentDist+linkDist;
					pq.offer(new int[]{linkNode, currentDist+linkDist});
				}
			}
		}
	}
}