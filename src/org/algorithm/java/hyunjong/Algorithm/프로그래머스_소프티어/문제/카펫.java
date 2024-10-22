package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

public class 카펫 {
	public static void main(String[] args) {
		int brown = 8;
		int yellow = 3;
		int[] result = solution(brown, yellow);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	/*
	중앙이 노란색 카펫, 테두리 한 줄이 갈색 카펫일때 최대한 정사각형과 가까운 카펫을 만들어야한다.

	노란색 카펫의 세로를 1부터 Math.sqrt(yellow)까지 구한다. (가로가 세로보다 더 크다는 조건이 있기 때문에)
	노란색 카펫의 특정 높이를 구했을때 세로*2 + (가로+2)*2가 테두리 한줄을 이루는 갈색 카펫의 개수가 된다.
	그렇기 때문에 해당 식의 값이 brown과 동일하다면 세로(high)와 가로(weight)를 갱신해준다.

	정사각형과 가까운 카펫 모양이 되야하기 때문에 노란 카펫의 세로가 최대한의 값을 가지면서 조건을 만족하기 위해서
	1부터 yellow의 제곱근 까지 구하면서 갱신한다.

	-완전 탐색-
	 */
	static int[] solution(int brown, int yellow){
		int weight = 0;
		int high = 0;
		for(int h=1;h<=Math.sqrt(yellow);h++){
			if((yellow/h+2)*2+h*2 == brown){
				weight = yellow/h+2;
				high = h+2;
			}
		}
		return new int[]{weight,high};
	}
}
