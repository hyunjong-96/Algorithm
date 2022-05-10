package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] sNumbers = br.readLine().split(" ");
		int[] number = new int[N+1];
		int sum=0;
		for(int i=1;i<=N;i++){
			sum += Integer.parseInt(sNumbers[i-1]);
			number[i] = sum;
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(number[e]-number[s-1]);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
