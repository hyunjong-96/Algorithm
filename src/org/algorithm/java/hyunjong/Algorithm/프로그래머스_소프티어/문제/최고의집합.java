package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Arrays;

/*
n개의 집합이 s를 만족하면서 집합의 곱이 최대인 집합을 구하는 문제
집합의 곱이 최대가 되기 위해서는 각 요소들이 최대한의 값을 가져야한다.
s/n의 값이 각 요소들이 가지는 최소값이 된다.
그리고 s%n != 0이게 되면 나머지 개수만큼 요소들의 값을 1씩 증가시켜주면된다.
문제를 제대로 이해하지 못했기 때문에 최대값과 최소값만 넣는 실수를 했다.
 */
public class 최고의집합 {
	public static void main(String[] args) {
		int n = 3;
		int s = 10;
		int[] result = solution(n,s);
		for(int r : result){
			System.out.println(r);
		}
	}

	static int[] solution(int n, int s){
		if(n>s) return new int[]{-1};

		int[] answer = new int[n];
		for(int i=0;i<n;i++){
			answer[i] = s/n;
		}

		if(s%n != 0){
			for(int i=0;i<s%n;i++){
				answer[i]++;
			}
		}

		Arrays.sort(answer);

		return answer;
	}
}
