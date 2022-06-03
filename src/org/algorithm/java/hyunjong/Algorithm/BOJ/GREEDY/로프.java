package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] loops = new int[N];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			loops[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(loops);

		int count=N;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			int min = loops[i]*count;
			max = Math.max(max,min);
			count--;
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
