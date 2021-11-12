package org.algorithm.java.hyunjong.Algorithm.시저암호;

public class 시저암호 {
	public String solution(String s, int n) {
		StringBuilder answer = new StringBuilder();
		char[] charArray = s.toCharArray();

		for (char c : charArray) {
			if (c >= 'a' && c <= 'z') {
				if (c + n > 'z')
					answer.append((char)(c - 26 + n));
				else
					answer.append((char)(c + n));
			} else if (c >= 'A' && c <= 'Z') {
				if (c + n > 'Z')
					answer.append((char)(c - 26 + n));
				else
					answer.append((char)(c + n));
			} else if (c == ' ') {
				answer.append(c);
			}
		}

		return answer.toString();
	}
}
