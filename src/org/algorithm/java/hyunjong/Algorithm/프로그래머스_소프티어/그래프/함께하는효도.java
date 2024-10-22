package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그래프;
import java.io.*;
import java.util.*;
public class 함께하는효도 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] point;
    static int[][] distance = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++){
                int f = Integer.parseInt(st.nextToken());
                map[i][j] = f;
            }
        }

        point = new int[M+1][2];
        boolean[][] visited = new boolean[N+1][N+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[i][0]=x;
            point[i][1]=y;

            visited[x][y] = true;
            answer += map[x][y];
        }

        move(point[1][0],point[1][1], 1, 0, visited, answer);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void move(int x,int y, int index,int moveCnt, boolean[][] visited, int sum){
        answer = Math.max(answer,sum);
        // System.out.println("X : "+x+" / y : "+y+" / index : "+index+" / moveCnt : "+moveCnt+" / sum : "+sum);
        if(moveCnt == 3) {
            if(index < M) {
                move(point[index+1][0], point[index+1][1], index+1, 0, visited, sum);
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nextX = x+distance[i][0];
            int nextY = y+distance[i][1];

            if(nextX>0 &&nextX<=N &&nextY>0 && nextY<=N && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                move(nextX,nextY,index,moveCnt+1,visited,sum+map[nextX][nextY]);
                visited[nextX][nextY] = false;
            }
        }
    }
}
