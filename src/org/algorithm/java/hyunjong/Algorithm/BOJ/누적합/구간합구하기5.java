package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] numbers = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int sum=0;
			for(int j=1;j<=N;j++){
				sum+=Integer.parseInt(st.nextToken());
				numbers[i][j] = sum;
			}
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum=0;
			for(int j=x1;j<=x2;j++){
				sum += numbers[j][y2]-numbers[j][y1-1];
			}
			sb.append(sum);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}