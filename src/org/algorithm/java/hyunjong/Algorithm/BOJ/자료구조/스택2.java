package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int K = Integer.parseInt(st.nextToken());

            if(K == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else {
                if(K == 2) {
                    //스택에 정수가 있다면 정수를 빼고 해당 정수 출력 없다면 -1 출력
                    if(stack.size() != 0) {
                        sb.append(stack.pop());
                    }
                    else {
                        sb.append("-1");
                    }
                }
                else if(K == 3) {
                    //스택의 정수 개수 출력
                    sb.append(stack.size());
                }
                else if(K == 4) {
                    //스택이 비어있으면 1, 있으면 0
                    if(stack.size() == 0) {
                        sb.append("1");
                    }
                    else {
                        sb.append("0");
                    }
                }
                else if(K == 5) {
                    //스택에 정수가 있다면 맨 위의 정수 출력, 없으면 -1 출력
                    if(stack.size() != 0) {
                        sb.append(stack.peek());
                    }
                    else {
                        sb.append("-1");
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
