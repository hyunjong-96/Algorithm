package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;


public class 금고털이
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewerly> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			pq.offer(new Jewerly(M, P));
		}

		int weight = 0;
		int cost = 0;
		while(!pq.isEmpty()){
			Jewerly jewerly = pq.poll();

			if(weight + jewerly.weight > W){
				cost += (W-weight) * jewerly.cost;
				break;
			}

			weight += jewerly.weight;
			cost += jewerly.weight * jewerly.cost;
		}

		bw.write(String.valueOf(cost));
		bw.flush();
		bw.close();
	}

	static class Jewerly implements Comparable<Jewerly>{
		int weight;
		int cost;
		public Jewerly(int weight, int cost){
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public int compareTo(Jewerly o){
			return o.cost-this.cost;
		}
	}
}
