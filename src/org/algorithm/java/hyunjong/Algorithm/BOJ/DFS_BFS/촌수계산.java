package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] edges = new List[N+1];
        for(int i=1;i<N+1;i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        bw.write(String.valueOf(dfs(edges, A, B, N)));
        bw.flush();
        bw.close();
    }

    public static int dfs(List<Integer>[] edges, int A, int B, int N) {
        boolean[] visited = new boolean[N+1];

//        visited[A] = true;
        StringBuilder sb = new StringBuilder();
        recursive(A, 0, edges, visited, sb, B);

        if(sb.length() == 0) {
            return -1;
        }
        else {
            return Integer.parseInt(sb.toString());
        }
    }

    private static void recursive(int node, int depth, List<Integer>[] edges, boolean[] visited, StringBuilder sb, int V) {
        if(node == V) {
            sb.append(depth);
            return;
        }

        if(visited[node]) {
            return;
        }

        visited[node] = true;

        for(int n : edges[node]) {
            if(visited[n]) continue;

            recursive(n, depth+1, edges, visited, sb, V);
        }

    }
}
