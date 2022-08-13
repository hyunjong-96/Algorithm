package org.algorithm.java.hyunjong.Algorithm.codility;

public class tieRope {
	public static void main(String[] args) {
		int K = 1;
		int[] A = {1,2};
		System.out.println(solution(K,A));
	}

	static int solution(int K, int[] A){
		int answer = 0;
		int sum = 0;

		for(int r : A){
			sum += r;

			if(sum>=K){
				sum=0;
				answer++;
			}
		}

		return answer;
	}
}
