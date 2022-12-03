package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

import java.util.Arrays;

public class 숫자블록 {
	public static void main(String[] args) {
		long begin = 5;
		long end = 10;
		int[] result = solution(begin, end);
		System.out.println(Arrays.toString(result));
	}
	static public int[] solution(long begin, long end) {
		int N = (int)(end-begin+1);
		int[] answer = new int[N];

		int idx=0;
		for(long i=begin;i<=end;i++){
			answer[idx++] = getBlock((int)i);
		}
		return answer;
	}

	static int getBlock(int number){
		if(number == 1) return 0;
		int block = 1;

		for(int i=2;i<=Math.sqrt(number);i++){
			if(number%i == 0 && number/i<=10000000){
				block = number/i;
				break;
			}
		}

		return block;
	}
}
