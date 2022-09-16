package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 트리의부모찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer>[] relation = new List[N+1];
		int[] parents = new int[N+1];

		for(int i=0;i<=N;i++){
			relation[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++){
			String[] r = br.readLine().split(" ");
			int n1 = Integer.parseInt(r[0]);
			int n2 = Integer.parseInt(r[1]);

			relation[n1].add(n2);
			relation[n2].add(n1);
		}

		parents[1]=1;

		dfs(parents, relation, 1);

		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++){
			sb.append(parents[i]);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dfs(int[] parents, List<Integer>[] relation, int node){
		for(int child : relation[node]){
			if(parents[child] == 0){
				parents[child] = node;
				dfs(parents, relation, child);
			}
		}
	}
}
