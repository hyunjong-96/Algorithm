package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 수들의합2_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// Arrays.sort(arr);

		int start = 0;
		int end = 0;
		int count = 0;
		int sum = 0;
		while(end<N && sum<M){
			sum += arr[end++];
		}

		while(true){
			if(sum<M){
				if(end>=N) break;
				sum += arr[end++];
			}
			else{
				if(sum == M) count++;
				sum -= arr[start++];
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
