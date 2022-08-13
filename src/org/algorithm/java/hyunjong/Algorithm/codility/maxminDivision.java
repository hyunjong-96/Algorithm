package org.algorithm.java.hyunjong.Algorithm.codility;

public class maxminDivision {
	public static void main(String[] args) {
		int K = 2;
		int M = 0;
		int[] A = {0,0};
		System.out.println(solution(K,M,A));
	}

	static public int solution(int K, int M, int[] A) {
		int answer = Integer.MAX_VALUE;
		int start = 0;
		int end = M*A.length;

		while(start<=end){
			int mid = (start+end)/2;

			int sum=0;
			int group =1;
			int max=0;
			for(int i=0;i<A.length;i++){
				if(sum+A[i]>mid){
					max = Math.max(max,sum);
					sum = A[i];
					group++;
				}else{
					sum += A[i];
				}
			}
			max = Math.max(max,sum);

			if(group > K){
				start = mid+1;
			}else{
				answer = Math.min(answer, max);
				end = mid-1;
			}
		}

		return answer;
	}
}
