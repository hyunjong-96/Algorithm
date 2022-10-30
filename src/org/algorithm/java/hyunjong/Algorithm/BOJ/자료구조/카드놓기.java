package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class 카드놓기{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[N+1];
		for(int i=N;i>0;i--){
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> dq = new ArrayDeque();
		for(int i=1;i<=N;i++){
			int card = cards[i];

			switch(card){
				case 1 :
					dq.offerFirst(i);
					break;
				case 2:
					int tmp = dq.pollFirst();
					dq.offerFirst(i);
					dq.offerFirst(tmp);
					break;
				case 3 :
					dq.offerLast(i);
					break;
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()){
			sb.append(dq.poll()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
