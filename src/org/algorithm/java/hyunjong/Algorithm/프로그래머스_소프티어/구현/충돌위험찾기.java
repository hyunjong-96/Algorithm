package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.util.LinkedList;
import java.util.Queue;

public class 충돌위험찾기 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes = new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}};

        System.out.println(solution(points, routes));
    }

    static Queue<int[]>[] memo;
    static int N;   //로봇 개수
    static int R;   //라운드

    public static int solution(int[][] points, int[][] routes) {
        N = routes.length;
        R = routes[0].length;
        memo = new LinkedList[N];

        for(int i=0;i<N;i++){
            memo[i] = new LinkedList<>();
        }

        findRoute(points, routes);

        int result = move();

        return result;
    }

    public static int move() {
        int result = 0;
        int count = 0;

        while(count < N) {
            int[][] map = new int[101][101];

            count = 0;

            for(int i=0;i<N;i++){
                if(memo[i].isEmpty()) {
                    count++;
                    continue;
                }

                int[] p = memo[i].poll();
                map[p[0]][p[1]]++;
            }

            for(int i=1;i<101;i++){
                for(int j=1;j<101;j++){
                    if(map[i][j] >= 2) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void findRoute(int[][] points, int[][] routes) {

        for(int i=0;i<N;i++){
            int startPoint = routes[i][0];
            int startR = points[startPoint-1][0];
            int startC = points[startPoint-1][1];

            memo[i].add(new int[]{startR, startC});
            for(int j=1;j<R;j++) {
                int endPoint = routes[i][j];
                int endR = points[endPoint-1][0];
                int endC = points[endPoint-1][1];

                int gapR = startR-endR;
                int gapC = startC-endC;

                while(gapR != 0) {
                    if(gapR > 0) {
                        startR--;
                        gapR--;
                    }
                    else{
                        startR++;
                        gapR++;
                    }

                    memo[i].add(new int[]{startR, startC});
                }

                while(gapC != 0) {
                    if(gapC > 0) {
                        startC--;
                        gapC--;
                    }
                    else{
                        startC++;
                        gapC++;
                    }

                    memo[i].add(new int[]{startR, startC});
                }
            }
        }
    }
}
