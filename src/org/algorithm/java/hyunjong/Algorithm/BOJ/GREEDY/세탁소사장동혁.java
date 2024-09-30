package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;

public class 세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int q = 25;
        int d = 10;
        int n = 5;
        int p = 1;

        int[] result = new int[4];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());

            result[0] = N/q;
            N %= q;

            result[1] = N/d;
            N %= d;

            result[2] = N/n;
            N %= n;

            result[3] = N/p;

            sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append(" ").append(result[3]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
