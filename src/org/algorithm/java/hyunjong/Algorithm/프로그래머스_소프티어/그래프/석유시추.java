package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그래프;

import java.util.*;

public class 석유시추 {
    public static void main(String[] args) {
        int[][] land = new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};

        System.out.println(solution(land));
    }

    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] distance = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    static int[][] LAND;
    static int[][] check;
    static List<Integer> colorList = new ArrayList<>();
    static public int solution(int[][] land) {

        M = land[0].length;
        N = land.length;
        LAND = land;

        int answer = 0;


        visited = new boolean[N][M];
        check = new int[N][M];

        colorList.add(0);
        int color = 1;
        for(int m = 0;m<M;m++) {
            for(int n = 0;n<N;n++){
                if(LAND[n][m] == 0 || visited[n][m]){
                    continue;
                }

//                visited[n][m] = true;
//                check[n][m] = color;
                int size = bfs(n,m, color);
                colorList.add(size);
                color++;
            }

//            answer = Math.max(answer,size);
        }

        for(int m=0;m<M;m++){
            Set<Integer> set = new HashSet<>();
            for(int n=0;n<N;n++){
                if(check[n][m] != 0) {
                    set.add(check[n][m]);
                }
            }

            int sum = 0;
            for(int c : set) {
                sum += colorList.get(c);
            }

            answer = Math.max(answer, sum);
        }


        return answer;
    }

    public static int bfs(int n, int m, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n,m});

        int size = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowN = now[0];
            int nowM = now[1];

            if(LAND[nowN][nowM] == 0 || visited[nowN][nowM]) {
                continue;
            }

            size++;
            visited[nowN][nowM] = true;
            check[nowN][nowM] = color;

            for(int i=0;i<4;i++){
                int nextN = nowN+distance[i][0];
                int nextM = nowM+distance[i][1];

                if(nextN >=0 && nextN <N && nextM >=0 && nextM <M) {
                    queue.offer(new int[]{nextN, nextM});
                }
            }
        }

        return size;
    }
}
