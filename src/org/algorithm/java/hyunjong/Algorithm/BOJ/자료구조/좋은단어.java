package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Stack;

/*
Stack을 사용하는 문제.
동일한 문자 사이에 다른 동일한 문자가 있어야 좋은 단어이다.
예를 들어 ABBBAB 라면 좋은 단어가 아니다.
	ABBAB로 문자의 짝이 맞지 않아도 좋은 단어가 아니다.
이를 해결하기 위해 특정 문자와 stack에 저장되어있는 최근 문자가 동일하다면 stack에서 제거해준다.
	그렇지 않다면 그냥 stack에 저장을 해준다.
만약 좋은 단어라면 stack이 비어있을것이고 그렇지 않다면 stack이 비어있지 않다.
 */
public class 좋은단어{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count=0;
		int N = Integer.parseInt(br.readLine());

		while(N-- > 0){
			String word = br.readLine();

			Stack<Character> stack = new Stack<>();
			for(int i=0;i<word.length();i++){
				char c = word.charAt(i);

				if(!stack.isEmpty() && stack.peek() == c){
					stack.pop();
				}else{
					stack.push(c);
				}
			}

			if(stack.isEmpty()){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
