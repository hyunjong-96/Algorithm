package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;


/*
dp를 이용해서 0행부터 각 열에서 다음 행의 해당 열을 포함하지 않는 열에 값을 비교해서 최대값을 갱신해간다.
 */
public class 땅따먹기 {
	public static void main(String[] args) {
		int[][] land = {{1, 1, 1, 1}, {5, 4, 3, 2}, {4, 5, 2, 1}};
		System.out.println(solution(land));
	}

	static int solution(int[][] land){
		int answer = 0;
		int[][] dp = new int[land.length][4];
		for(int i=0;i<land.length;i++){
			for(int j=0;j<4;j++){
				dp[i][j] = land[i][j];
			}
		}

		for(int i=0;i<land.length-1;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					if(j==k) continue;
					dp[i+1][k] = Math.max(land[i+1][k]+dp[i][j], dp[i+1][k]);
				}
			}
		}

		for(int i=0;i<4;i++){
			answer = Math.max(answer, dp[land.length-1][i]);
		}

		return answer;

	}
}
