package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;

public class 계단오르기_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		int[] stairNext = new int[N + 1];
		int[] stairJump = new int[N + 1];
		stairNext[N-1] = stairs[N - 1];
		stairJump[N-1] = stairs[N - 1];

		if(N>=2){
			stairNext[N-2] = stairs[N-2]+stairs[N-1];
		}
		for (int i = N - 3; i >= 0; i--) {
			stairNext[i] = stairs[i] + stairJump[i + 1];
			stairJump[i] = stairs[i] + Math.max(stairNext[i + 2], stairJump[i + 2]);
		}

		int startWithFirst = Math.max(stairNext[0],stairJump[0]);
		int startWithOutFirst = Math.max(stairNext[1],stairJump[1]);
		int result = Math.max(startWithFirst, startWithOutFirst);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
