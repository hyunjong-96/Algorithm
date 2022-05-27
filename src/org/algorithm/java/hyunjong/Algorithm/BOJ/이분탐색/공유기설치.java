package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	static int N;
	static int C;
	static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			houses[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(houses);

		int answer = findDistance();
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int findDistance(){
		int start = 1;
		int end = houses[N-1]-houses[0];
		while(start<end){
			int mid = (start+end+1)/2;
			int prev = houses[0];
			int count = 1;

			for(int i=1;i<N;i++){
				if(houses[i]-prev >= mid){
					count++;
					prev = houses[i];
				}
			}

			if(count<C){
				end = mid-1;
			}else{
				start = mid;
			}
		}

		return start;
	}
}
