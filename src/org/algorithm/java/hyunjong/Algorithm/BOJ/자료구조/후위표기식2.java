package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
연산자가 들어오는 경우 stack에는 적어도 두개 이상의 숫자가 들어있어야 연산이 가능하다.
연산이 잘못되는 경우라는 조건이 없기 때문에 연산자가 들어오는 경우 stack에서 두개의 값을 꺼내서 연산하고 다시 스택에 저장
마지막 연산자가 들어오면 stack에는 하나의 값이 남아있게되는데, 그것이 결과이다.
 */
public class 후위표기식2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");

		Map<Character, Integer> map = new HashMap<>();
		char c = 'A';
		while(N-- > 0){
			int num = Integer.parseInt(br.readLine());
			map.put(c++, num);
		}

		double result = calculate(str, map);

		bw.write(String.format("%.2f",result));
		bw.flush();
		bw.close();
	}

	static double calculate(String[] str, Map<Character, Integer>map){
		Stack<Double> operand = new Stack<>();
		// Stack<Double> num = new Stack<>();

		for(String s : str){
			char c = s.charAt(0);

			if(c >= 'A' && c<='Z'){
				operand.push((double)map.get(c));
			}else {
				double n2 = operand.pop();
				double n1 = operand.pop();
				operand.push(operation(n1,n2,c));
			}
		}

		return operand.pop();
	}

	static public double operation(double n1, double n2, char c){
		double result = 0;
		switch(c){
			case '+':{
				result = n1+n2;
				break;
			}
			case '-':{
				result = n1-n2;
				break;
			}
			case '*':{
				result = n1*n2;
				break;
			}
			case '/':{
				result = n1/n2;
				break;
			}
		}
		return result;
	}
}
