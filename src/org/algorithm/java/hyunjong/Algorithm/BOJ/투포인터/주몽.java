package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] materials = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			materials[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(materials);

		int start=0;
		int end=N-1;
		int answer=0;
		while(start<end){
			int sum = materials[start]+materials[end];
			if(sum==M) answer++;

			if(sum>M){
				end--;
			}else{
				start++;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
