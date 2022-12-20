package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

class NQueen {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}
	static int[] queens;
	static int answer;
	static public int solution(int n) {
		queens = new int[n];
		answer = 0;
		setQueen(0,n);
		return answer;
	}

	static void setQueen(int row, int n){
		if(row == n){
			answer++;
			return;
		}

		for(int col=0;col<n;col++){
			queens[row] = col;
			if(check(row)){
				setQueen(row+1, n);
			}
		}
	}

	static boolean check(int row){
		for(int i=0;i<row;i++){
			if(queens[row] == queens[i]) return false;
			if(Math.abs(queens[row]-queens[i]) == Math.abs(row-i)) return false;
		}
		return true;
	}
}
