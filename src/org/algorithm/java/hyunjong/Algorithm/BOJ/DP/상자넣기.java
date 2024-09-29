package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.*;
public class 상자넣기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] dp = new int[N];
        int[] box = new int[N];

        for(int i=0;i<N;i++){
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);

        dp(dp, box, N);

        int result = 0;
        for(int i=0;i<N;i++) {
            result = Math.max(dp[i], result);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void dp(int[] dp, int[] box, int N) {
        dp[0] = 1;
        dp[1] = box[1] > box[0] ? 2 : 1;

        for(int i=2;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(box[i] > box[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
        }
    }
}
