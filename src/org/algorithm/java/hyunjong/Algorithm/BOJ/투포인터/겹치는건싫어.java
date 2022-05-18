package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 겹치는건싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		int answer = 0;
		int start = 0;
		int end = 0;
		while (end < sequence.length) {
			if (map.containsKey(sequence[end])) {
				if (map.get(sequence[end]) == K) {
					while (map.get(sequence[end]) >= K) {
						map.put(sequence[start], map.get(sequence[start])-1);
						start++;
					}
				}
				map.put(sequence[end],map.get(sequence[end])+1);
			} else {
				map.put(sequence[end],1);
			}

			answer = Math.max(answer, end-start+1);
			end++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
