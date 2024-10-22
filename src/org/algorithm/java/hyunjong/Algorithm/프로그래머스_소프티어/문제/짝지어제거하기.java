package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Stack;

/*
연속된 문자를 찾아서 제거하고 앞에서부터 또 연속되는 문자를 찾아서 제거해야하기 때문에
stack을 사용하면 O(N)으로 연속되는 문자를 조건에 맞게 삭제할 수 있다.
 */
public class 짝지어제거하기 {
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}

	static int solution(String s){
		Stack<Character> stack = new Stack<>();

		for(int i=0;i<s.length();i++){
			if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
				stack.pop();
			}else{
				stack.push(s.charAt(i));
			}
		}

		int answer = 0;
		if(stack.isEmpty()) answer = 1;

		return answer;
	}
}
