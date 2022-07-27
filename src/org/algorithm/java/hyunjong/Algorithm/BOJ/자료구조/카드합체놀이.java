package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크기가 가장 작은 카드 두개의 합을 구해서 다시 PQ에 넣는것을 반복.
//n개의 카드 합이 최소가 되게하기 위해서는 두개 카드의 합을 구할때 최대한 작은 수로 구해야한다.
public class 카드합체놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Long> cards = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			cards.offer(Long.parseLong(st.nextToken()));
		}


		for(int i=0;i<M;i++){
			long sum = cards.poll()+cards.poll();

			cards.offer(sum);
			cards.offer(sum);
		}

		long sum=0;
		for(int i=0;i<N;i++){
			sum += cards.poll();
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
