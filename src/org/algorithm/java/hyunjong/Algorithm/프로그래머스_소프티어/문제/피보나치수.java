package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Arrays;

/*
dp를 이용해서 피보나치수를 구한다.
dp를 -1로 초기화 한 다음, dp[0], dp[1]에는 각각 0과 1로 갱신한다.
그런다음 매개변수로 주어지는 값이 dp에 존재하면 저장되어있는 값을 반환하고
없다면 dp[argu-1]+dp[argu-2]를 dp[argu]에 갱신하고 반환해준다.

dp[0]과 dp[1]은 -1이 아닌수로 갱신되어있기 때문에 재귀의 종료 조건을 만족한다.
 */
public class 피보나치수 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(n));
	}

	static int[] dp;
	static int solution(int n){
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		fibo(n);


		return dp[n];
	}

	static int fibo(int argu){
		if(dp[argu] != -1) return dp[argu];

		return dp[argu] = (fibo(argu-1)+fibo(argu-2))%1234567;
	}
}
