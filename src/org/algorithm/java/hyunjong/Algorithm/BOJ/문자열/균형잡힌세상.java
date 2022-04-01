package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
Stack을 이용해서 문자열 중에서 소괄호와 대괄호만 판단해준다.
 */
public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack;
		while(true){
			String sentence = br.readLine();
			if(sentence.equals(".")) break;

			stack = new Stack<>();
			char[] cArr = sentence.toCharArray();

			boolean isNo = false;
			for(Character c : cArr){
				if(c == '(' || c == '['){	//왼쪽 괄호가 들어오면 stack에 넣어줌
					stack.push(c);
				}else if(c == ')'){	//오른쪽 괄호가 들어왔을때
					if(!stack.empty() && stack.peek() == '('){	//스택에 어떠한 괄호가 들어있고 최근 괄호가 왼쪽 소괄호면 pop
						stack.pop();
					}else{	//그렇지 않은 경우에는 비율이 맞지않음으로 no를 출력해야함
						isNo = true;
						break;
					}
				}else if(c == ']'){	//마찬가지로 오른쪽 소괄호가 나왔을때
					if(!stack.empty() && stack.peek() == '['){	//스택에 어떠한 값이 들어있는데 최근 괄호가 왼쪽 대괄호면 pop
						stack.pop();
					}else{	//그렇지 않으면 no출력
						isNo = true;
						break;
					}
				}
			}

			if(!stack.empty() || isNo){	//괄호가 스택에서 다 빠지지 않았거나 비대칭 괄호가 있게 되면 no
				sb.append("no");
			}else{
				sb.append("yes");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
