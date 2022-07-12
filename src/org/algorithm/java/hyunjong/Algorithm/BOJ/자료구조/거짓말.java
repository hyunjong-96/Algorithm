package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<Integer> blackList = new HashSet<>();

		st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			blackList.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer>[] party = new List[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<>();

			for (int l = 0; l < L; l++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int m = 0; m < M * M; m++) {
			List<Integer> humans = party[m%M];

			for(int h : humans){
				if(blackList.contains(h)){
					blackList.addAll(humans);
				}
			}
		}

		int count=0;
		for(int m=0;m<M;m++){
			List<Integer> humans = party[m];

			boolean trueStory = false;
			for(int h : humans){
				if(blackList.contains(h)){
					trueStory = true;
				}
			}

			if(!trueStory){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
