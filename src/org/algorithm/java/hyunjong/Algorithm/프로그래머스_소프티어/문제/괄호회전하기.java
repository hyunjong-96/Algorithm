package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
s를 왼쪽으로 한칸씩 이동한 후 해당 괄호열 배열이 올바른 괄호열인지 판단하는 문제
Queue에 첫 문자열을 문자 형식으로 넣어준다.
그런 다음 Queue에서 문자 하나씩 빼준다음 문자를 하나씩 Stack에 조건에 맞게 넣거나 뺴준다.
	-stack이 비어있다면 문자를 넣는다
	-stack에 들어있는 문자가 열려있는 문자이고 해당 문자의 닫힌 괄호가 다음으로 들어온다면 stack의 문자를 빼준다
이를 반복하고 모든 문자를 비교헀을때 stack이 비어있다면 올바른 괄호이고 아니라면 올바른 괄호가 아니다.
그리고 queue에서 맨 앞의 문자를 빼서 마지막 자리로 이동시켜준다 (왼쪽 회전)

1000*1000으로 해결가능
 */
public class 괄호회전하기 {
	public static void main(String[] args) {
		String s = "[)(]";
		System.out.println(solution(s));
	}

	static int solution(String s){
		Queue<Character> queue = new LinkedList<>();
		for(int i=0;i<s.length();i++){
			queue.offer(s.charAt(i));
		}

		int count = 0;
		for(int i=0;i<s.length();i++){
			Stack<Character> stack = new Stack<>();

			for(int j=0;j<queue.size();j++){
				char c = queue.poll();
				queue.offer(c);

				if(stack.isEmpty()) stack.push(c);
				else if(isCorrect(stack.peek(), c)){
					stack.pop();
				}else{
					stack.push(c);
				}
			}

			if(stack.isEmpty()) count++;

			char firstC = queue.poll();
			queue.offer(firstC);
		}

		return count;
	}

	static boolean isCorrect(int stackC, int compareC){
		if((stackC == '(' && compareC == ')')
			|| (stackC == '{' && compareC == '}')
			|| (stackC == '[' && compareC == ']')) return true;
		return false;
	}

}
