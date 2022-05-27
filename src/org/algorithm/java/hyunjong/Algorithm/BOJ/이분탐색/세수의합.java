package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 세수의합 {
	static int N;
	static int[] U;
	static int[] two;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		U = new int[N];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			U[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(U);
		makeTwo();

		answer = 0;

		for(int k=0;k<N;k++){
			for(int l=0;l<N && l<=k;l++){
				int result = binarySearch(U[k]-U[l]);
				if(result != -1){
					answer = Math.max(answer, U[k]);
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void makeTwo(){
		HashSet<Integer> set = new HashSet<>();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				set.add(U[i]+U[j]);
			}
		}

		two = new int[set.size()];

		int idx=0;
		for(int num : set){
			two[idx++] = num;
		}
		Arrays.sort(two);
	}

	static int binarySearch(int target){
		int start=0;
		int end=two.length-1;

		while(start<=end){
			int mid = (start+end)/2;

			if(two[mid]>target){
				end = mid-1;
			}else if(two[mid]<target){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}
