package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class 어머이건꼭풀어야해{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		int[] nums = new int[A+1];
		int[] prefixSum = new int[A+1];
		for(int i=1;i<=A;i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		for(int i=1;i<=A;i++){
			prefixSum[i] = prefixSum[i-1]+nums[i];
		}

		StringBuilder sb = new StringBuilder();
		while(Q-- > 0){
			st = new StringTokenizer(br.readLine()," ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			sb.append(prefixSum[R]-prefixSum[L-1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
