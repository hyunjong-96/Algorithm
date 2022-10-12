package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
슬라이딩 윈도우를 통해 0부터 (1+2*K)-1까지의 합을 구한다. 이때 K의 최대값은 2000000이기 때문에 (1+2*K)-1까지의 합을 구하되
얼음의 범위인 1000000을 넘지 않도록 조건을 추가해준다.

그리고 end가 1000000까지 슬라이딩 윈도우로 최대값을 구한다면 얼음이 있는 범위에서 최대의 얼음양을 구할수 있다.
 */
public class 게으른백곰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[x] = g;
		}

		int sum = 0;
		for (int i = 0; i < 1 + 2 * K && i < 1000001; i++) {
			sum += map[i];
		}

		int answer = sum;
		for (int end = 1 + 2 * K, start = 0; end < 1000001; end++, start++) {
			sum += map[end];
			sum -= map[start];
			answer = Math.max(answer, sum);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
