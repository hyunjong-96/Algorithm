package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.Arrays;
public class 수고르기{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;

		for(int i=0;i<N;i++){
			int start = i;
			int end = N-1;

			while(start<N){
				int mid = (start+end)/2;

				if(start == end){
					min = Math.min(min, arr[mid]-arr[i]);
					break;
				}
				else if(arr[mid]-arr[i] < M){
					start = mid+1;
				}
				else{
					end = mid;
				}
			}
		}

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}
}
