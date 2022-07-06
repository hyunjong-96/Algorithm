package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			res[i] = -1;
		}

		//오큰수를 구하지 못한 arr의 idx
		Stack<Integer> stack = new Stack<>();
		for (int idx = 0; idx < N; idx++) {
			if(stack.isEmpty()){
				stack.push(idx);
			}else{
				//stack에 있는 수들의 예비 오큰수
				int currentNum = arr[idx];

				//stack에 있는 수들과 예비 오큰수와 비교한다.
				while(!stack.isEmpty()){
					//예비 오큰수가 더 크다면 stack에 있던 해당 수의 오큰수는 currentNum이다.
					if(arr[stack.peek()] < currentNum){
						res[stack.pop()] = currentNum;
					}else{
						//해당 stack 수의 오큰수가 아니라면 나머지 stack의 값의 오큰수도 아니다.
						break;
					}
				}
				stack.push(idx);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			sb.append(res[i]);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
