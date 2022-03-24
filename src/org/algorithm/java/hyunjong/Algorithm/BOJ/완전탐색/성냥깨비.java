package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
성냥깨비로 만들수 있는 10진수 숫자는 1,2,3,4,5,6,7,8,9,0 이 있다.
주어진 N개의 성냥깨비로 만들수 있는 최대의 수와 최소의 수를 구해야한다.
최대의 수가 되는 조건은 1. 자릿수가 가장 크다, 2. 자릿수가 같을 경우에는 앞자리 가 커야한다.
최대의 수는 N%2==0이면 최소의 성냥깨비 2개가 필요한 1을 최대한 만드는것이고
N%2 == 1이면 3개의 성냥깨비로 만들수 있는 7을 하나 만들게 되면 무조건 N%2==0의 성냥깨비가 남게 되므로 나머지는 1을 만들면된다.

최소의 수는 dp를 이용해서 N개의 성냥깨비로 만들수 있는 최소의 수를 저장해가면서 dp[N]의 값을 찾는게 핵심이다.
2개의 성냥으로는 '1'을, 3개의 성냥으로는 '7'을 5개의 성냥으로는 '2,3,5'를 6개로는 '0,6'...을 만들수 있다.
이때 성냥의 갯수로 만들수 이는 최소의 수를 dp에 저장해야한다 성냥이 5개인 경우에는 '2,3,5'중 2가 가장 작은 수이므로 2를 저장해준다.
성냥이 6개인 경우에 만들수 있는 작은 수는 '0'이지만 첫번째 자리에는 들어갈수 없는 수이기 떄문에 dp[6]에는 6을 저장해주게 된다.
dp[8]은 2개 짜리 '1'과 6개 짜리 '0'이 가장 작은 수이다. dp[9]는 2개 짜리 '1'과 7개 짜리 '8'이 가장 작은수 이다.

만약 6개 짜리가 필요한데 dp[6]에는 6이 저장되어있기 떄문에 6개의 성냥이 필요할때 0을 뽑아줄수있는 배열이 필요하다.
arr = {0,0,1,7,4,2,0,8} 이 배열은 각 index가 필요한 성냥의 갯수이고 각 요소들은 각 자릿값이 만들수 있는 최소의 수가 된다.
그렇다면 정규식은 dp[8] = dp[2] + arr[6]이 되어야하는데 우리가 알아야 하는 것은 합이 아닌 그 숫자가 필요한것이다.
그렇기 떄문에 dp[8] = "" + dp[2] + arr[6]이 되어야한다.
마찬가지로 dp[9] = "" + dp[2] + arr[7]이 된다.
즉, 정규식은 dp[i] = "" + dp[i-j] + arr[j].
 */
public class 성냥깨비 {
	static long[] minDP;
	static int[] arr = {0, 0, 1, 7, 4, 2, 0, 8};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] testcase = new int[T];
		for (int t = 0; t < T; t++) {
			testcase[t] = Integer.parseInt(br.readLine());
		}
		br.close();

		minDP = new long[101];
		Arrays.fill(minDP, Long.MAX_VALUE);
		minDP[2] = 1;
		minDP[3] = 7;
		minDP[4] = 4;
		minDP[5] = 2;
		minDP[6] = 6;
		minDP[7] = 8;
		minDP[8] = 10;

		String max;
		for (int N : testcase) {
			max = max(N);
			min(N);

			sb.append(minDP[N]);
			sb.append(" ");
			sb.append(max);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static String max(int N) {
		StringBuilder sb = new StringBuilder();
		if (N % 2 != 0) {
			while (N % 2 != 0) {
				sb.append(7);
				N -= 3;
			}
		}
		while (N > 0) {
			sb.append(1);
			N -= 2;
		}
		return sb.toString();
	}

	static void min(int N) {
		for (int i = 9; i <= N; i++) {	//dp를 만들 범위
			for (int j = 2; j < 8; j++) {	//arr의 범위
				String s = "" + minDP[i - j] + arr[j];
				minDP[i] = Math.min(minDP[i], Long.parseLong(s));
			}
		}
	}
}
