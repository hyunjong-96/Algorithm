package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 여행가자 {
	static List<Integer>[] edge;
	static int[] union;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		edge = new List[N+1];
		union = new int[N+1];
		int[] plan = new int[M];

		for(int i=1;i<=N;i++){
			edge[i] = new ArrayList<>();
			union[i] = i;
		}

		for(int i=1;i<=N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for(int j=1;j<=N;j++){
				int n = Integer.parseInt(st.nextToken());

				if(n==1){
					edge[i].add(j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++){
			plan[i] = Integer.parseInt(st.nextToken());
		}

		for(int row=1;row<=N;row++){

			for(int col=0;col<edge[row].size();col++){
				int edgeCity = edge[row].get(col);

				if(find(row) == find(edgeCity)) continue;

				union(row, edgeCity);
			}
		}

		int prevUnion = union[plan[0]];
		boolean flag = true;
		for(int i=1;i<M;i++){
			if(prevUnion != union[plan[i]]){
				flag = false;
				break;
			}
		}

		String answer = flag ? "YES" : "NO";
		bw.write(answer);
		bw.flush();
		bw.close();
	}

	static void union(int city1, int city2){
		city1 = find(city1);
		city2 = find(city2);

		if(city1<city2) union[city2] = city1;
		else union[city1] = city2;
	}
	static int find(int city){
		if(union[city] == city) return city;
		return union[city] = find(union[city]);
	}
}
