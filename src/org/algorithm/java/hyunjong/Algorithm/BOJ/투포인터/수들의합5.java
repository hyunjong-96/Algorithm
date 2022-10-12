package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] seq = new int[N];
		int num = 1;
		for (int i = 0; i < N; i++) {
			seq[i] = num++;
		}

		int sum = 1;
		int start = 0;
		int end = 0;
		int answer = 0;
		while (start<N){
			if(sum<N){
				end++;
				sum += seq[end];
			}else{
				if(sum==N){
					answer++;
				}
				sum -= seq[start];
				start++;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
