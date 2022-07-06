package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.*;
public class 최소힙{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		while(N-- > 0){
			long num = Integer.parseInt(br.readLine());

			if(num == 0){
				if(pq.isEmpty()){
					sb.append("0");
				}else{
					sb.append(pq.poll());
				}
				sb.append("\n");
			}else{
				pq.offer(num);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
