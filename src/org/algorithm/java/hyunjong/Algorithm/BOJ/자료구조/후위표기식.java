package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 후위표기식 {
	static StringBuilder sb = new StringBuilder();
	static String problem;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		problem = br.readLine();

		Stack<Character> op = new Stack<>();
		for (int idx = 0; idx < problem.length(); idx++) {
			idx = pushAndPop(idx, op);
		}
		while(!op.isEmpty()){
			sb.append(op.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int pushAndPop(int idx, Stack<Character> op) {
		char p = problem.charAt(idx);

		if (p >= 'A' && p <= 'Z') {
			sb.append(p);
		}else if(p == '('){
			idx = bucketPushAndPop(idx);
		}else{
			if(!op.isEmpty()){
				if(p == '*' || p=='/'){
					while(!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')){
						sb.append(op.pop());
					}
					op.push(p);
				}else{
					while(!op.isEmpty()){
						sb.append(op.pop());
					}
					op.push(p);
				}
			}else{
				op.push(p);
			}
		}

		return idx;
	}

	static int bucketPushAndPop(int idx){
		idx++;

		Stack<Character> op = new Stack<>();
		while(idx < problem.length() && problem.charAt(idx) != ')'){
			char p = problem.charAt(idx);
			if(p == '('){
				idx = bucketPushAndPop(idx);
			}else if(p!=')'){
				pushAndPop(idx, op);
			}

			idx++;
		}
		while(!op.isEmpty()){
			sb.append(op.pop());
		}

		return idx;
	}
}
