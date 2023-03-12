package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 최소힙_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			int req = Integer.parseInt(br.readLine());

			if(req == 0){
				if(pq.isEmpty()){
					sb.append(0);
				}else{
					sb.append(pq.poll());
				}
				sb.append("\n");
			}
			else{
				pq.offer(req);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
