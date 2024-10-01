package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.*;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=1;i<=N;i++){
            q1.offer(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!q1.isEmpty()) {
            for(int i=0;i<K-1;i++){
                if(q1.isEmpty() && !q2.isEmpty()) {
                    while(!q2.isEmpty()) {
                        q1.offer(q2.poll());
                    }
                }

                q2.offer(q1.poll());
            }

            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }

            list.add(q1.poll());

        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int l : list) {
            sb.append(l).append(", ");
        }

        if(!list.isEmpty()) {
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
