package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

public class 가장긴팰린드롬 {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(solution(s));
	}

	static boolean[][] dp;
	static public int solution(String s)
	{
		int answer = 0;
		dp = new boolean[s.length()][s.length()];

		for(int i=0;i<s.length();i++){
			dp[i][i] = true;
			answer = 1;
		}
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)) dp[i][i+1] = true;
		}

		for(int len = 3;len<=s.length();len++){
			for(int i=0;i+len<=s.length();i++){
				int j = i+len-1;
				if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
					dp[i][j] = true;
					answer = len;
				}
			}
		}

		return answer;
	}
	// static public int solution(String s)
	// {
	// 	int N = s.length();
	// 	int answer = 0;
	// 	for(int start=0;start<N;start++){
	// 		for(int end=N-1;end>=start;end--){
	// 			if(isPallendrom(s, start, end)){
	// 				answer = Math.max(answer, end-start+1);
	// 			}
	// 		}
	// 	}
	//
	// 	return answer;
	// }
	//
	// static private boolean isPallendrom(String s, int start, int end){
	// 	while(start<=end){
	// 		if(s.charAt(start++)!=s.charAt(end--)) return false;
	// 	}
	// 	return true;
	// }
}
