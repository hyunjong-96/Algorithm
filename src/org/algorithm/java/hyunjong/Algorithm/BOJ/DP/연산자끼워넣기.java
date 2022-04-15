package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	static int[] A;
	static int[] C;
	static int N;
	static long min;
	static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		C = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		dfs(A[0], 1);
		sb.append(max);
		sb.append("\n");
		sb.append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dfs(long sum, int index) {
		if (index >= N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		int calIndex = 0;
		while(calIndex<4){
			if(C[calIndex] == 0){
				calIndex++;
				continue;
			}

			C[calIndex]--;
			long result=sum;
			switch (calIndex){
				case 0:
					result += A[index];
					break;
				case 1:
					result -= A[index];
					break;
				case 2:
					result *= A[index];
					break;
				case 3:
					if(sum > 0) result /= A[index];
					else if(sum < 0) result = -(-sum/A[index]);
					else result = 0;
					break;
			}
			dfs(result, index+1);
			C[calIndex]++;
			calIndex++;
		}
	}
}
