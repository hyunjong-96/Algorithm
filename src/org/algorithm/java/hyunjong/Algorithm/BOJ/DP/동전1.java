package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.*;

public class 동전1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int[] dp = new int[K+1];
        dp[0] = 1;

        for(int i=0;i<N;i++) {
            coin[i] = Integer.parseInt(br.readLine());

            for(int j = coin[i];j<=K;j++) {
                dp[j] = dp[j] + dp[j-coin[i]];
            }
        }

        bw.write(String.valueOf(dp[K]));
        bw.flush();
        bw.close();
    }
}
