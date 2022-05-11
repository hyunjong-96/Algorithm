package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum=0;
		for (int i = 0; i < X; i++) {
			sum += arr[i];
		}

		int accumulateUser = sum;
		int count = 1;
		for(int i=X;i<N;i++){
			sum += arr[i];
			sum -= arr[i-X];
			if (sum > accumulateUser) {
				accumulateUser = sum;
				count = 1;
			}else if (sum == accumulateUser)
				count++;
		}
		// int front=1;
		// int end=X;
		// while (end < N) {
		// 	// int acc = accumulateUser + arr[end] - arr[front-1];
		// 	sum += arr[end++];
		// 	sum -= arr[front++ -1];
		// 	if (sum > accumulateUser) {
		// 		accumulateUser = sum;
		// 		count = 1;
		// 	}else if (sum == accumulateUser)
		// 		count++;
		// }


		if (accumulateUser != 0) {
			sb.append(accumulateUser);
			sb.append("\n");
			sb.append(count);
		}else{
			sb.append("SAD");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
