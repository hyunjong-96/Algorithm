package org.algorithm.java.hyunjong.Algorithm.BOJ.유니온파인드;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
public class 연결요소의개수{
	static boolean[] check;
	static List<Integer>[] edges;
	static int[] union;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		check = new boolean[N+1];
		union = new int[N+1];
		edges = new List[N+1];

		for(int i=1;i<=N;i++){
			union[i] = i;
			edges[i] = new ArrayList<>();
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			edges[u].add(v);
			edges[v].add(u);
		}

		for(int i=1;i<=N;i++){
			if(check[i]) continue;
			check[i] = true;
			findEdge(i);
		}

		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=N;i++){
			set.add(union[i]);
		}

		bw.write(String.valueOf(set.size()));
		bw.flush();
		bw.close();
	}

	static void findEdge(int current){

		for(int link : edges[current]){
			if(check[link]) continue;
			check[link] = true;
			union(current, link);
			findEdge(link);
		}
	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a<b) union[b] = a;
		else union[a] = b;
	}

	static int find(int a){
		if(union[a] == a) return a;

		return union[a] = find(union[a]);
	}
}


