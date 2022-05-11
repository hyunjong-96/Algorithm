package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int aPoint = 0;
		int bPoint = 0;

		while (aPoint < A.length && bPoint < B.length) {
			if(A[aPoint] <= B[bPoint]){
				sb.append(A[aPoint]).append(" ");
				aPoint++;
			}else{
				sb.append(B[bPoint]).append(" ");
				bPoint++;
			}
		}
		if(aPoint<A.length){
			while(aPoint<A.length){
				sb.append(A[aPoint]).append(" ");
				aPoint++;
			}
		}
		if(bPoint<B.length){
			while(bPoint<B.length){
				sb.append(B[bPoint]).append(" ");
				bPoint++;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
