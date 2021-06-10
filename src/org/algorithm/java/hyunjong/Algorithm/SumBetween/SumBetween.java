package org.algorithm.java.hyunjong.Algorithm.SumBetween;

public class SumBetween {
	public long solution(int a, int b){
		long answer = 0;
		int start = a;
		int end = b;
		if(a>b){
			start = b;
			end = a;
		}
		for(int i = start;i<end+1;i++){
			answer += i;
		}
		return answer;
	}
}
