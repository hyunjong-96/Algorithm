package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 도키도키간식도우미{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(N-- > 0){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        String result = "Nice";

        int num = 1;
        while(true) {
            if(!queue.isEmpty() && queue.peek() == num) {
                queue.poll();
                num++;
            }
            else if(!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                num++;
            }
            else if(!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            else if(queue.isEmpty() && stack.isEmpty()) {
                break;
            }
            else {
                result = "Sad";
                break;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
