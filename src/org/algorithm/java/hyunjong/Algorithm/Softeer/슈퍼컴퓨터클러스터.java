package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 슈퍼컴퓨터클러스터 {
	static int N;
	static long B;
	static int[] power;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		power = new int[N];

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			power[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(power);

		long answer = binarySearch();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static long binarySearch() {
		long answer = 0;
		long start = power[0];
		long end = power[N-1]+(long)Math.sqrt(B);

		while (start <= end) {
			long mid = (start + end) / 2;

			boolean isA = isAvailable(mid);

			if (isA){
				start = mid+1;
				answer = mid;
			}
			else
				end = mid-1;
		}
		return answer;
	}

	static boolean isAvailable(long target) {

		long cost = 0;

		for(int i=0;i<N;i++){
			cost += (target-power[i] > 0) ? (long)Math.pow(target-power[i],2) : 0;
			if(cost > B) return false;
		}

		return true;
	}
}
