package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] tops = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<N+1;i++){
			tops[i] = Integer.parseInt(st.nextToken());
		}

		//현재 탑의 왼쪽에 있는 탑 중 수신 받을 가능성이 있는 탑
		//stack.peek()에 있는 탑이 현재 탑의 가장 가까운데 있는 탑
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[N+1];
		for(int i=1;i<N+1;i++){
			int currentTop = tops[i];
			//비어있다면 수신받을 탑이 없기 때문에 0
			//그리고 현재 탑을 stack에 넣어 수신받을 수 있는 탑 중 하나가 된다.
			if(stack.isEmpty()){
				stack.push(i);
			}else{
				while(!stack.isEmpty()){
					//가장 가까운데 있는 수신 탑이 현재 탑보다 작다면 수신받을 수 없다.
					//현재 탑이 stack에 들어갈것이기 때문에 현재 탑보다 작은 수신탑은 있을 필요없다.
					if(tops[stack.peek()] < currentTop){
						stack.pop();
					}else{
						res[i] = stack.peek();
						break;
					}
				}
				//현재 탑을 수신 탑 리스트에 추가한다.
				stack.push(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<N+1;i++){
			sb.append(res[i]);
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
