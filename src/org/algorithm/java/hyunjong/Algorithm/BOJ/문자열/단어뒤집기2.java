package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
stack을 이용해서 <>안의 문자가 아닌 경우 모두 넣어주다가 ' '이나 '<'발생시 stack에 들어있는 문자를 pop으로 역전
'<' 발생시 flag를 이용해 태그안의 문자들을 다뤄주고 '>'발생시 flag를 풀어준다.
 */
public class 단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[] cArr = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		for(char c : cArr){
			//태그가 아니고 ' '나 '<'가 아닌 경우 스택에 보관
			if(!flag && c != ' ' && c != '<'){
				stack.push(c);
			}
			/*
			태그가 아닌데 ' '나 '<'가 발생했을 경우
			공통으로 스택의 문자를 역전하기 위해 pop으로 sb에 저장하고 자기 자신을 넣는다
			이때 ' < '는 flag를 true로 변경하여 태그임을 알린다.
			*/
			else if(!flag){
				while(!stack.empty()){
					sb.append(stack.pop());
				}
				if(c == '<'){
					flag = true;
				}
				sb.append(c);
			}
			//태그안의 '>'가 아닌 문자들은 역전이 되지 않음으로 그냥 sb에 저장
			else if(flag && c != '>'){
				sb.append(c);
			}
			//태그의 끝인 '>'가 발생했을땐 자기 자신을 넣어주고 flag를 풀어준다.
			else{
				flag = false;
				sb.append(c);
			}
		}
		//모든 문자열을 돌았을때 태그가 아닌 문자가 들어있을수 있으므로 처리
		if(!stack.empty()){
			while (!stack.empty()){
				sb.append(stack.pop());
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
