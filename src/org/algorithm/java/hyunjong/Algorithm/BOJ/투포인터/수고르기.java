package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] sequence = new int[N];
		for(int i=0;i<N;i++){
			int num = Integer.parseInt(br.readLine());
			sequence[i] = num;
		}
		Arrays.sort(sequence);

		int start=0;
		int end=0;
		int minM=sequence[sequence.length-1]-sequence[0];
		while(start<N && end<N){
			int m = sequence[end]-sequence[start];

			if(m>=M){
				if(m<minM) minM = m;
				start++;
			}else if(m==M){
				minM = m;
			}else{
				end++;
			}
		}

		bw.write(String.valueOf(minM));
		bw.flush();
		bw.close();
	}
}
