package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int i=0;
		for (int n = 1; n <= N; n++) {
			stack.push(n);
			sb.append("+");
			sb.append("\n");

			while(!stack.isEmpty() && stack.peek() == sequence[i]){
				stack.pop();
				sb.append("-");
				sb.append("\n");
				i++;
			}
		}
		if(!stack.isEmpty()){
			sb = new StringBuilder();
			sb.append("NO");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
