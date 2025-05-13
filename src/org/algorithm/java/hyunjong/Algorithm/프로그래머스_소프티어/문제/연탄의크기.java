package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 연탄의크기
 * author         : leehyunjong
 * date           : 2025/05/13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/13        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;
public class 연탄의크기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] villages = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int maxSize = 0;
        for(int i=0;i<N;i++){
            villages[i] = Integer.parseInt(st.nextToken());
            maxSize = Integer.max(maxSize, villages[i]);
        }

        // int size = 2;
        int minSize = Integer.MAX_VALUE;
        int maxCnt = 0;
        int cnt = 0;

        int idx=0;
        for(int size=2;size<=maxSize;size++) {
            cnt = 0;
            if(villages[idx] < size) {
                idx++;
                continue;
            }


            for(int j=idx;j<N;j++){
                if(villages[j] % size == 0) {
                    cnt++;
                }
            }

            if(cnt > maxCnt) {
                // minSize = size;
                maxCnt = cnt;
            }
        }

        bw.write(String.valueOf(maxCnt));
        bw.flush();
        bw.close();
    }
}
