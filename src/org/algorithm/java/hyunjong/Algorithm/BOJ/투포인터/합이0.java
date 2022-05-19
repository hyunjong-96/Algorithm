package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] alp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			alp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(alp);

		int answer=0;
		for(int i=0;i<N-2;i++){
			int start=i+1;
			int end=N-1;
			while(start<end){
				int sum = alp[start]+alp[end];
				int target = -alp[i];
				if(sum == target){
					if(alp[start]==alp[end]){
						answer += combination(end-start+1);
						break;
					}else{
						int startCount=0;
						int endCount=0;
						int startIdx = start;
						int endIdx = end;
						while(alp[startIdx]==alp[start]){
							startCount++;
							start++;
						}
						while(alp[endIdx]==alp[end]){
							endCount++;
							end--;
						}
						answer += startCount*endCount;
					}
				}else{
					if(sum>target) end--;
					else start++;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int combination(int n){
		return n*(n-1)/2;
	}
}
