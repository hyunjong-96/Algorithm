package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

public class 타겟넘버 {
	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;
		System.out.println(solution(numbers, target));
	}

	static int answer = 0;
	static int solution(int[] numbers, int target){
		int sum = 0;

		setNumber(numbers, target, 0, sum);

		return answer;
	}

	static void setNumber(int[] numbers, int target, int idx,  int sum){
		if(idx == numbers.length){
			if(sum == target) answer++;
			return;
		}

		setNumber(numbers, target, idx+1, sum+numbers[idx]);
		setNumber(numbers, target, idx+1, sum-numbers[idx]);
	}
}
