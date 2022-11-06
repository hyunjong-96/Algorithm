package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 소가길을건너간이유1{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] move = new int[N+1];
		Arrays.fill(move, -1);

		int count = 0;
		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int cow = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			if(move[cow] == -1){
				move[cow] = pos;
			}else{
				if(move[cow] != pos){
					count++;
					move[cow] = pos;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
