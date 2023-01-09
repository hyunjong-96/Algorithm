package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원 {
	static int N;
	static int K;
	static int[] students;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		students = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			students[i] = Integer.parseInt(st.nextToken());
		}

		int[] arr = new int[N-1];
		for(int i=0;i<N-1;i++){
			arr[i] = students[i+1]-students[i];
		}
		Arrays.sort(arr);
		int result = 0;
		for(int i=0;i<N-K;i++){
			result += arr[i];
		}


		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
