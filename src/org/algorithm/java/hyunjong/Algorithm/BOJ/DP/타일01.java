package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;

public class 타일01 {
    static long[] tail;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tail = new long[N+1];

        dp(N);

        bw.write(String.valueOf(tail[N]));
        bw.flush();
        bw.close();
    }

    static void dp(int N) {
        tail[0] = 1;
        tail[1] = 1;
//        tail[2] = 2;

        for(int i=2;i<=N;i++) {
            tail[i] = (tail[i-1]+tail[i-2])%15746;
        }
    }
}
