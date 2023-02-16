package org.algorithm.java.hyunjong.Algorithm.BOJ.수학;

import java.io.*;
public class 소인수분해{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=(int)Math.sqrt(N);i++){
			while(N%i==0){
				sb.append(i).append("\n");
				N/=i;
			}
		}

		if(N!=1){
			sb.append(N);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
