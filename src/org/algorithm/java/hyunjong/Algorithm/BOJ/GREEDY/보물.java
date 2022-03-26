package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
해당 함수에서 최솟값이 나오게 되려면 한 배열에서 큰값과 다른 배열에서 작은값과 곱해줘야한다.
여기서는 양수가 나오기 때문에 B배열을 내림차순으로 정렬하고 A배열을 오름차순으로 정렬한후 각 index의 값들을 곱해줘서 더해주면된다.
B는 정렬하지 말아야한다고 했지만 결과값만 도출하는 것이기 떄문에 B배열을 정렬한들 A배열의 각 값들을 B배열의 값에 맞춰 배열해줬다고 생각할수있기때문.
 */
public class 보물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];

		StringTokenizer a = new StringTokenizer(br.readLine(), " ");
		StringTokenizer b = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(a.nextToken());
			B[i] = Integer.parseInt(b.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		int result=0;
		for (int i = 0; i < N; i++) {
			result += A[i]*B[i];
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
