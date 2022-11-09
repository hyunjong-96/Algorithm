package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.플로이드와샬;

import java.io.*;
import java.util.StringTokenizer;
public class 경로찾기{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N][N];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeGraph(G, N);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(G[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void makeGraph(int[][] G, int N){
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(G[i][k]==1 && G[k][j]==1) G[i][j]=1;
				}
			}
		}
	}
}
