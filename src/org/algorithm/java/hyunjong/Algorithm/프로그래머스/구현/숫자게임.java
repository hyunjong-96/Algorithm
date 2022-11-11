package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

import java.util.Arrays;
class 숫자게임 {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		int N = A.length;
		Arrays.sort(A);
		Arrays.sort(B);

		int indexA = 0;
		int indexB = 0;

		while(indexB < N){
			while(indexB < N && A[indexA]>=B[indexB]) indexB++;

			if(indexB<N && A[indexA]<B[indexB]) answer++;

			indexA++;
			indexB++;
		}

		return answer;
	}
}
