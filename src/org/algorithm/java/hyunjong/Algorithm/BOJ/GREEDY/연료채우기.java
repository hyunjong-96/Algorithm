package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연료채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Soil[] soils = new Soil[N];
		PriorityQueue<Soil> stations = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// soils[i] = new Soil(a, b);
			stations.add(new Soil(a,b));
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		// Arrays.sort(soils);

		int answer = 0;
		// int position = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(P < L){

			while(!stations.isEmpty() && stations.peek().pos <= P){
				pq.offer(stations.poll().oil);
			}
			// for(int i = position;i<N;i++){
			// 	if(P<soils[i].pos) {
			// 		break;
			// 	}
			// 	pq.offer(soils[i].oil);
			// }
			//
			if(pq.isEmpty()){
				answer = -1;
				break;
			}

			P += pq.poll();
			answer++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static class Soil implements Comparable<Soil> {
		int pos;
		int oil;

		public Soil(int pos, int oil) {
			this.pos = pos;
			this.oil = oil;
		}

		@Override
		public int compareTo(Soil o1) {
			return this.pos-o1.pos;
		}
	}
}
