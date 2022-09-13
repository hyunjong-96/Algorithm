package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Stack;

/*
https://wellbell.tistory.com/228

첫번째 풀이에서는 1이 3개 이상인 문자열이 있다면 해당 문자열 앞에 없다면 0이 있는 위치 뒤, 둘 다 아니라면 맨 앞에
라는 조건으로 구현했었다. 시간초과, 메모리초과 난리났었다.

다른 분들의 풀이를 보니 문자열에서 '110'을 모두 제거한다음, 마지막 0이 있다면 해당 위치 뒤에 '110'을 추가하는 것을 반복함을 알게되었다.
주어지는 문자열 배열 s에 있는 문자열의 길이가 총 1000000이기 때문에 괜찮을거라 생각했지만,
각 문자열을 반복하면서 indexOf("110")을 찾는 것은 110의 개수만큼 반복되는것이기 때문에 시간초과가 발생할 수 있었다.
그래서 stack을 이용해서 각 문자열을 한바퀴만 돌아서 110을 제거해주었다.

그 후 stack에 있는 나머지 문자열 ("110"을 모두 제거한 문자열)을 stringBuilder에 넣어주고
lastIndexOf("0")을 통해 index를 초기화하고 맨 뒤의 0이 있다면 그 뒤에 "110"을 추가하고 없다면 맨 앞에 "110"을 추가하는 식으로 구현.
 */
public class 옮기기110 {
	public static void main(String[] args) {
		String[] s = {"100111100"};
		String[] result = solution(s);

		for (String r : result) {
			System.out.println(r);
		}
	}

	static String[] solution(String[] s) {

		for (int i = 0; i < s.length; i++) {
			s[i] = solve(s[i]);
		}
		return s;
	}

	static String solve(String s) {

		Stack<Character> stack = new Stack<>();

		int regexCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (stack.size() < 2)
				stack.push(s.charAt(i));
			else{
				if (s.charAt(i) == '0') {
					char midRegex = stack.pop();
					if (midRegex == '1' && stack.peek() == '1') {
						stack.pop();
						regexCount++;
					} else {
						stack.push(midRegex);
						stack.push(s.charAt(i));
					}
				}else{
					stack.push(s.charAt(i));
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		sb.reverse();

		int lastIndex = sb.lastIndexOf("0");
		for(int i=0;i<regexCount;i++){
			sb.insert(lastIndex+1, "110");
			lastIndex += 3;
		}

		return sb.toString();
	}
}
