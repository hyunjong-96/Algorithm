package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
팰린드롬은 양방의 문자가 동일한 문자열을 말하는 것이다.
주어진 문자열이 짝수일때는 0부터 절반, 절반부터 끝까지로 두부분을 나눈후 한쪽을 reverse하여 비교한다.
홀수일때는 가운데 문자를 제외하고 왼쪽과 오른쪽 문자열을 한쪽 reverse후 비교한다.
S가 최대 50이기 때문에 주어진 문자열을 하나씩 제외하면서 팰린드롬여부를 확인하고
현재 문자열이 팰린드롬이 아니라면 맨 앞 문자를 제외하고 팰린드롬 여부를 판별하기 위해 재귀를 돌린다.
현재 문자열이 팰린드롬이면 전체 문자열에서 팰린드롬의 길이 만큼 뺀다면 그 값이 팰린드롬을 만족하지 않는 문자의 개수이다.
이 때 자른 문자열의 길이가 1이라면 더이상 비교할수 없기 때문에 1을 반환한다.
	'주어진 문자열 길이 - 1'만큼이 추가해야할 문자의 개수이기 때문이 이것이 팰린드롬을 만들기 위한 최대 추가 문자 개수가된다.
그러므로 주어진 문자열에서 위의 결과값을 더하면 최소의 팰린드롬 길이가 된다.
 */
public class 팰린드롬만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		int palindromSize = check(S);
		int answer = 2*S.length()-palindromSize;

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int check(String s) {
		if (s.length() == 1)
			return 1;

		int mid = s.length() / 2;
		String leftS = "";
		String rightS = "";

		if (s.length() % 2 == 0) {
			leftS = s.substring(0, mid);
			rightS = s.substring(mid);

		} else {
			leftS = s.substring(0, mid);
			rightS = s.substring(mid + 1);
		}
		if (isPalindrom(leftS, rightS))
			return s.length();
		else
			return check(s.substring(1));
	}

	static boolean isPalindrom(String s1, String s2) {
		StringBuilder sb = new StringBuilder(s1);
		sb.reverse();
		return sb.toString().equals(s2);
	}
}
