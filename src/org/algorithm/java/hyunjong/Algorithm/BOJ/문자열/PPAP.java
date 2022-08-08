package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
PPAP문자열의 조건 : P는 PPAP문자열이다. PPAP문자열 중 하나를 PPAP로 바꿔도 PPAP다.
이말인 즉슨 P는 PPAP지만, PP는 PPAP문자열이 아닌것이다.
결국 PPAP를 P로 변경하다보면 PPAP 문자열은 P가 된다.
replaceAll로 변경해봐도 PPAP를 P로 변경해도 다른 문자의 조합으로 PPAP가 될수있기때문에 안된다.
stack을 사용해서 P일때 stack.peek()=='A'인 경우를 제외하고 P를 넣어준다.
	peek가 A인 경우 그 뒤로 P P가 나오는지 확인한다. PPAP가 된다면 stack에 P를 넣어줘서 PPAP를 P로 변경한다.
A를 넣을때 stack이 비어있거나 peek가 A라면 PPAP문자열이 아니다.
모든 연산을 끝내고 stack의 크기가 1이고 P라면 PPAP문자열 그 외에는 PPAP문자열이 아니다.
 */
public class PPAP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		Stack<Character> stack = new Stack<>();

		boolean isPPAP = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if(c=='P'){
				if(stack.isEmpty() || stack.peek() == 'P') stack.push(c);
				else if(!stack.isEmpty() && stack.peek() == 'A'){
					stack.pop();
					if(!stack.isEmpty()&&stack.peek()=='P') {
						stack.pop();
						if(!stack.isEmpty()&&stack.peek()=='P'){
							stack.pop();
							stack.push('P');
						}else{
							stack.push('P');
							stack.push('A');
							stack.push(c);
						}
					}else{
						stack.push('A');
						stack.push(c);
					}
				}
			}else{
				if(stack.isEmpty() || stack.peek()=='A'){
					break;
				}else{
					stack.push(c);
				}
			}
		}

		if(stack.size()==1 && stack.pop()=='P') isPPAP = true;

		String answer = isPPAP ? "PPAP" : "NP";

		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
