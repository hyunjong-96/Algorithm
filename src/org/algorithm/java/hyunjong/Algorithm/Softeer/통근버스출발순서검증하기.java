package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;


public class 통근버스출발순서검증하기 {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] bus = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
			bus[i] = Integer.parseInt(st.nextToken());
		}

		int[][] arr = new int[N+1][N+1];
		// for(int x=1;x<N+1;x++){
		// 	for(int j=N-1;j>0;j--){
		// 		if(bus[j+1]<bus[x]) arr[x][j] = arr[x][j+1]+1;
		// 		else arr[x][j] = arr[x][j+1];
		// 	}
		// }
		//
		// int answer = 0;
		// for(int i=1;i<N-1;i++){
		// 	for(int j=i+1;j<N;j++){
		// 		if(bus[i]<bus[j]) answer+=arr[i][j];
		// 	}
		// }

		for(int x=1;x<=N;x++){
			arr[x][N]=0;
			arr[x][N-1] = (bus[N] < x) ? 0 : 1;
			for(int j=N-1;j>0;j--){
				if(bus[j+1]<x) arr[x][j] = arr[x][j+1]+1;
				else arr[x][j] = arr[x][j+1];
			}
		}

		long answer = 0;
		for(int i=1;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				if(bus[i]<bus[j]) answer += arr[bus[i]][j];
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}