package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/*
N개의 카드를 K개를 선택할때 중복을 허용하지않는 순열이된다.
백트래킹을 통해 선택된 카드를 제외하고 모든 카드를 선택가능한다.
카드의 중복을 제외하기 위해 Set을 사용한다.
 */
public class 카드놓기 {
	static int answer;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		for(int i=0;i<N;i++){
			cards[i] = Integer.parseInt(br.readLine());
		}

		answer=0;
		set = new HashSet<>();
		setCard(cards, new int[N], new boolean[N], 0, K);

		bw.write(String.valueOf(set.size()));
		bw.flush();
		bw.close();
	}

	static void setCard(int[] cards, int[] choice, boolean[] visit, int depth, int K){
		if(depth == K){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<choice.length;i++){
				sb.append(choice[i]);
			}

			set.add(sb.toString());
		}

		for(int i=0;i<cards.length;i++){
			if(!visit[i]){
				visit[i] = true;
				choice[depth] =  cards[i];
				setCard(cards, choice, visit, depth+1, K);
				choice[depth] = 0;
				visit[i] = false;
			}
		}
	}
}
