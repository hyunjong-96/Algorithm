package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class 특정거리의도시찾기{
	static int[] distance;
	static int INF = 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<List<Integer>> map = new ArrayList<>();
		distance = new int[N+1];
		for(int i=0;i<=N;i++){
			map.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map.get(A).add(B);
		}

		for(int i=1;i<=N;i++){
			distance[i] = INF;
		}

		dijkstra(map, X);

		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=1;i<=N;i++){
			if(distance[i] == K){
				sb.append(i).append("\n");
				count++;
			}
		}
		if(count==0) sb.append(-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void dijkstra(List<List<Integer>> map, int start){
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			return o1[1] - o2[1];
		});
		boolean[] check = new boolean[map.size()];

		pq.offer(new int[]{start,0});
		check[start] = true;

		while(!pq.isEmpty()){
			int[] current = pq.poll();

			for(int link : map.get(current[0])){
				if(!check[link] && distance[link] > current[1]+1){
					check[link] = true;
					distance[link] = current[1]+1;
					pq.offer(new int[]{link,current[1]+1});
				}
			}
		}
	}
}
