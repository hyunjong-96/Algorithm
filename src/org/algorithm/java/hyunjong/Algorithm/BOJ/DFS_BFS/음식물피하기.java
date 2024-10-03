package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 음식물피하기{
    static List<Point> trashList;
    static boolean[][] visited;
    static boolean[][] graph;

    static int[][] distance = new int[][]{{0,1}, {-1,0},{0,-1},{1,0}};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        trashList = new ArrayList<>();
        visited = new boolean[N+1][M+1];
        graph = new boolean[N+1][M+1];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[r][c] = true;

            trashList.add(new Point(r,c));
        }

        int result = 0;
        for(Point p : trashList) {
            result = Math.max(trashSize(p), result);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    static int trashSize(Point now) {
        if(visited[now.r][now.c]) {
            return 0;
        }

        visited[now.r][now.c] = true;

        int trashSize = 0;

        int nextR=0;
        int nextC=0;
        for(int i=0;i<4;i++){
            nextR = now.r + distance[i][0];
            nextC = now.c + distance[i][1];

            if(nextR <= N && nextR >0 && nextC <= M && nextC > 0 && graph[nextR][nextC]) {
                trashSize += trashSize(new Point(nextR, nextC));
            }
        }

        return trashSize+1;
    }

    static class Point{
        int r;
        int c;
        public Point(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
}
