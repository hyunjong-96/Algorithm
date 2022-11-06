package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.*;
import java.util.StringTokenizer;

/*
상자의 개수가 최대 10만개, i번째 상자위의 i+1~N개의 평균을 하나하나 구한다면 O(N^2)으로 시간초과

상자를 N-1개부터 비교하며 상자 위의 평균을 O(1)로 구하기 위해 prefixSum으로 i번째 위에 있는 상자의 합을 구한다.
그리고 i번째 상자의 범위를 구하고 prefixSum[i+1]/i번째 상자 위의 상자개수 로 평균을 구하여
i번째 상자 범위에 들어오는지 확인하는 문제
 */
public class 상자의균형{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		int[] point = new int[N];
		long[] prefixSum = new long[N];
		for(int i=0;i<N;i++){
			point[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = point[i];
		}

		for(int i=N-2;i>=0;i--){
			prefixSum[i] += prefixSum[i+1];
		}

		boolean isStable = true;
		int count=1;
		for(int i=N-2;i>=0;i--){
			double avg = (double)prefixSum[i+1]/count++;

			int left = point[i]-L;
			int right = point[i]+L;

			if(left>=avg || right<=avg){
				isStable = false;
				break;
			}
		}

		String answer = isStable ? "stable" : "unstable";
		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
