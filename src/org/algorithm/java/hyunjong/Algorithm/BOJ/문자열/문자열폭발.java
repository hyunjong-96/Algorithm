package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
스택을 이용 문제풀이이다.
문자열 string과 폭발 문자열 regex를 비교해야하는데
문자열을 stack에 넣어주다가 stack의 길이가 폭발 문자열의 길이보다 같거나 크게 되면
해당 폭발 문자열의 길이만큼 문자열의 뒤에서 서로 비교하면서 다른 문자가 있다면 반복문 break(핵심)
문자열이 저장되어있는 스택의 길이가 0이면 FRULA를 반환해주면 된다.
 */
public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String string = br.readLine();
		String regex = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));

			if (stack.size() >= regex.length()) {//문자열을 하나씩 넣는 stack의 크기가 폭발 문자열의 길이보다 크거나 같다.
				boolean flag = true;
				for (int j = 0; j < regex.length(); j++) {
					/*
					폭발 문자열의 크기만큼 문자열의 뒤에서 비교하며 같은 문자가 하나라도 없다면 넘어가면 된다.
					stack의 길이 - 폭발 문자열의 길이만큼 빼고 j의 값인 index가
					문자열의 문자 중 폭발 문자열로 의심하고 비교하는 코드 (핵심)
					 */
					if (stack.get(stack.size() - regex.length() + j) != regex.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < regex.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		for (Character c : stack) {
			sb.append(c);
		}

		if (sb.length() == 0) {
			sb.append("FRULA");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
