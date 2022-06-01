package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
	static int N;
	static int[] sequence;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," " );
		sequence = new int[N];

		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] compareSequence = new int[M];
		for(int i=0;i<M;i++){
			compareSequence[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sequence);
		StringBuilder sb = new StringBuilder();
		for(int compare : compareSequence){
			boolean result = binary_search(compare);

			if(result){
				sb.append("1");
			}else{
				sb.append("0");
			}
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean binary_search(int compare){
		int start=0;
		int end = N-1;

		while(start<=end){
			int mid = (start+end)/2;

			if(sequence[mid] < compare){
				start = mid+1;
			}else if(sequence[mid] > compare){
				end = mid-1;
			}else{
				return true;
			}
		}
		return false;
	}
}
