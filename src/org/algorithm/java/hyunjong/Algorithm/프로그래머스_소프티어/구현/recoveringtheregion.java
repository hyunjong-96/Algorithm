package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.io.*;
import java.util.*;

public class recoveringtheregion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int group = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                // sb.append(resultMap[i][j]).append(" ");
                sb.append(group).append(" ");
            }
            sb.append("\n");
            group++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
