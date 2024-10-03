package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;

public class 영역구하기{
    static int M;
    static int N;

    static int[][] distance = new int[][]{{0,1},{-1,0},{0, -1},{1,0}};

    static boolean[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new boolean[M][N];

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            setSquare(y1, x1, y2, x2);
        }

        List<Integer> sizeList = findSpace();

        Collections.sort(sizeList);

        StringBuilder sb = new StringBuilder();
        sb.append(sizeList.size());

        if(!sizeList.isEmpty()) {
            sb.append("\n");

            for(int size : sizeList){
                sb.append(size).append(" ");
            }

            sb.deleteCharAt(sb.length()-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static List<Integer> findSpace() {
        List<Integer> sizeList = new ArrayList<>();

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){

                if(!graph[i][j]) {
                    sizeList.add(bfs(i,j));
                }
            }
        }

        return sizeList;
    }

    static int bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y,x));

        int size = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(graph[now.y][now.x]) {
                continue;
            }

            graph[now.y][now.x] = true;
            size++;

            int nextX =0;
            int nextY = 0;

            for(int i=0;i<4;i++){
                nextY = now.y+distance[i][0];
                nextX = now.x+distance[i][1];

                if(nextX<N &&nextX>=0 && nextY<M && nextY>=0 && !graph[nextY][nextX]) {
                    queue.offer(new Point(nextY,nextX));
                }
            }
        }

        return size;
    }

    static void setSquare(int y1, int x1, int y2, int x2) {
        boolean[][] tempGraph = new boolean[M+1][N+1];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y1, x1));

        int maxY = Math.max(y1, y2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int minX = Math.min(x1, x2);

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(tempGraph[now.y][now.x]){
                continue;
            }

            tempGraph[now.y][now.x] = true;
            graph[now.y][now.x] = true;

            int nextX = 0;
            int nextY = 0;

            for(int i=0;i<4;i++){
                nextY = now.y+distance[i][0];
                nextX = now.x+distance[i][1];

                if(nextX <maxX && nextX >=minX && nextY < maxY && nextY >=minY && !tempGraph[nextY][nextX]) {
                    queue.offer(new Point(nextY,nextX));
                }
            }
        }

    }

    static class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
