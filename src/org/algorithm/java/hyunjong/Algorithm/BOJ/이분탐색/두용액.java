package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] sequence = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sequence);

		int start=0;
		int end=sequence.length-1;
		int max = 2000000000;
		int a=0;
		int b=0;
		while(start<end){
			int sum = sequence[start]+sequence[end];

			if(Math.abs(sum)<max){
				a = sequence[start];
				b = sequence[end];
				max = Math.abs(sum);
			}

			if(sum < 0){
				start++;
			}else if(sum > 0){
				end--;
			}else{
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(" ");
		sb.append(b);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
