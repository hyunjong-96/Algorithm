package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> S = new HashSet<>();
		for(int i=0;i<N;i++){
			String s = br.readLine();
			S.add(s);
		}

		int count=0;
		for(int i=0;i<M;i++){
			String s = br.readLine();
			if(S.contains(s)){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
