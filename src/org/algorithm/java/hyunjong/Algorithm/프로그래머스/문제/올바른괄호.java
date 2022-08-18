package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
		String s = "(()(";
		System.out.println(solution(s));
	}

	static boolean solution(String s){
		Stack<Character> stack = new Stack<>();

		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);

			if(c=='('){
				stack.push(c);
			}else{
				if(stack.isEmpty()){
					stack.push(c);
				}
				else if(stack.peek()=='(') stack.pop();
				else stack.push(c);
			}
		}

		return stack.isEmpty();
	}
}
