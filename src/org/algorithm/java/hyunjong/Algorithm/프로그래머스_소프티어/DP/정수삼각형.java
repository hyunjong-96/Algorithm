package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.DP;

/*
정수삼각형은 문제를 삼각형이라고 생각하지말고 배열로 생각하면 풀이가 보인다.
				7
			3		8
		8		1		0
	2		7		4		4
4		5		2		6		5
라는 문제가 주어졌을때
7
38
810
2744
45265
라는 배열로 생각하면 dp로 풀수있다는 것이 보인다.
예를 들어 2행의 3,8이 가질수 있는 최대값은 1행에서 10과 합한 값이 가질수 있는 최댓값이 되는것이다.
그렇기 떄문에 dp[1][0] = triangle[0][0]+triangle[1][0] = 10, dp[1][1] = triangle[0][0]+triangle[1][1] = 15가 된다.
해당 행열에서 나올수 있는 최댓값을 dp에 저장해두어 다음 triangle[i][j]값을 구할때 사용할수 있게 되는것이다.
dp[i+1][j]값은 i-1행 같은 열의 최댓값과의 합이 저장되어야한다. 이때 2열 이상인 값일때는 1열의 최댓값과 비교한 값이 먼저 dp에 저장되어있기때문에
dp[i+1][j]값은 dp[i+1][j]와 triangle[i+1][j]+dp[i][j] 중 더 큰값을 넣어줘야한다.
그리고 dp[i+1][j+1]값은 이전 행과 비교할 값이 없기때문에 dp[i+1][j+1] = triangle[i+1][j+1]+dp[i][j]을 저장해주면된다.
 */
public class 정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
	}

	static int solution(int[][] triangle_info){
		//triangle을 행 500, 열500의 배열에 초기화
		int[][] triangle = new int[500][500];
		//dp는 0으로 초기화된 500,500 배열
		int[][] dp = new int[500][500];
		for(int i=0;i<triangle_info.length;i++){
			int[] row = triangle_info[i];
			for(int j=0;j<row.length;j++){
				triangle[i][j] = row[j];
			}
		}

		//0부터 triangle.length-2까지 반복
		dp[0][0] = triangle[0][0];
		for(int i=0;i<triangle.length-2;i++){
			for(int j=0;j<i+1;j++){
				dp[i+1][j] = Math.max(dp[i+1][j], triangle[i+1][j]+dp[i][j]);
				dp[i+1][j+1] = triangle[i+1][j+1]+dp[i][j];
			}
		}
		//triangle-1의 행의 값중 가장 큰값 반환
		int answer = 0;
		for(int i=0;i<triangle_info[triangle_info.length-1].length;i++){
			int sum = dp[triangle_info.length-1][i];
			if(answer < sum){
				answer = sum;
			}
		}
		return answer;
	}
}
