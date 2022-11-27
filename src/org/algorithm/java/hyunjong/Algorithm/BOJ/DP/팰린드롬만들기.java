package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class 팰린드롬만들기{
	static int[][] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(dp[i],-1);
		}
		int min = putSequence(0, N-1);

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	static int putSequence(int left, int right){
		if(left>=right) return 0;

		if(dp[left][right]!=-1)return dp[left][right];

		int min = 0;
		if(arr[left]==arr[right]){
			min = putSequence(left+1, right-1);
		}else{
			min = Math.min(putSequence(left+1,right)+1, putSequence(left,right-1)+1);
		}
		return dp[left][right] = min;
	}
}
