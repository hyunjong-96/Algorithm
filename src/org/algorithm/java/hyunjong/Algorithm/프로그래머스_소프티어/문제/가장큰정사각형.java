package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

public class 가장큰정사각형 {
	public static void main(String[] args) {
		// int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] board = {{1,1,0},{1,0,1},{0,1,1}};
		System.out.println(solution(board));
	}

	static int W;
	static int H;
	static int[] dy = {-1,-1,0};
	static int[] dx = {0,-1,-1};

	static public int solution(int[][] board){
		H = board.length;
		W = board[0].length;

		int[][] dp = new int[H+1][W+1];

		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				if(board[i][j]==1){
					setDp(board, dp, i,j);
				}
			}
		}

		int answer = 0;
		for(int i=1;i<H+1;i++){
			for(int j=1;j<W+1;j++){
				answer = Math.max(answer, dp[i][j]);
			}
		}
		return (int)(Math.pow(answer,2));
	}

	static public void setDp(int[][] board, int[][]dp, int y, int x){
		int min = Integer.MAX_VALUE;
		for(int d=0;d<3;d++){
			int ny = y+dy[d];
			int nx = x+dx[d];
			min = Math.min(min, dp[ny+1][nx+1]);
		}
		dp[y+1][x+1] = min+1;
	}
}
