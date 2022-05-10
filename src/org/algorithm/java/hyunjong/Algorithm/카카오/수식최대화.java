package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 수식최대화 {
	public static void main(String[] args) {
		String expression = "10-20+30-40";
		System.out.println(solution(expression));
	}

	static List<Character> operation;
	static LinkedList<Number> numberLinkedList;
	static long res;
	static boolean[] check;

	static long solution(String expression) {
		operation = new ArrayList<>();
		numberLinkedList = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		List<Character> operationList = new ArrayList<>();
		char[] expressionArr = expression.toCharArray();
		for (int i = 0; i < expressionArr.length; i++) {
			char c = expressionArr[i];
			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				if (!operation.contains(c)) {
					operation.add(c);
				}
				operationList.add(c);
				numberLinkedList.add(new Number(Integer.parseInt(sb.toString()), '+'));
				sb = new StringBuilder();
			}
		}
		numberLinkedList.add(new Number(Integer.parseInt(sb.toString()),'+'));
		for(int i = 1;i< numberLinkedList.size();i++){
			numberLinkedList.get(i).op = operationList.get(i-1);
		}


		check = new boolean[operation.size()];
		res = Long.MIN_VALUE;
		operate(0, numberLinkedList);

		return res;
	}

	static void operate(int count, LinkedList<Number> numberList) {
		if (count >= operation.size()) {
			res = Math.max(Math.abs(numberList.getFirst().num), res);
			return;
		}

		for (int i = 0; i < operation.size(); i++) {
			if (!check[i]) {
				LinkedList<Number> copyNumberLinkedList = copyNumberLinkedList(numberList);
				//copyNumberLinekdList가 줄어들으로 j를 조절하는 식이 필요함.
				//j는 계속 증가하지만 copyNumberLinkedList는 연산시 j의 요소가 삭제됨으로 매칭이 안됨.
				int j = 1;
				while(j< copyNumberLinkedList.size()){
					Number currentNumber = copyNumberLinkedList.get(j);
					Number prevNumber = copyNumberLinkedList.get(j - 1);
					if (operation.get(i) == currentNumber.op) {
						switch (currentNumber.op) {
							case '+':
								copyNumberLinkedList.get(j - 1).num = prevNumber.num + currentNumber.num;
								copyNumberLinkedList.remove(currentNumber);
								break;
							case '-':
								copyNumberLinkedList.get(j - 1).num = prevNumber.num - currentNumber.num;
								copyNumberLinkedList.remove(currentNumber);
								break;
							case '*':
								copyNumberLinkedList.get(j - 1).num = prevNumber.num * currentNumber.num;
								copyNumberLinkedList.remove(currentNumber);
								break;
						}
					}else{
						j++;
					}
				}

				check[i] = true;
				operate(count + 1, copyNumberLinkedList);
				check[i] = false;
			}
		}
	}

	static LinkedList<Number> copyNumberLinkedList(LinkedList<Number> numberLinkedList) {
		LinkedList<Number> copy = new LinkedList<>();

		for (Number n : numberLinkedList) {
			copy.add(new Number(n.num, n.op));
		}
		return copy;
	}

	static class Number {
		long num;
		char op;

		public Number(long num, char op) {
			this.num = num;
			this.op = op;
		}
	}
}
