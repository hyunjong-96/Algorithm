package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

public class 두원사이의정수쌍 {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        System.out.print(solution(r1,r2));
    }
        static public long solution(int r1, int r2) {
            long answer = 0;

            for(int x=1;x<=r2;x++){
                int y2 = (int)(Math.sqrt(Math.pow(r2,2) - Math.pow(x,2)));
                int y1 = (int)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(x,2)));

                answer += (y2-y1)+1;
            }

            answer *= 4;

            return answer;
        }
}
