package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;
import java.io.*;
import java.util.*;
public class HanyangPopularityExceedingCompetition {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int[] h : arr) {
            int p = h[0];
            int c = h[1];

            if(Math.abs(p-result) <= c) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
