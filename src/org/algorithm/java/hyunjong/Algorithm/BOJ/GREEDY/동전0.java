package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
동전문제를 풀때는 보통 그리디를 사용해서 푼다
하지만 동전에서 각 동전이 약수가 아닌 값이 나올경우 가장 큰값부터 나눠서 계산하는 방법으로는 해결되지 않는다.
 */
public class 동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int count=0;
		for (int i = coin.length - 1; i >= 0; i--) {
			if (K == 0) {
				break;
			}
			if (coin[i] <= K) {
				int cal = K / coin[i];
				K -= coin[i] * cal;
				count += cal;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
