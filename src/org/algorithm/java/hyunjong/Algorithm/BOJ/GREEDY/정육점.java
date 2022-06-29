package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정육점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Meat[] meats = new Meat[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			meats[i] = new Meat(s, c);
		}

		Arrays.sort(meats);

		int answer = Integer.MAX_VALUE;
		int size = 0;
		int cost = 0;
		boolean isPossible = false;
		for (int i = 0; i < N; i++) {
			Meat currentMeat = meats[i];

			size += currentMeat.s;

			if(i>0 && currentMeat.c == meats[i-1].c){
				cost += currentMeat.c;
			}else{
				cost = currentMeat.c;
			}

			if(size >= M){
				answer = Math.min(answer, cost);
				isPossible = true;
			}
		}

		if(!isPossible) answer = -1;

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static class Meat implements Comparable<Meat> {
		int s;
		int c;

		public Meat(int s, int c) {
			this.s = s;
			this.c = c;
		}

		@Override
		public int compareTo(Meat o1) {
			int result = this.c - o1.c;
			if (result == 0) {
				result = o1.s - this.s;
			}
			return result;
		}
	}
}
