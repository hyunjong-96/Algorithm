package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			A[i] = a;
			B[i] = b;
			C[i] = c;
			D[i] = d;
		}

		int[] AB = new int[N * N];
		int[] CD = new int[N * N];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				idx++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		long answer = 0;

		int start = 0;
		int end = CD.length - 1;

		while(start<AB.length && end>=0){
			long sum = AB[start] + CD[end];

			if(sum==0){
				int startCount=0;
				int startIdx=start;
				while(start<AB.length && AB[start] == AB[startIdx]){
					startCount++;
					start++;
				}

				int endCount=0;
				int endIdx = end;
				while(end>=0 && CD[end] == CD[endIdx]){
					endCount++;
					end--;
				}

				answer += (long)startCount*(long)endCount;
			}else{
				if(sum < 0){
					start++;
				}else{
					end--;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
