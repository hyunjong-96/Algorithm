package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 유연근무제
 * author         : leehyunjong
 * date           : 2025/05/04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/05/04        leehyunjong       최초 생성
 */
public class 유연근무제 {
    public static void main(String[] args) {
        int[] schedules = new int[]{700, 800, 1100};
        int[][] timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659},{800, 801, 805, 800, 759, 810, 809},{1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;

        int result = solution(schedules, timelogs, startday);

        System.out.println(result);
    }

    static public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int scheduledTime = convertToMinutes(schedules[i]) + 10; // 희망 출근 시각 + 10분
            boolean isEligible = true;

            for (int j = 0; j < 7; j++) {
                int currentDay = (startday + j) % 7;
                if (currentDay == 0 || currentDay == 6) {
                    continue; // 주말은 건너뜀
                }

                int actualTime = convertToMinutes(timelogs[i][j]);
                if (actualTime > scheduledTime) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }

        return answer;
    }

    // 시간을 분 단위로 변환하는 메서드
    static private int convertToMinutes(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return hours * 60 + minutes;
    }
}
