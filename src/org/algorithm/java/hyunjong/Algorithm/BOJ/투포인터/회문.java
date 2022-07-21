package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
투포인터를 이용해서 s.charAt(start) != s.charAt(end) 인 경우 s.charAt(start+1), s.charAt(end) 비교와 s.charAt(start), s.charAt(end-1)비교 ,
총 두가지 경우(start+1경우와 end-1인 경우)로 유사 팰린드롬을 구하고 유사 팰린드롬일때 두 문자가 다르다면 팰린드롬이 아닌 문자열이 되게 되므로 2를 반환한다.
두 경우를 비교한 재귀가 반환되었을 때, 최소값을 반환해준다.(한쪽에서 팰린드롬이 아니다라는 결과가 나왔지만 다른 쪽에서 유사 팰린드롬이다 라는 결과가 나오면 유사 팰린드롬이다)
O(T*N)의 시간복잡도를 가진다고 예상된다.
 */
public class 회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String s = br.readLine();

			int start = 0;
			int end = s.length() - 1;
			int result = checkPalindrom(s, 0, start, end);

			sb.append(result);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int checkPalindrom(String s, int result, int start, int end) {
		if(start>=end) return result;
		if (result == 2)
			return 2;

		if (s.charAt(start) != s.charAt(end)) {
			result = Math.min(checkPalindrom(s, result + 1, start + 1, end), checkPalindrom(s, result + 1, start, end - 1));
		} else {
			result = checkPalindrom(s, result, start + 1, end - 1);
		}
		return result;
	}
}
