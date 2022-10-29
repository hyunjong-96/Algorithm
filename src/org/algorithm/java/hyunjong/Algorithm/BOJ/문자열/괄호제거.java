package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/*
stack과 dfs를 이용한 문제.
2개의 stack을 이용해서 stack1에서는 수식에서 괄호를 저장한다.
	이때, 열린 괄호가 stack1에 들어올때 stack1에 저장함과 동시에 stack2에 해당 수식의 index를 저장한다.
	문제에서 항상 올바른 괄호쌍만 제공한다고 했기 때문에 닫힌 괄호가 나오게되면, stack1에서 항상 열린괄호가 있을것이다.
	그렇기 때문에 stack1에서 열린괄호를 pop해주고 stack2에서 열린괄호의 index를 꺼내 수식의 두 index를 통해
	두 괄호를 '.'으로 변환하고 중복되는 괄호 쌍을 제거하고 정렬을 위해 TreeSet을 사용한다.
		TreeSet에 저장할때는 '.'을 빈 문자열로 변환해서 저장해준다.
	괄호를 '.'으로 변환하는 이유는 '.'이 아닌 빈 문자열로 변환해주게 된다면 stack2에서 저장되고 사용되는 괄호의 index가
	매칭이 안되기 때문에 이를 고려한 것이다.
 */
public class 괄호제거{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		List<int[]> bracketIndexList = makeBracketIndexList(str);

		TreeSet<String> result = new TreeSet<>();
		removeBracket(result, bracketIndexList, 0, str);

		StringBuilder sb = new StringBuilder();
		for(String s : result){
			sb.append(s).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void removeBracket(TreeSet<String> result, List<int[]> bracketIndexList, int index, String str){

		for(int i=index;i<bracketIndexList.size();i++){
			int[] currentBracketIndex = bracketIndexList.get(i);
			int front = currentBracketIndex[0];
			int end = currentBracketIndex[1];

			StringBuilder sb = new StringBuilder(str);
			sb.setCharAt(front,'.');
			sb.setCharAt(end,'.');
			result.add(sb.toString().replaceAll("\\.",""));
			removeBracket(result, bracketIndexList, i+1, sb.toString());
		}
	}

	static List<int[]> makeBracketIndexList(String str){
		List<int[]> bracketIndexList = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stackIndex = new Stack<>();

		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c == '('){
				stack.push(c);
				stackIndex.push(i);
			}else if(c == ')'){
				stack.pop();
				bracketIndexList.add(new int[]{stackIndex.pop(), i});
			}
		}

		return bracketIndexList;
	}
}
