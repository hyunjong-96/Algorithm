package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.플로이드와샬;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            List<Point> pointList = new ArrayList<>();
            for(int i=0;i<N+2;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pointList.add(new Point(x, y));
            }

            boolean[][] isSearch = new boolean[N+2][N+2];

            for(int i=0;i<N+2;i++){
                for(int j=i+1;j<N+2;j++) {
                    if(menhatten(pointList.get(i), pointList.get(j)) <= 1000) {
                        isSearch[i][j] = true;
                        isSearch[j][i] = true;
                    }
                }
            }

            if(flooyd(isSearch, N)) {
                sb.append("happy");
            }
            else {
                sb.append("sad");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean flooyd(boolean[][] isSearch, int N) {
        for(int k=0;k<N+2;k++) {
            for(int i=0;i<N+2;i++) {
                for(int j=0;j<N+2;j++) {
                    if(isSearch[i][k] && isSearch[k][j]) {
                        isSearch[i][j] = true;
                    }
                }
            }
        }

        return isSearch[0][N+1];
    }

    static int menhatten(Point a, Point b) {
        return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
