package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weathers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			weathers[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int start=0;
		int end=0;
		for(end=0;end<K;end++){
			sum += weathers[end];
		}

		int max = sum;
		for(end=K;end<N;end++){
			sum += weathers[end];
			sum -= weathers[start++];
			max = Math.max(max,sum);
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
