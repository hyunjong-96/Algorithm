package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N이 최대 1억이기 때문에 최대 8자리 내에서 결과가 나온다. K는 최대 3이므로 O(3^8)가 나오게 되므로 브루트포스가 가능하다.
K로 만들수 있는 수는 최대 N자리수, 최소 N-1자리수 내에서 결과가 나온다.
그렇기 때문에 N과 N-1의 크기에서 K의 수로 만든 수 중 N보다 같거나 작으면서 그 중 최대값을 반환하면 된다.
 */
public class 큰수구성하기 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String n = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(n);
		int size = n.length();

		int[] arrK = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			arrK[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrK);

		answer = 0;
		setNum(N, arrK, new int[size], 0, size);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setNum(int N, int[] arrK, int[] temp, int depth, int limit) {
		if (limit == depth) {
			int result = convertToInt(temp);
			if (N >= result) {
				answer = Math.max(answer, result);
			}
			return;
		}

		for (int i = arrK.length-1; i >= 0; i--) {
			if (depth == limit - 1) {
				int result = convertToInt(temp);
				answer = Math.max(answer, result);
			}
			temp[depth] = arrK[i];
			setNum(N, arrK, temp, depth + 1, limit);
			temp[depth] = 0;
		}
	}

	static int convertToInt(int[] temp) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] != 0) sb.append(temp[i]);
		}

		return Integer.parseInt(sb.toString());
	}
}
