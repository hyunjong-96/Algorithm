package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.util.Arrays;
import java.util.Scanner;

public class 나이순정렬 {
	private static class Info implements Comparable<Info> {
		int age;
		String name;
		int createdAt;

		public Info(int age, String name, int createdAt) {
			this.age = age;
			this.name = name;
			this.createdAt = createdAt;
		}

		@Override
		public int compareTo(Info o) {
			if (this.age != o.age) {
				if (this.age < o.age)
					return -1;
				else
					return 1;
			} else {
				if (this.createdAt < o.createdAt)
					return -1;
				else
					return 1;
			}
		}

		public String toString() {
			return this.age + " " + this.name;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Info[] array = new Info[N];

		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();

			array[i] = new Info(age, name, i);
		}

		Arrays.sort(array);

		for (Info info : array) {
			System.out.println(info.toString());
		}
	}
}
