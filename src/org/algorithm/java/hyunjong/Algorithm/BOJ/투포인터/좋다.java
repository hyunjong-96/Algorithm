package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N = 2000이라 N^2 계산이 가능하다.
그렇기 때문에 arr[i]에서 start=0, end=N-1로 놓고 arr[start]+arr[end] > arr[i] 이면 end--, arr[start]+arr[end] < arr[i] 이면 start++, arr[start]+arr[end] == arr[i]이면 count++;
해주면 된다.

음수, 양수를 포함하기 때문에 양쪽으로 arr[i]을 기준으로 범위를 줄여주면서 계산한다.
 */
public class 좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int count=0;

		for(int i=0;i<N;i++){
			int start=0;
			int end = N-1;
			while(start < end){
				if(start == i) {
					start++;
					continue;
				}
				else if(end == i) {
					end--;
					continue;
				}

				if(arr[start]+arr[end] > arr[i]) end--;
				else if(arr[start]+arr[end] < arr[i]) start++;
				else {
					count++;
					break;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
