package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.DP;

class 스티커모으기2 {
	public static void main(String[] args) {
		int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
		System.out.println(solution(sticker));
	}
	static public int solution(int sticker[]) {
		int answer = 0;
		int N = sticker.length;
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];

		if(N==1) return sticker[0];

		//첫번째 스티커를 사용한 경우
		dp1[0] = sticker[0];
		dp1[1] = sticker[0];
		for(int i=2;i<N-1;i++){
			dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
		}

		//첫번째 스티커를 사용하지 않은 경우
		dp2[0] = 0;
		dp2[1] = sticker[1];
		answer = Math.max(sticker[1],answer);
		for(int i=2;i<N;i++){
			dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
		}

		answer = Math.max(dp1[N-2],dp2[N-1]);

		return answer;
	}
}