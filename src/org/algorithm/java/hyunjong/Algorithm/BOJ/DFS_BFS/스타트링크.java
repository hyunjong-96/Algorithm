package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class 스타트링크 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //총 층수
        int F = Integer.parseInt(st.nextToken());
        //현재 위치
        int S = Integer.parseInt(st.nextToken());
        //목적지 층수
        int G = Integer.parseInt(st.nextToken());
        //위로 U층
        int U = Integer.parseInt(st.nextToken());
        //아래로 D층
        int D = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[F+1];

        for(int i=1;i<=F;i++) {
            edges[i] = new ArrayList<>();

            int up = i+U;
            int down = i-D;

            if(up <= F) {
                edges[i].add(up);
            }
            if(down > 0) {
                edges[i].add(down);
            }
        }

        bw.write(bfs(edges, F, S, G));
        bw.flush();
        bw.close();

    }

    private static String bfs(List<Integer>[] edges, int F, int S, int G) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];

        queue.add(S);

        int depth = 0;

        while(!queue.isEmpty()) {

            int depthSize = queue.size();
            for(int i=0;i<depthSize; i++) {
                int currentF = queue.poll();

                if(currentF == G) {
                    return String.valueOf(depth);
                }

                if(visited[currentF]) {
                    continue;
                }

                visited[currentF] = true;

                for(int f : edges[currentF]) {
                    if(visited[f]) continue;

                    queue.add(f);
                }
            }

            depth++;
        }

        return "use the stairs";
    }
}
