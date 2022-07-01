package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 괄호의값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String operation = br.readLine();

		Stack<Character> stack = new Stack<>();
		int temp = 0;
		int num = 0;

		if (isCorrect(operation)) {
			operation = operation.replaceAll("\\[\\]", "3");
			operation = operation.replaceAll("\\(\\)", "2");
			for (char c : operation.toCharArray()) {
				if (stack.isEmpty()) {
					if (c == '[' || c == '(') {
						stack.push(c);
						if (c == '[')
							temp += 3;
						if (c == '(')
							temp += 2;
					} else {
						int number = Integer.parseInt(String.valueOf(c));
						num += number;
					}

				} else {
					//열기괄호
					if (c == '[' || c == '(') {
						stack.push(c);

						if (c == '[')
							temp *= 3;
						else
							temp *= 2;
					}
					//닫기 괄호
					else if (c == ']' || c == ')') {
						//']'
						if (c == ']') {
							if (temp / 3 == 1) {
								temp -= 3;
							} else {
								temp /= 3;
							}
						}
						//')'
						else {
							if (temp / 2 == 1) {
								temp -= 2;
							} else {
								temp /= 2;
							}
						}
						stack.pop();
					}
					//숫자
					else {
						int number = Integer.parseInt(String.valueOf(c));
						num += temp * number;
					}
				}
			}
		}

		bw.write(String.valueOf(num));
		bw.flush();
		bw.close();
	}

	static boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || (c == ']' && stack.peek() != '[') || (c == ')' && stack.peek() != '(')) {
					return false;
				}
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}
}
