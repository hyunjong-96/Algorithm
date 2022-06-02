package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int start=0;
		int end=N-1;
		int firstResult = 0;
		int lastResult = 0;
		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		while(start<end){
			int sum = sequence[start]+sequence[end];
			int target = Math.abs(sum);

			if(target<min){
				firstResult = sequence[start];
				lastResult = sequence[end];
				min = target;
			}

			if(sum>0){
				end--;
			}else if(sum<0){
				start++;
			}else{
				break;
			}
		}

		sb.append(firstResult);
		sb.append(" ");
		sb.append(lastResult);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
