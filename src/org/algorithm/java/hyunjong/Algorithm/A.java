package org.algorithm.java.hyunjong.Algorithm;

import java.io.*;
import java.util.Stack;
public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while(true){
			String text = br.readLine();
			if(text.equals(".")) break;
			text = text.replaceAll("[a-z A-Z ]","");
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<text.length()-1;i++){
				char c = text.charAt(i);


				if(!stack.isEmpty() && ((c==']' && stack.peek()=='[') || (c==')' && stack.peek()=='('))){
					stack.pop();
				}else stack.push(c);
			}
			String answer = stack.isEmpty() ? "yes" : "no";
			sb.append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}