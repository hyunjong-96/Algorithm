package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
각 부등호에 맞는 0-9까지의 숫자를 넣어서 최대값과 최소값을 반환하는 문제
최대값을 구하기 위해서는 9에서부터 값을 넣어 각 부등호에 맞는 값인지 비교하여 만족하지 못한다면 백트래킹을 통해 다음 작은 수를 넣어서 부등호 조건에 만족하는 수를 넣어준다.
	이때 부등호를 찾기 위한 index가 마지막 index를 넘어가게되면 모든 부등호의 조건을 만족하는 자연수를 찾은것이기 때문에 해당 숫자가 최대값이 된다.
최소값을 구하기 위해서는 최대값과 반대로 0에서부터 값을 넣어 부등호 조건을 만족하는 수를 넣어주고 최대값을 구하는 것과 마찬가지의 코드에 숫자만 오름차순으로 추가하며 백트래킹을 해준다.
 */
public class 부등호 {
	static String max;
	static String min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		char[] sign = new char[K];
		for (int i = 0; i < K; i++) {
			sign[i] = st.nextToken().charAt(0);
		}

		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[10];
		max = "";
		for (int i = 9; i > 0; i--) {
			check[i] = true;
			if (checkMax(check, sign, String.valueOf(i), i, 0))
				break;
			check[i] = false;
		}
		sb.append(max);
		sb.append("\n");

		check = new boolean[10];
		min = "";
		for (int i = 0; i < 10; i++) {
			check[i] = true;
			if (checkMin(check, sign, String.valueOf(i), i, 0))
				break;
			check[i] = false;
		}
		sb.append(min);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean checkMin(boolean[] check, char[] sign, String number, int prevNum, int index) {
		if (index == sign.length) {
			min = number;
			return true;
		}

		if (sign[index] == '>') {
			for (int i = 0; i < 10; i++) {
				if (!check[i] && prevNum > i) {
					check[i] = true;
					if (checkMin(check, sign, number + i, i, index + 1))
						return true;
					check[i] = false;
				}
			}
		} else {
			for (int i = 0; i < 10; i++) {
				if (!check[i] && prevNum < i) {
					check[i] = true;
					if (checkMin(check, sign, number + i, i, index + 1))
						return true;
					check[i] = false;
				}
			}
		}

		return false;
	}

	static boolean checkMax(boolean[] check, char[] sign, String number, int prevNum, int index) {
		if (index == sign.length) {
			max = number;
			return true;
		}

		if (sign[index] == '>') {
			for (int i = 9; i >= 0; i--) {
				if (!check[i] && prevNum > i) {
					check[i] = true;
					if (checkMax(check, sign, number + i, i, index + 1))
						return true;
					check[i] = false;
				}
			}
		} else {
			for (int i = 9; i >= 0; i--) {
				if (!check[i] && prevNum < i) {
					check[i] = true;
					if (checkMax(check, sign, number + i, i, index + 1))
						return true;
					check[i] = false;
				}
			}
		}

		return false;
	}
}
