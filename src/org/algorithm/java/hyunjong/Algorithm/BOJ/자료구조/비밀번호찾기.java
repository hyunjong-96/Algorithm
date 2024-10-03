package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            String url = st.nextToken();
            String pw = st.nextToken();

            map.put(url, pw);
        }

        StringBuilder sb = new StringBuilder();
        while(M -- > 0) {
            String url = br.readLine();

            sb.append(map.get(url)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
