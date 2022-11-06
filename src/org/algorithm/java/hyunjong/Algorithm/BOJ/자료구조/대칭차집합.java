package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;
public class 대칭차집합{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Set<Integer> A = new HashSet<>();
		for(int i=0;i<N;i++){
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		Set<Integer> B = new HashSet<>();
		for(int i=0;i<M;i++){
			B.add(Integer.parseInt(st.nextToken()));
		}

		int count = 0;
		for(int a : A){
			if(!B.contains(a)){
				count++;
			}
		}
		for(int b : B){
			if(!A.contains(b)){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
