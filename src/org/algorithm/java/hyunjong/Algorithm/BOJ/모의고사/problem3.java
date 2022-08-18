package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

import java.util.Stack;

class problem3 {
	public int solution(int[] order) {
		Stack<Integer> stack = new Stack<>();

		int answer = 0;
		int box = 1;
		for(int i=0;i<order.length;i++){
			if(box <= order[i]){
				for(int b=box;b<=order[i];b++){
					stack.push(b);
					box++;
				}
			}

			while(!stack.isEmpty() && order[i] == stack.peek()){
				stack.pop();
				answer++;
			}

			if(!stack.isEmpty() && stack.peek() > order[i]) break;
		}

		return answer;
	}


	abstract class Animal{
		abstract void cry();

		void sleep(){
			System.out.println("sleep");
		}
	}
}
