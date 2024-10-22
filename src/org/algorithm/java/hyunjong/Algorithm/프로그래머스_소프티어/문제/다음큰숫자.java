package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
Integer.toBinaryString()을 사용해서 해당 binary의 1의 개수를 구하거나
Integer.bitCount()를 이용해서 1의 개수를 바로 구할 수 있다.
 */
public class 다음큰숫자 {
	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}

	static public int solution(int n) {

		// int compare = numberOfOne(n);
		int compare = Integer.bitCount(n);
		int answer = n+1;
		while(compare != Integer.bitCount(answer)){
			answer++;
		}
		// while(!isCorrect(compare, answer)){
		//     answer++;
		// }
		return answer;
	}

	static public boolean isCorrect(int compare, int num){
		return compare == numberOfOne(num);
	}

	static public int numberOfOne(int num){
		String binary = Integer.toBinaryString(num);

		int count = 0;
		for(int i=0;i<binary.length();i++){
			if(binary.charAt(i)=='1') count++;
		}
		return count;
	}
}
