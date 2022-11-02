package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.util.StringTokenizer;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class 암기왕{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			Set<Integer> note1 = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()){
				note1.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()){
				int result = 0;
				if(note1.contains(Integer.parseInt(st.nextToken()))){
					result = 1;
				}
				sb.append(result).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
