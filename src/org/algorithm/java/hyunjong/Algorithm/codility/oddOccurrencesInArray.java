package org.algorithm.java.hyunjong.Algorithm.codility;

import java.util.Arrays;

public class oddOccurrencesInArray {
	public static void main(String[] args) {
		int [] A = {8,3,8,3,8,9,8};
		System.out.println(solution(A));
	}

	static int solution(int[] A){
		Arrays.sort(A);

		int answer = 0;
		for(int i=0;i<A.length;i+=2){
			if(i+1 == A.length){
				answer = A[i];
				break;
			}else if(A[i] != A[i+1]){
				answer = A[i];
				break;
			}
		}

		return answer;
	}
}
