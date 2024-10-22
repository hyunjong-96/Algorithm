package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.정렬;

public class 풍선터트리기 {
	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		System.out.println(solution(a));
	}

	static int solution(int[] a){
		int N = a.length;

		int[] leftMin = new int[N];
		int[] rightMin = new int[N];

		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			if(min > a[i]){
				min = a[i];
			}
			leftMin[i] = min;
		}

		min = Integer.MAX_VALUE;
		for(int i=N-1;i>=0;i--){
			if(min > a[i]) min = a[i];
			rightMin[i] = min;
		}

		int answer = 2;

		for(int i=1;i<N-1;i++){
			if(a[i-1]>a[i] || a[i]<a[i+1]) {
				answer++;
			}
		}

		return answer;
	}
}
