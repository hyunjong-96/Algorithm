package org.algorithm.java.hyunjong.Algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] st = br.readLine().split("");
		Stack<String> barStack = new Stack<>();
		int bar = 0;
		int count = 0;
		for (String s : st) {
			if (s.equals(")")) {
				if (!barStack.isEmpty() && barStack.peek().equals("(")) {
					barStack.pop();
					bar--;
					count += bar;
				} else {
					count++;
					bar--;
				}
			} else {
				if (barStack.empty()) {
					barStack.push("(");
				}
				bar++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
