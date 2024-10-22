package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.자료구조;

import java.util.Arrays;

public class 요격시스템 {
    public static void main(String[] args) {
        int[][] targets = new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, (o1,o2)-> o1[1]-o2[1]);

        int answer = 0;
        int before = 0;
        for(int[] target : targets) {
            if(before <= target[0]) {
                answer++;
                before = target[1];
            }
        }

        return answer;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int result = Integer.compare(o1[0],o2[0]);
//
//                if(o1[0] == o2[0]){
//                    result = Integer.compare(o1[1],o2[1]);
//                }
//
//                return result;
//            }
//        });
//
//        for(int[] target : targets) {
//            pq.offer(target);
//        }
//
//        int answer = 1;
//
//        int[] current = pq.poll();
//        int cStart = current[0];
//        int cEnd = current[1];
//
//        while(!pq.isEmpty()) {
//            int[] next = pq.poll();
//            int nStart = next[0];
//            int nEnd = next[1];
//
//            if((cStart >= nStart && cStart <= nEnd) || (cEnd > nStart && cEnd <= nEnd)) {
//                continue;
//            }
//            else {
//                current = next;
//                cStart = nStart;
//                cEnd = nEnd;
//
//                answer++;
//            }
//        }
//
//
//        return answer;
    }
}
