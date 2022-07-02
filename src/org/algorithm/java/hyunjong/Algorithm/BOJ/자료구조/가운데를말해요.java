package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		//정렬된 배열 중 중간위치의 값 오른편에 있는 값들 오름차순
		PriorityQueue<Integer> min = new PriorityQueue<>();
		//정렬된 배열 중 중간위치를 포함한 왼편에 있는 값들 내림차순
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<N;i++){
			int num = Integer.parseInt(br.readLine());

			if(min.size() == max.size()){
				max.offer(num);
			}else{
				min.offer(num);
			}

			if(!min.isEmpty() && !max.isEmpty() && max.peek() > min.peek()){
				int biggerNum = min.poll();
				min.offer(max.poll());
				max.offer(biggerNum);
			}
			sb.append(max.peek());
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
