package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 센서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensor = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor);

		Integer[] diff = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = sensor[i + 1] - sensor[i];
		}

		Arrays.sort(diff, Collections.reverseOrder());

		int answer=0;
		for(int i=K-1;i<N-1;i++){
			answer += diff[i];
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
