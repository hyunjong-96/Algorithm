package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Arrays;

/*
두 배열에 있는 값을 곱하여 누적합이 최소가 되도록해야한다.
누적합이 최소가 되기 위해서는 한 배열에서의 가장 작은 값과 다른 배열에서의 가장 큰값과 곱하여 누적을 구해주어야한다.
 */
public class 최솟값만들기 {
	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		System.out.println(solution(A,B));
	}

	static int answer;
	static int solution(int[] A, int[] B){
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		for(int i=0;i<A.length;i++){
			int j = B.length-1-i;
			answer += A[i]*B[j];
		}

		return answer;
	}
}
