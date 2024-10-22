package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = 	{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for(String[] clothe : clothes) {
            String wear = clothe[0];
            String category = clothe[1];

            map.put(category, map.getOrDefault(category, 0)+1);
        }

        int answer = 1;
        for(String c : map.keySet()) {
            answer *= map.get(c) +1 ;
        }

        return answer-1;
    }
}
