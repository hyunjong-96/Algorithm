package org.algorithm.java.hyunjong.Algorithm.BOJ.해시;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hashing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Mod = 1234567891;
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();

		long sum = 0;
		long pow = 1;
		//거듭제곱 값이 long 범위를 넘지않기 위해 Mod의 나머지로 구해준다.
		for (int i = 0; i < N; i++) {
			sum += (arr[i] - 'a' + 1) * pow;
			pow = (pow * 31) % Mod;
		}
		bw.write(String.valueOf(sum % Mod));
		bw.flush();
		bw.close();
	}
}
