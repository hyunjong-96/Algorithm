package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(arr[i][j]);
			}
		}

		int answer = 0;
		for(int i=0;i<N;i++){
			answer = pq.poll();
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
