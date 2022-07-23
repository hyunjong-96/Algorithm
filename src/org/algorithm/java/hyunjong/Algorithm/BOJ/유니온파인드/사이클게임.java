package org.algorithm.java.hyunjong.Algorithm.BOJ.유니온파인드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 사이클게임 {
	static int[] union;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		union = new int[N];

		for(int i=0;i<N;i++){
			union[i] = i;
		}

		int answer=0;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if(find(from) == find(to)){
				answer = i+1;
				break;
			}else{
				setUnion(from, to);
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setUnion(int p1, int p2){
		p1 = find(p1);
		p2 = find(p2);

		if(p1>p2){
			union[p1] = p2;
		}else{
			union[p2] = p1;
		}
	}

	static int find(int p){
		if(union[p] == p) return p;
		else return union[p] = find(union[p]);
	}
}
