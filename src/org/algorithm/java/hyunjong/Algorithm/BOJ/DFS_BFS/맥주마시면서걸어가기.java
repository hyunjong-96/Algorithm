package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 맥주마시면서걸어가기 {
    static boolean[][] shop;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            List<Point> pointList = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                pointList.add(new Point(y, x));

                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N + 1; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (menhattan(pointList.get(i), pointList.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            if (bfs(graph, N)) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean bfs(List<List<Integer>> graph, int N) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 2];

        queue.offer(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (index == N + 1) {
                return true;
            }

            if (visited[index]) {
                continue;
            }

            visited[index] = true;

            for (int next : graph.get(index)) {
                queue.offer(next);
            }
        }

        return false;
    }

    static int menhattan(Point a, Point b) {
        return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
