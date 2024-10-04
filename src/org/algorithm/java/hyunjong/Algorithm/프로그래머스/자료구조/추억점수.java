package org.algorithm.java.hyunjong.Algorithm.프로그래머스.자료구조;

import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = new String[]{"may", "kein", "kain", "radi"};
        int[] yearning = new int[]{5, 10, 1, 3};
        String[][] photo = new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(solution(name, yearning, photo));

    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<name.length;i++) {
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for(int i =0 ; i<photo.length;i++) {
            String[] p = photo[i];
            int sum = 0;수

            for(String n : p) {
                sum += map.getOrDefault(n, 0);
            }

            answer[i] = sum;
        }

        return answer;
    }
}
