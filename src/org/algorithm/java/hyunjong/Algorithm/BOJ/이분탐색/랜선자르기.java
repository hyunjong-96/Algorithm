package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 랜선자르기 {
	static int K;
	static int N;
	static int[] lens;
	static int minLength = 1;
	static int maxLength = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lens = new int[K];
		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine());
			lens[i] = Integer.parseInt(st.nextToken());
		}

		long answer = findLength();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static long findLength(){
		long start = minLength;
		long end = maxLength;

		while(start<end){
			//임시 길이
			long mid = (start+end+1)/2;

			//임시 길이로 N개 이상의 랜선을 만들수 있는가
			if(lensCount(mid)<N){
				end = mid-1;
			}else{
				start = mid;
			}
		}
		return start;
	}

	static int lensCount(long target){
		int lenCount=0;

		for(int len : lens){
			lenCount += len/target;
		}

		return lenCount;
	}
}
