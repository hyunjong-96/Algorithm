package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
public class 숨바꼭질3{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Point = Integer.parseInt(st.nextToken());
		int Target = Integer.parseInt(st.nextToken());

		int time = dijkstra(Point, Target);

		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
	}

	static public int dijkstra(int Point, int Target){
		if(Point >= Target) return Point-Target;

		boolean[] check = new boolean[100001];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});

		pq.offer(new int[]{Point, 0});

		while(!pq.isEmpty()){
			int[] current = pq.poll();

			if(check[current[0]]) continue;

			if(current[0] == Target) return current[1];

			check[current[0]] = true;

			if(current[0]+1 < 100001 && !check[current[0]+1]){
				pq.offer(new int[]{current[0]+1, current[1]+1});
			}
			if(current[0]-1 >= 0 && !check[current[0]-1]){
				pq.offer(new int[]{current[0]-1, current[1]+1});
			}
			if(current[0]*2 < 100001 && !check[current[0]*2]){
				pq.offer(new int[]{current[0]*2, current[1]});
			}
		}

		return Target-Point;
	}
}
