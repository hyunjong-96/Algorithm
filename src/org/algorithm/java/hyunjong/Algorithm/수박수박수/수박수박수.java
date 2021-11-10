package org.algorithm.java.hyunjong.Algorithm.수박수박수;

public class 수박수박수 {
	public String solution(int n) {
		StringBuilder s = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if(i%2 == 0) s.append("박");
			else s.append("수");
		}
		return s.toString();
	}
}
