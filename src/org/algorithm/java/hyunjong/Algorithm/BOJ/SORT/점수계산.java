package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.SORT
 * fileName       : 점수계산
 * author         : leehyunjong
 * date           : 2025/05/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/01        leehyunjong       최초 생성
 */
public class 점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            list.add(new int[]{score, i + 1}); // 문제 번호는 1부터 시작!
        }

        // 점수 기준 내림차순 정렬
        list.sort((a, b) -> b[0] - a[0]);

        int total = 0;
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            total += list.get(i)[0];
            indexList.add(list.get(i)[1]); // 문제 번호 저장
        }

        // 번호 오름차순 정렬
        Collections.sort(indexList);

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");
        for (int idx : indexList) {
            sb.append(idx).append(" ");
        }

        bw.write(sb.toString().trim() + "\n");
        bw.flush();
        bw.close();
    }
}
