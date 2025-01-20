package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.자료구조;

import lombok.ToString;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.자료구조
 * fileName       : 과제진행하기
 * author         : leehyunjong
 * date           : 2025/01/20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/01/20        leehyunjong       최초 생성
 */
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 과제진행하기 {
    public static void main(String[] args) {
        String[][] plans = new String[][]{{"aaa", "12:00", "40"}, {"bbb", "12:10", "10"}, {"ccc", "12:30", "20"}, {"ddd","12:40","10"},{"eee","13:10","10"}};

        String[] result = solution(plans);

        for(String r : result) {
            System.out.println(r);
        }
    }

    public static String[] solution(String[][] plans) {
        List<Plan> planList = new ArrayList<>();

        for(String[] plan : plans) {
            planList.add(new Plan(plan[0], plan[1], Integer.parseInt(plan[2])));
        }

        planList = planList.stream().sorted().collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();

        Plan p = planList.get(0);

        for(int i=1; i <planList.size(); i++) {
            Plan np = planList.get(i);

            int gap = np.start - p.start;
            int leafTime = p.time - gap;

            if(leafTime > 0) {
                p.time = leafTime;
                stack.push(p);
            }
            else {
                result.add(p.sub);

                while(!stack.isEmpty() && leafTime < 0) {
                    Plan leafP = stack.pop();

                    leafTime += leafP.time;

                    if(leafTime > 0) {
                        leafP.time = leafTime;
                        stack.push(leafP);
                    }
                    else {
                        result.add(leafP.sub);
                    }
                }
            }

            p = np;
        }

        result.add(p.sub);

        while(!stack.isEmpty()) {
            result.add(stack.pop().sub);
        }


        return result.toArray(new String[0]);
    }

    @ToString
    public static class Plan implements Comparable {
        String sub;
        int time;
        int start;

        public Plan(String sub, String start, int time) {
            this.sub = sub;
            this.start = convertToTime(start);
            this.time = time;
        }

        public int convertToTime(String start) {
            String[] arr = start.split(":");

            int h = Integer.parseInt(arr[0]) * 60;
            int m = Integer.parseInt(arr[1]);

            return h+m;
        }

        @Override
        public int compareTo(Object o) {
            return this.start - ((Plan)o).start;
        }
    }
}
