package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
누적함을 이용해서 연속되는 수의 합이 n이 될때 count를 해준다.
이 때 end가 마지막 숫자를 가리킬때 prefixSum <= n으로 조건을 걸고 prefixSum == n일때 count해주고 end를 증가시키면 아웃바운드 발생
end가 마지막 숫자를 가리키고 있을 때 더 이상 end는 움직일 필요가 없기 때문에 prefixSum == n조건을 반대 조건 (prefixSum >= n)에서 실행시켜준다.
 */
public class 숫자의표현 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	static int solution(int n){
		int[] numbers = new int[n];
		for(int i=0;i<n;i++){
			numbers[i] = i+1;
		}

		int start=0;
		int end=0;
		int answer = 0;
		int prefixSum = 0;
		while(start<=end && start<n){
			if(prefixSum < n){
				prefixSum += numbers[end++];
			}else {
				if(prefixSum == n) answer++;
				prefixSum -= numbers[start++];
			}
		}
		return answer;
	}
}
