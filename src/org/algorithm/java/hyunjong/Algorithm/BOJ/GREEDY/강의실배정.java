package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] T = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			T[i] = new int[] {s, t};
		}

		Arrays.sort(T, (o1, o2)->{
			if(o1[0]==o2[0]){
				return o1[1]-o2[1];
			}else{
				return o1[0]-o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(T[0][1]);

		for(int i=1;i<N;i++){
			if(pq.peek() <= T[i][0]){
				pq.poll();
			}
			pq.offer(T[i][1]);
		}

		bw.write(String.valueOf(pq.size()));
		bw.flush();
		bw.close();
	}
}
