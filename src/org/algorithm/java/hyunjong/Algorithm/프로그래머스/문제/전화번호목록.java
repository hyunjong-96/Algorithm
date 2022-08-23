package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Arrays;
/*
string 타입 숫자를 정렬하게 된다면 int 타입처럼 크기로 정렬되는 것이 아니라, 같은 숫자로 이루어진 문자열 숫자로
순서대로 정렬된다.
예를 들어 1,13451, 134, 22 로 이루어진 문자열 숫자들이 있을때
int형이였다면 1,22,134,13451 로 정렬되었을 것이다.
하지만 문자열을 정렬하면 1,134,13451,22 로 같은 수로 이루어진 숫자로 정렬된다.

그리고 문자열의 앞부분 부터 비교 문자열의 여부를 비교하는 함수 startsWith()을 사용해서
비교하려는 문자열의 앞에서부터 비교하게된다.
 */
public class 전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"119","97674223","1195524421"};
		System.out.println(solution(phone_book));
	}

	static boolean solution(String[] phone_book){
		Arrays.sort(phone_book);

		for(int i=0;i<phone_book.length-1;i++){
			String currentPhone = phone_book[i];
			String nextPhone = phone_book[i+1];

			if(nextPhone.startsWith(currentPhone)) return false;
		}

		return true;
	}
}
