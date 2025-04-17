package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 붕대감기
 * author         : leehyunjong
 * date           : 2025/04/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/04/17        leehyunjong       최초 생성
 */
public class 붕대감기 {

    public static void main(String[] args) {
        int[] bandage = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10},{9,15},{10,5},{11,5}};
        int result = solution(bandage, health, attacks);

        System.out.print(result);
    }
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int t = bandage[0]; // 연속 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int time = 0;
        int healCombo = 0;
        int attackIndex = 0;

        while (time <= attacks[attacks.length - 1][0]) {
            // 공격이 오는 시간
            if (attackIndex < attacks.length && time == attacks[attackIndex][0]) {
                health -= attacks[attackIndex][1];
                healCombo = 0; // 연속 회복 초기화
                attackIndex++;

                if (health <= 0) return -1;
            } else {
                // 공격 안 당하는 시간이므로 회복
                healCombo++;
                health += x;
                if (healCombo == t) {
                    health += y;
                    healCombo = 0;
                }
                if (health > maxHealth) health = maxHealth;
            }
            time++;
        }

        return health;
    }
}
