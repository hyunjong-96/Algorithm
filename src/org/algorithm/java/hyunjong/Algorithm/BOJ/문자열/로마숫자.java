package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
로마숫자를 아라비아 숫자로 변경할때는 I,X,C는 IV,IX,XL,XC,CD,CM 으로도 받을수 있기 떄문에 다음 문자를 비교하고
나머지 로마숫자들은 각 값을 더해서 아라비아 숫자로 변경한다.

변경된 아라비아 숫자는 각 자릿수를 구해서 1000의자리, 100의자리, 10의자리, 1의 자리의 수를 각 배열에 저장한다.
문제에서 반환되는 아라비아숫자의 최대가 4000으로 주어줬기때문에 1000의 자리가 4일때는 MMMCMC, 그 이하일때는 개수만큼 M
	100의 자리는 500을 기준으로 400일때는 CD, 900일때는 CM를 제외하고 (100의자리 개수/5)의 몫만큼 D, 나머지만큼 C를 붙여서 로마숫자를 만든다
	이때 C는 D보다 작은값이므로 D보다 먼저나올수 없기때문에 D먼저 문자열로 붙여주고 C를 붙여준다.
나머지 10의자리, 1의 자리도 동일하게 문자열로 바꿔준다.
 */
public class 로마숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int roma1 = convertToInteger(br.readLine());
		int roma2 = convertToInteger(br.readLine());

		int sum = roma1 + roma2;
		String roma = convertToRoma(sum);

		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		sb.append("\n");
		sb.append(roma);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static String convertToRoma(int n) {
		StringBuilder sb = new StringBuilder();

		int[] numbers = new int[4];
		int div = 1000;
		for (int i = 0; i < 4; i++) {
			int result = n / div;
			int rest = n % div;

			numbers[i] = result;
			n = rest;
			div /= 10;
		}

		if (numbers[0] <= 3000) {
			for (int i = 0; i < numbers[0]; i++) {
				sb.append("M");
			}
		} else if (numbers[0] == 4000)
			sb.append("MMMCMC");

		for (int i = 1; i < 4; i++) {
			setRoma(sb, numbers, i);
		}

		return sb.toString();
	}

	static void setRoma(StringBuilder sb, int[] numbers, int idx) {
		if (numbers[idx] == 4) {
			if (idx == 1) {
				sb.append("CD");
			} else if (idx == 2) {
				sb.append("XL");
			} else if (idx == 3) {
				sb.append("IV");
			}
		} else if (numbers[idx] == 9) {
			if (idx == 1) {
				sb.append("CM");
			} else if (idx == 2) {
				sb.append("XC");
			} else if (idx == 3) {
				sb.append("IX");
			}
		} else {
			int result = numbers[idx] / 5;
			int rest = numbers[idx] % 5;

			for (int i = 0; i < result; i++) {
				if (idx == 1) {
					sb.append("D");
				} else if (idx == 2) {
					sb.append("L");
				} else if (idx == 3) {
					sb.append("V");
				}
			}
			for (int i = 0; i < rest; i++) {
				if (idx == 1) {
					sb.append("C");
				} else if (idx == 2) {
					sb.append("X");
				} else if (idx == 3) {
					sb.append("I");
				}
			}
		}
	}

	static int convertToInteger(String roma) {
		int number = 0;
		for (int i = 0; i < roma.length(); i++) {
			char c = roma.charAt(i);

			if (c == 'I') {
				if (i + 1 < roma.length()) {
					if (roma.charAt(i + 1) == 'V') {
						number += 4;
						i++;
					} else if (roma.charAt(i + 1) == 'X') {
						number += 9;
						i++;
					} else {
						number += 1;
					}
				} else {
					number += 1;
				}
			} else if (c == 'X') {
				if (i + 1 < roma.length()) {
					if (roma.charAt(i + 1) == 'L') {
						number += 40;
						i++;
					} else if (roma.charAt(i + 1) == 'C') {
						number += 90;
						i++;
					} else {
						number += 10;
					}
				} else {
					number += 10;
				}
			} else if (c == 'C') {
				if (i + 1 < roma.length()) {
					if (roma.charAt(i + 1) == 'D') {
						number += 400;
						i++;
					} else if (roma.charAt(i + 1) == 'M') {
						number += 900;
						i++;
					} else {
						number += 100;
					}
				} else {
					number += 100;
				}
			} else if (c == 'V') {
				number += 5;
			} else if (c == 'L') {
				number += 50;
			} else if (c == 'D') {
				number += 500;
			} else if (c == 'M') {
				number += 1000;
			}
		}

		return number;
	}
}
