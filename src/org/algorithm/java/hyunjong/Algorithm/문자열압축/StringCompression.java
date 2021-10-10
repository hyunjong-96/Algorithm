package org.algorithm.java.hyunjong.Algorithm.문자열압축;

public class StringCompression {
	public int solution(String s) {
		int answer = s.length();

		//문자열 단위
		for (int i = 1; i <= s.length() / 2; i++) {
			int cnt = 1;
			StringBuilder saveString = new StringBuilder();
			String prev = s.substring(0, i);
			String next = "";

			System.out.println("단위 : " + i);
			//문자열 단위만큼 짤라서 비교할 횟수
			for (int j = i; j < s.length(); j += i) {
				if (j + i > s.length()) {
					saveString.append(s.substring(j));
					break;
				}
				next = s.substring(j,j+i);
				if (prev.equals(next)) cnt++;
				else {
					if (cnt > 1)
						saveString.append(cnt).append(prev);
					else
				 		saveString.append(prev);

					prev = next;
					cnt = 1;
				}
				System.out.println("각 단위 string : " + saveString);
			}
			if (cnt > 1)
				saveString.append(cnt).append(prev);
			else
				saveString.append(prev);

			System.out.println("현재 단위 string : " + saveString);
			System.out.println("현재 단위 길이 : " + saveString.length());
			answer = Math.min(saveString.length(), answer);
		}

		return answer;
	}
}
