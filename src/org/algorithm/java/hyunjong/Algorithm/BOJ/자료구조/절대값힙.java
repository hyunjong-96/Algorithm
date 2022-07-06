package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절대값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				int result = Math.abs(o1) - Math.abs(o2);
				if(result == 0){
					return o1 - o2;
				}
				return result;
			}
		});
		StringBuilder sb = new StringBuilder();
		while(N-- > 0){
			int num = Integer.parseInt(br.readLine());

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
