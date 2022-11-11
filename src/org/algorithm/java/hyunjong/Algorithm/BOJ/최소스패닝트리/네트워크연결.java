package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class 네트워크연결{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<int[]>[] graph = new List[N+1];
		int start = 1001;
		for(int i=1;i<=N;i++){
			graph[i] = new ArrayList<>();
		}

		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==b) continue;
			graph[a].add(new int[]{b,c});
			graph[b].add(new int[]{a,c});

			start = Math.min(start,Math.min(a,b));
		}

		int answer = MST(graph, start);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int MST(List<int[]>[]graph, int start){
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1] - o2[1];
		});
		boolean[] check = new boolean[graph.length];

		pq.offer(new int[]{start,0});

		int totalCost = 0;

		while(!pq.isEmpty()){
			int[] current = pq.poll();
			if(check[current[0]]) continue;
			check[current[0]] = true;
			totalCost += current[1];

			for(int[] link : graph[current[0]]){
				if(check[link[0]]) continue;
				pq.offer(link);
			}
		}

		return totalCost;
	}
}
