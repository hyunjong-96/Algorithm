package org.algorithm.java.hyunjong.Algorithm.FindMinority;

public class FindMinority {
	public int solution(int n) {
		int answer = 0;

		int[] minority = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			minority[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (minority[i] == 0)
				continue;

			for (int j = i * 2; j <= n; j += i) {
				minority[j] = 0;
			}
		}

		for (int m : minority) {
			if (m != 0)
				answer++;
		}

		return answer;
	}
}
