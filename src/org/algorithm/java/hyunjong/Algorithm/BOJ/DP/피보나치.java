package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class 피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] f = new long[N + 1];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i < f.length; i++) {
			f[i] = fibo(f, i);
		}
		System.out.println(f[N]%1000000L);
	}

	private static long fibo(long[] f,int index) {
		if (index < 1)
			return 0;
		else if (index == 1)
			return 1;
		else {
			return f[index - 1] + f[index - 2];
		}
	}
}
