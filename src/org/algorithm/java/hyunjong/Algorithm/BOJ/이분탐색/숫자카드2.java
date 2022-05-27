package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {
	static int N;
	static int M;
	static int[] arr;
	static int[] arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++){
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for(int num : arr2){
			int startIdx = lowerCase(num);
			int endIdx = upperCase(num);

			sb.append(endIdx-startIdx).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int lowerCase(int num){
		int start=0;
		int end=N;

		while(start<end){
			int mid = (start+end)/2;

			if(arr[mid] >= num){
				end = mid;
			}else{
				start = mid+1;
			}
		}

		return end;
	}

	static int upperCase(int num){
		int start=0;
		int end=N;

		while(start<end){
			int mid = (start+end)/2;

			if(arr[mid]>num){
				end = mid;
			}else{
				start = mid+1;
			}
		}

		return end;
	}
}
