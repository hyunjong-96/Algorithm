package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;

public class 누울자리를찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] room = new char[N][N];

        for(int i=0;i<N;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine(),"");
            String r = br.readLine();
            for(int j=0;j<N;j++) {
                room[i][j] = r.charAt(j);
            }
        }

        int rowResult = 0;
        int heightResult = 0;
        int rowCount = 0;
        int heightCount = 0;

        //가로 확인
        for(int y=0;y<N;y++) {
            rowCount=0;
            for(int x=0;x<N;x++) {
                char now = room[y][x];

                if(now == 'X') {
                    if(rowCount >= 2) {
                        rowResult++;
                    }
                    rowCount = 0;
                }
                else {
                    rowCount++;
                }

                if(x==N-1 && rowCount >= 2) {
                    rowResult++;
                }

            }
        }

        //세로 확인
        for(int x=0;x<N;x++) {
            heightCount = 0;
            for(int y=0;y<N;y++) {
                char now = room[y][x];

                if(now == 'X') {
                    if(heightCount >= 2) {
                        heightResult++;
                    }
                    heightCount = 0;
                }
                else {
                    heightCount++;
                }

                if(y==N-1 && heightCount>=2) {
                    heightResult++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rowResult). append(" ").append(heightResult);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
