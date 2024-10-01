package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class 지름길 {
    static int N;
    static int D;
    static int[] dist;
    static boolean[] visited;
    static List<Node>[] street;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        street = new List[D+1];
        visited = new boolean[D+1];
        dist = new int[D+1];

        Arrays.fill(dist, INF);

        for(int i=0;i<=D;i++) {
            street[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

//            street[s].add(new Node(s,e,d));
//            street[0].add(new Node(0, s, s));

            if(e <= D) {
                street[s].add(new Node(s,e,d));
            }
        }

        for(int i=0;i<D;i++) {
            street[i].add(new Node(i, i+1, 1));
        }

        int result = dijkstra();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        dist[0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for(Node next : street[now.end]) {
                if(next.end > D) {
                    continue;
                }

                if(dist[next.end] > dist[now.end] + next.distance) {
                    dist[next.end] = dist[now.end] + next.distance;
                    pq.offer(new Node(now.end, next.end, dist[next.end]));
                }
            }
        }

        return dist[D];
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
