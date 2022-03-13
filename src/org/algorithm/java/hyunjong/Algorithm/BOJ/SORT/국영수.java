package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.util.Arrays;
import java.util.Scanner;

public class 국영수 {
	static class Score implements Comparable<Score> {
		int kor;
		int math;
		int eng;
		String name;

		public Score(int kor, int math, int eng, String name) {
			this.kor = kor;
			this.math = math;
			this.eng = eng;
			this.name = name;
		}

		@Override
		public int compareTo(Score o) {
			if (this.kor != o.kor) {
				if (this.kor > o.kor)
					return -1;
				else
					return 1;
			} else if (this.eng != o.eng) {
				if (this.eng < o.eng)
					return -1;
				else
					return 1;
			} else if (this.math != o.math) {
				if (this.math > o.math)
					return -1;
				else
					return 1;
			} else {
				char[] thisArray = this.name.toCharArray();
				char[] oArray = o.name.toCharArray();

				for (int i = 0; i < Math.max(thisArray.length, oArray.length); i++) {
					if (thisArray[i] < oArray[i])
						return -1;
					if (thisArray[i] > oArray[i])
						return 1;
				}

				if (thisArray.length > oArray.length) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Score[] array = new Score[N];
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();

			array[i] = new Score(kor, math, eng, name);
		}
		Arrays.sort(array);

		for(Score score : array){
			System.out.println(score.name);
		}
	}
}
