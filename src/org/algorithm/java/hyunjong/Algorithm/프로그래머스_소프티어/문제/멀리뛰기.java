package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
dp를 통해 풀수 있는 문제.
dp[0]은 한칸만 뛸수 있으니 1, dp[1]은 한칸씩, 두칸에 한번으로 뛸 수 있으니 2로 초기화
그 뒤로 부터 한칸 혹은 두칸씩 이동할 수 있기 때문에, 해당 위치에서 한칸 전 dp[i-1], 두칸 전 dp[i-2]의
경우의 수를 더해서 n까지 더해간다

생각보다 쉬운 문제.
브루트포스로 시도했지만, 2^n의 시간복잡도로 시간초과
 */
public class 멀리뛰기 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static public long solution(int n) {
		long answer = 0L;
		int[] dp = new int[2000];
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<n;i++){
			dp[i] = (dp[i-1]+dp[i-2])%1234567;
		}
		return (long)(dp[n-1]);
	}
}
