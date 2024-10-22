package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.util.Set;
import java.util.HashSet;

class 둘만의암호 {

	public String solution(String s, String skip, int index) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < skip.length(); i++) {
			set.add(skip.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			int count = 0;
			int idx = (c - 'a' + 1) % 26;
			while (true) {
				char currentChar = (char)('a' + idx);
				if (!set.contains(currentChar)) {
					count++;
					if (count == index) {
						sb.append(currentChar);
						break;
					}
				}
				idx = (idx + 1) % 26;
			}
		}

		return sb.toString();
	}
}