package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class 그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] groups = new String[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			groups[i] = st.nextToken();
		}

		int count = 0;
		for (String group : groups) {
			boolean isGroup = true;
			Stack<Character> stack = new Stack<>();
			Set<Character> set = new LinkedHashSet<>();

			char[] word = group.toCharArray();
			for (int i = 0; i < word.length; i++) {
				char w = word[i];
				if(!set.contains(w)){
					set.add(w);
					stack.push(w);
				}else{
					if(!stack.isEmpty() && !stack.peek().equals(w)){
						isGroup = false;
						break;
					}
				}
			}

			if(isGroup) count++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
