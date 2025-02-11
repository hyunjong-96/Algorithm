package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS
 * fileName       : 나이트의이동
 * author         : leehyunjong
 * date           : 2025/02/11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/11        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 나이트의이동 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] distance = new int[][]{{-2,-1}, {-1,-2}, {1,-2}, {2,-1},{2,1},{1,2},{-1,2},{-2,1}};

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(T-- > 0) {
            int L = Integer.parseInt(br.readLine());
            int[] C = new int[2];
            int[] A = new int[2];

            st = new StringTokenizer(br.readLine(), " ");
            C[0] = Integer.parseInt(st.nextToken());
            C[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            A[0] = Integer.parseInt(st.nextToken());
            A[1] = Integer.parseInt(st.nextToken());


            int result = 0;

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[L][L];
            queue.offer(new int[]{C[0], C[1], 0});

            while(!queue.isEmpty()) {
                int[] q = queue.poll();
                int y = q[0], x = q[1], cnt = q[2];

                if(visited[y][x]) {
                    continue;
                }

                if(y == A[0] && x == A[1]) {
                    result = cnt;
                    break;
                }

                visited[y][x] = true;

                for(int i=0;i<8;i++) {
                    int nextY = y + distance[i][0];
                    int nextX = x + distance[i][1];

                    if(nextY >= 0 && nextX >= 0 && nextY < L && nextX < L && !visited[nextY][nextX]) {
                        queue.offer(new int[]{nextY, nextX, cnt+1});
                    }
                }
            }

            sb.append(String.valueOf(result)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
