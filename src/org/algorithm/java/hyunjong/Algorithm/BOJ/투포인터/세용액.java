package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long result = Long.MAX_VALUE;
		int[] answer = new int[3];
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while(left<N && right>0 && left<right){
				if(i == left){
					left++;
					continue;
				}
				if(i == right){
					right--;
					continue;
				}
				long sum = (long)arr[i]+arr[left]+arr[right];
				if(result>Math.abs(sum)){
					result = Math.abs(sum);
					answer[0] = arr[i];
					answer[1] = arr[left];
					answer[2] = arr[right];
				}

				if(sum == 0){
					break;
				}
				if(sum>0) right--;
				if(sum<0) left++;
			}
			if(result == 0) break;
		}

		Arrays.sort(answer);

		StringBuilder sb = new StringBuilder();
		for(int n : answer){
			sb.append(n);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
