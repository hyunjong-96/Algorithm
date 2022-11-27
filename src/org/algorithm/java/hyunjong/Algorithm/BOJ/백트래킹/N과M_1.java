package org.algorithm.java.hyunjong.Algorithm.BOJ.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.StringTokenizer;

public class N과M_1{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<String> seqList = new ArrayList<>();
		getSequence(seqList, new boolean[N+1], M, N, 0, "");
		Collections.sort(seqList);

		StringBuilder sb = new StringBuilder();
		for(String seq : seqList){
			sb.append(seq).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void getSequence(List<String> seqList, boolean[] check, int M, int N, int depth, String seq){
		if(depth == M){
			seqList.add(seq);
			return;
		}

		for(int i=1;i<=N;i++){
			if(check[i]) continue;
			check[i] = true;
			getSequence(seqList, check, M, N, depth+1, seq+String.valueOf(i)+" ");
			check[i] = false;
		}
	}
}
