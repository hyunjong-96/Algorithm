package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

public class 퍼즐게임챌린지 {
    public static void main(String[] args) {
        int[] diffs = new int[]{1, 99999, 100000, 99995};
        int[] times = new int[]{9999, 9001, 9999, 9001};
        long limit = 3456789012L;

        System.out.println(solution(diffs, times, limit));
    }

    static int[] DIFFS;
    static int[] TIMES;
    static long LIMIT;
    static int LEN;

    public static int solution(int[] diffs, int[] times, long limit) {
        DIFFS = diffs;
        TIMES = times;
        LIMIT = limit;
        LEN = diffs.length;

        int start = 1;
        int end = 100000;

        int answer = binarySearch(start, end);
        return answer;
    }

    public static int binarySearch(int start, int end) {
        if(start == end) {
            return end;
        }

        int mid = (start+end)/2;

        long t = playPuzzle(mid);

        if(t<=LIMIT) {
            end = mid;
        }
        else {
            start = mid+1;
        }

        return binarySearch(start, end);
    }

    public static long playPuzzle(int level) {
        long time_total = 0;

        for(int i=0;i<LEN;i++){
            int diff = DIFFS[i];
            int time_current = TIMES[i];
            int time_prev = i==0 ? 0 : TIMES[i-1];

            if(diff <= level) {
                time_total += time_current;
            }
            else {
                time_total += (time_current+time_prev)*(diff-level) + time_current;
            }
        }

        return time_total;
    }
}
