package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Arrays;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 이웃한칸
 * author         : leehyunjong
 * date           : 2025/04/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/04/26        leehyunjong       최초 생성
 */
public class 이웃한칸 {

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"},{"red", "red", "blue", "orange"},{"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;

        System.out.println(solution(board, h, w));
    }

    public static int solution(String[][] board, int h, int w) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};
        int n = board.length;
        int m = board[0].length;
        int answer = 0;

        String targetColor = board[h][w];

        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (board[nx][ny].equals(targetColor)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
