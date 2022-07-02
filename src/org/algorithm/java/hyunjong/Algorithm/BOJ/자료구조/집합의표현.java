package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합의표현 {
	static int[] group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		group = new int[N+1];

		for(int i=0;i<=N;i++){
			group[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");

			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(type == 0){
				union(a, b);
			}else if(type == 1){
				if(isContains(a,b)){
					sb.append("YES");
				}else{
					sb.append("NO");
				}
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean isContains(int a, int b){
		a = find(a);
		b = find(b);

		return a==b;
	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a>b){
			group[a] = b;
		}else{
			group[b] = a;
		}
	}

	static int find(int a){
		if(a == group[a]) return a;
		else return group[a] = find(group[a]);
	}
}
