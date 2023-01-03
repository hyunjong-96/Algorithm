package org.algorithm.java.hyunjong.Algorithm.BOJ.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[M+1];
		check[0] = check[1] = true;

		for(int i=2;i<=Math.sqrt(M);i++){
			if(check[i]) continue;
			for(int j=i*i;j<=M;j+=i){
				check[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=N;i<=M;i++){
			if(!check[i]) sb.append(i).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
