package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.*;
public class 패션왕신혜빈{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            while(n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String clothes = st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(category,0)+1);
            }

            int sum = 1;
            for(String category : map.keySet()) {
                sum += sum*map.get(category);
            }

            sb.append(String.valueOf(sum-1));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
