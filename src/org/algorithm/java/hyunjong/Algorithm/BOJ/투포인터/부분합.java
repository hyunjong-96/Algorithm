package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		String[] arr = br.readLine().split(" ");
		int[] sequence = new int[N];
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(arr[i]);
		}

		int start=0;
		int end=0;
		int sum=0;
		int minLen=Integer.MAX_VALUE;
		while(true){
			if(sum>=S){
				sum -= sequence[start++];
				minLen = Math.min(minLen, end-start+1);
			}else if(end>=N){
				break;
			}else{
				sum += sequence[end++];
			}
		}

		if(minLen == Integer.MAX_VALUE) minLen = 0;
		bw.write(String.valueOf(minLen));
		bw.flush();
		bw.close();
	}
}
