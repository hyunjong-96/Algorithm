package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

public class n진수게임3차 {
	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		System.out.println(solution(n,t,m,p));
	}

	static String solution(int n, int t, int m, int p){
		String numbers;
		StringBuilder numbersBuilder = new StringBuilder();
		numbersBuilder.append("0");
		int num=1;
		while(numbersBuilder.toString().length()<=t*m){
			numbersBuilder.append(conversion(num++,n));
		}
		numbers = numbersBuilder.toString();

		StringBuilder answer = new StringBuilder();

		for(int i=0;i<t;i++){
			answer.append(numbers.charAt(p-1));
			p += m;
		}

		return answer.toString();
	}

	static String conversion(int num, int N){
		StringBuilder sb = new StringBuilder();
		int current = num;

		while(current > 0){
			if(current%N < 10){
				sb.append(current%N);
			}else{
				sb.append((char)(current%N-10+'A'));
			}
			current/=N;
		}
		sb.reverse();
		return sb.toString();
	}
}
