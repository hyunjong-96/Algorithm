package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.*;
public class 점프 {
    static int N;
    static int cnt;
    static long[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        int[][] map = new int[N][N];
        dp = new long[N][N];
        visited = new boolean[N][N];

        for(int y=0;y<N;y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int x=0;x<N;x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = recursive(0,0,map);

        bw.write(String.valueOf(dp[0][0]));
        bw.flush();
        bw.close();
    }

    public static long recursive(int y, int x, int[][]map) {
        if(y==N-1 && x==N-1) {

            return 1;
        }

        if(visited[y][x]) {
            return dp[y][x];
        }
        visited[y][x] = true;

        if(dp[y][x] == 0) {
            if(x+map[y][x] < N) {
                dp[y][x] += recursive(y, x+map[y][x], map);
            }

            if(y+map[y][x] < N) {
                dp[y][x] += recursive(y+map[y][x], x, map);
            }
        }

        return dp[y][x];
    }
}
