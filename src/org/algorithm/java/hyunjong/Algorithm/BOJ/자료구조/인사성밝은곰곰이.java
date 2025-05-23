package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조
 * fileName       : 인사성밝은곰곰이
 * author         : leehyunjong
 * date           : 2025/05/23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/23        leehyunjong       최초 생성
 */
import java.io.*;
import java.util.*;

public class 인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 채팅 기록 수

        Set<String> chatSet = new HashSet<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                result += chatSet.size();  // 현재까지 유일한 닉네임 수 누적
                chatSet.clear();           // 기록 초기화
            } else {
                chatSet.add(input);        // 닉네임 저장 (중복 제거)
            }
        }

        result += chatSet.size(); // 마지막 그룹 처리
        bw.write(result + "\n");

        bw.flush();   // 출력 버퍼 비우기
        bw.close();   // 자원 정리
        br.close();
    }
}
