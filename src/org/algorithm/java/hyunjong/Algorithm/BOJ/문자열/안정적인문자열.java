package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
안정적인 문자열은 연속되거나 괄호에 포함되어있어도 안정적인 문자열이다.
그렇기 때문에 주어진 문자열에서 안정적인 문자열은 연산을 위한 탐색에서 제외시키고 나머지 문자는 stack에 저장.(1)
그리고 난 후 stack에 남아있는 문자로 비교하여 {}일떈 무시, {{이거나 }}일떈 한쪽만 변경시면 되기때문에 count+1,
}{일때는 둘다 변경해야하기 때문에 count+2
 */
public class 안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int turn = 1;
		while (true) {
			String s = br.readLine();
			int count = 0;

			if (s.length() > 0 && s.charAt(0) == '-')
				break;

			Stack<Character> stack = new Stack<>();
			//1
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (!stack.isEmpty() && c == '}' && stack.peek() == '{')
					stack.pop();
				else if(c== ' ') continue;
				else
					stack.push(c);
			}

			while (!stack.isEmpty()) {
				char c = stack.pop();

				if (c == '}') {
					if (stack.peek() == '{')
						stack.pop();
					else {
						stack.pop();
						count += 1;
					}
				} else {
					if (stack.peek() == '{')
						count += 1;
					else
						count += 2;
					stack.pop();
				}
			}

			sb.append(turn++).append(". ").append(count);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
