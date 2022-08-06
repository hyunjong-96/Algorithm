package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

public class problem1_2차 {
	public static void main(String[] args) {
		// int[] number = {-3, -2, -1, 0, 1, 2, 3};
		int[] number = {-1, 1, -1, 1};

		System.out.println(number);
	}

	static public int solution(int[] number) {
		int answer = 0;

		for(int i=0;i<number.length-2;i++){
			for(int j=i+1;j<number.length-1;j++){
				for(int k=j+1;k<number.length;k++){
					if(number[i]+number[j]+number[k] == 0) answer++;
				}
			}
		}
		return answer;
	}
}
