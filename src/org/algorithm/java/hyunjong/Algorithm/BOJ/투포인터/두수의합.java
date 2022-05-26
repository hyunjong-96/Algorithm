package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());

		Arrays.sort(sequence);
		int start=0;
		int end=N-1;
		int answer=0;
		while(start<end){
			if(sequence[start]+sequence[end] == X){
				if(sequence[start]==sequence[end]){
					int count = end-start+1;
					answer += (count*(count-1))/2;
					break;
				}else{
					int startIdx = start;
					int endIdx = end;
					int startCount=0;
					int endCount=0;
					while(sequence[start]==sequence[startIdx]){
						start++;
						startCount++;
					}
					while(sequence[end]==sequence[endIdx]){
						end--;
						endCount++;
					}
					answer += startCount*endCount;
				}
			}else{
				if(sequence[start]+sequence[end] < X){
					start++;
				}else{
					end--;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
