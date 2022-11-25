package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
public class 로또{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int K = Integer.parseInt(st.nextToken());
			if(K==0) break;

			int[] S = new int[K];
			for(int i=0;i<S.length;i++){
				S[i] = Integer.parseInt(st.nextToken());
			}

			List<String> lottoList = new ArrayList<>();
			selectNumber(S, 0, 0, "", lottoList);

			for(String lotto : lottoList){
				sb.append(lotto).append("\n");
			}
			sb.append("\n");
		}


		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void selectNumber(int[] S, int depth, int idx, String lotto, List<String> lottoList){
		if(depth == 6){
			lottoList.add(lotto);
			return;
		}

		for(int i=idx;i<S.length;i++){
			StringBuilder sb = new StringBuilder(lotto);
			sb.append(S[i]).append(" ");
			selectNumber(S, depth+1, i+1, sb.toString(), lottoList);
		}
	}
}
