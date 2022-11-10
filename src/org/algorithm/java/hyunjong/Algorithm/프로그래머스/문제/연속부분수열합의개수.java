package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Set;
import java.util.HashSet;
class 연속부분수열합의개수 {
	public static void main(String[] args) {

	}
	static public int solution(int[] elements) {

		Set<Integer> sumSet = makeSum(elements);

		return sumSet.size();
	}

	static Set<Integer> makeSum(int[] elements){
		Set<Integer> sumSet = new HashSet<>();
		int N = elements.length;
		for(int i=0;i<N;i++){
			setSum(elements, sumSet,i,N);
		}

		return sumSet;
	}

	static void setSum(int[] elements, Set<Integer> sumSet, int idx, int N){
		int sum = 0;
		for(int i=0;i<N;i++){
			sum += elements[(i+idx)%N];
			sumSet.add(sum);
		}
	}
}
