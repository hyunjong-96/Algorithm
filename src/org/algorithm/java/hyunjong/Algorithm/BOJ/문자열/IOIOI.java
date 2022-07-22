package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
반례
2
25
OOIOIIOIOIOIOIOIOIOIOOIOI

I일 때 stack이 비어있거나 이전 문자가 O인 경우 I를 stack에 넣어준다.
I일 때 이전 문자가 I라면 새로운 IOI문자열일 수 있기 때문에 이전까지의 완성된 IOI문자열을 List에 저장하고 stack을 비우고 새로운 I를 stack에 넣어준다.
O일 때 이전 문자가 I인 경우 O를 stack에 넣어준다.
O일 때 이전 문자가 O인 경우 stack에는 IO문자열만 있거나 ...IOIO문자열 이 있을것이다. 그렇기 때문에 이전 문자열 O를 제거하고
	stack에 1개의 문자만 남아있다면 IOI문자열을 만들 수 없기 때문에 stack의 I문자를 뺴준다.
	stack에 2개 이상의 문자가 있다면 완성된 IOI문자열을 가지고 있고 더 이상 완성된 IOI문자열을 이어서 만들 수 없기때문에
	List에 완성되어있는 IOI문자열을 저장하고 stack을 비워준다.

List에는 완성된 IOI문자열이 저장되어있다.
문자열을 하나씩 꺼내서 Pn의 IOI문자열을 만들수 있는지 확인한다. 첫번째 index에서 N*2까지가 Pn의 IOI문자열의 index범위인데
	i+N*2가 해당 문자열을 넘어가게 되면 Pn을 만족하지 못하는 IOI문자열이다.
	i+N*2가 해당 문자열을 넘어가지 않는다면 Pn을 만족하는 IOI문자열이기 때문에 count++, 그리고 i+2만큼 이동해서 다음 index에서도 Pn을 만족하는지 확인을 반복한다.

N이 1000000이라 O(N)으로의 방법을 찾았다. 2중 반복을 사용해서 시간복잡도가 염려되었지만
List에 저장되는 IOI문자열이 많아질수록 IOI의 문자열길이는 짧아지고 저장되는 IOI문자열이 작아질수록 IOI의 문자열길이는 길어지고
완성된 IOI문자열이기 때문에 연산으로도 Pn을 만족하는지 찾을 수 있어서 시간초과를 하지 않은것으로 보인다.
 */
public class IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		Stack<Character> stack = new Stack<>();
		List<String> stringList = new ArrayList<>();
		for(int i=0;i<M;i++){
			char c = S.charAt(i);

			if(c == 'I') {
				if(stack.isEmpty() || stack.peek()=='O'){
					stack.push(c);
				}else if(stack.peek() =='I'){
					stringList.add(getString(stack));
					stack = new Stack<>();
					stack.push('I');
				}
			}else if(c=='O' && (!stack.isEmpty() && stack.peek()=='I')){
				stack.push(c);
			}else if(c=='O' && (!stack.isEmpty() && stack.peek()=='O')){
				stack.pop(); //'O' out
				if(stack.size() > 2) {
					stringList.add(getString(stack));
					stack = new Stack<>();
				}else{
					stack.pop(); //'I' out
				}
			}
		}

		if(stack.size() >= 3){
			stringList.add(getString(stack));
		}

		int result = 0;
		for(String s : stringList){
			for(int i=0;i<s.length()-1;i+=2){
				if(i+2*N < s.length()){
					result++;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static String getString(Stack<Character> stack){
		StringBuilder sb = new StringBuilder();
		for(char c : stack){
			sb.append(c);
		}
		return sb.reverse().toString();
	}
}
