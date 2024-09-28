package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;
import java.util.*;

public class 올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] grade = new int[N][3];
        Integer[] country = new Integer[N];

        /// 입력 처리

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken())-1;
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            grade[c] = new int[]{gold, silver, bronze};
            country[i] = c;
        }

        // Comparator를 사용해 내림차순으로 정렬
        Arrays.sort(country, (c1, c2) -> {
            // gold 메달 비교
            if (grade[c1][0] != grade[c2][0]) {
                return Integer.compare(grade[c2][0], grade[c1][0]); // gold 기준 내림차순
            }
            // silver 메달 비교
            if (grade[c1][1] != grade[c2][1]) {
                return Integer.compare(grade[c2][1], grade[c1][1]); // silver 기준 내림차순
            }
            // bronze 메달 비교
            return Integer.compare(grade[c2][2], grade[c1][2]); // bronze 기준 내림차순
        });

        int[] rank = new int[N];
        int ranking = 1;

        String result = "";
        rank[country[0]] = ranking;
        int sameCnt = 0;
        for(int i=1;i<N;i++) {
            if (Arrays.equals(grade[country[i]], grade[country[i - 1]])) {
                rank[country[i]] = ranking;
                sameCnt++;
            } else {
                // 메달 수가 다르면 새로운 순위를 부여
                ranking += 1+sameCnt;
                sameCnt=0;
                rank[country[i]] = ranking;
            }
        }

        bw.write(String.valueOf(rank[K-1]));
        bw.flush();
        bw.close();
    }
}