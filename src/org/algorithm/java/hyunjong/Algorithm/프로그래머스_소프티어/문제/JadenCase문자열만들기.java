package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
빈 문자열이 연속으로 있을 수 있는데 이를 그대로 포함해서 대소문자를 변경해주어야한다.
split를 쓰다가 이건 아닌것 같아서 각 문자들을 하나씩 비교했다.

각 문자 변경을 편하게 하기 위해서 stringbuilder에 전부 소문자로 변경하여 넣어준다.
맨앞에는 빈칸이 있을수 없기 때문에 무조건 대문자로 변경해준다(숫자여도 상관없음)
그리고 앞에 빈칸이있는 해당 위치 문자를 대문자로 변경해준다.
 */
public class JadenCase문자열만들기 {
	public static void main(String[] args) {
		String s = "3people  unFollowed me ";
		System.out.println(solution(s));
	}

	static String solution(String s) {
		StringBuilder sb = new StringBuilder(s.toLowerCase());

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(i>0 && s.charAt(i-1)==' '){
				sb.setCharAt(i, Character.toUpperCase(c));
			}
		}

		return sb.toString();
	}
}
