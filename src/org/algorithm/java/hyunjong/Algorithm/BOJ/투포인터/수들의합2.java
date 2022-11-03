package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;
public class 수들의합2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		int[] sequence = new int[N];
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		long sum = 0;
		int answer = 0;
		while(end < N & sum < M){
			sum += sequence[end++];
		}

		while(true){
			if(sum >= M){
				if(sum==M) answer++;
				sum -= sequence[start++];
			}else{
				if(end >= N) break;
				sum += sequence[end++];
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
