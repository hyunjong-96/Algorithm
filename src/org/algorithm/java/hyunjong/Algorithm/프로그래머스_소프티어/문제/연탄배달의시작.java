package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.io.*;
import java.util.StringTokenizer;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 연탄배달의시작
 * author         : leehyunjong
 * date           : 2025/05/13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/13        leehyunjong       최초 생성
 */
public class 연탄배달의시작 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] villages = new int[N];
        int[] diffArr = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            villages[i] = Integer.parseInt(st.nextToken());

            if(i>0) {
                diffArr[i-1] = Math.abs(villages[i]-villages[i-1]);
                minDiff = Integer.min(diffArr[i-1], minDiff);
            }
        }


        int count = 0;

        for(int i=0;i<N-1;i++){
            if(diffArr[i]==minDiff) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
