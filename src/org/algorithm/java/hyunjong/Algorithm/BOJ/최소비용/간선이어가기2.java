package org.algorithm.java.hyunjong.Algorithm.BOJ.최소비용;

import java.io.IOException;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.최소비용
 * fileName       : 간선이어가기2
 * author         : leehyunjong
 * date           : 2025/05/18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/18        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;

public class 간선이어가기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w)); // 양방향
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.idx;
            int cost = cur.cost;

            if (cost > dist[now]) continue; // 이미 최단 거리로 방문됨

            for (Node next : graph.get(now)) {
                int nextIdx = next.idx;
                int nextCost = next.cost;

                if (dist[nextIdx] > dist[now] + nextCost) {
                    dist[nextIdx] = dist[now] + nextCost;
                    pq.offer(new Node(nextIdx, dist[nextIdx]));
                }
            }
        }

        bw.write(String.valueOf(dist[t]));
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 기준 오름차순 정렬
        }
    }
}
