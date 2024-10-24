package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.io.*;
import java.util.*;
public class yeahbuthow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            queue.offer(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        recursive(queue, sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recursive(Queue<Character> queue, StringBuilder sb) {
        if(queue.isEmpty()) {
            return;
        }

        char now = queue.poll();

        if(now == '('){
            sb.append("(");
            if(!queue.isEmpty()){
                char next = queue.peek();
                if(next == '('){
                    // sb.append("+");
                }
                else if(next == ')'){
                    sb.append("1");
                }
            }
        }
        else if(now == ')') {
            sb.append(")");
            if(!queue.isEmpty()){
                char next = queue.peek();
                if(next == '('){
                    sb.append("+");
                }
                else if(next==')'){
                    // sb.append("+1");
                }
            }
        }
        recursive(queue,sb);
    }
}
