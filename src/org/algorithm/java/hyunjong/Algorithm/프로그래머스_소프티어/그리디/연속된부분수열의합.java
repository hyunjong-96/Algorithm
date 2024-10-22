package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그리디;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;

        int[] result = solution(sequence, k);
        for(int r : result) {
            System.out.print(r+" ");
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int index1=0;
        int index2=0;

        int start=0;
        int end=0;
        int sum=sequence[0];
        int len = 1000001;

        while(end<sequence.length) {
            if(sum<=k) {
                if(sum == k && len > (end-start+1)){
                    index1 = start;
                    index2 = end;
                    len = end-start+1;
                }
                end++;

                if(end < sequence.length) {
                    sum += sequence[end];
                }
            }
            else {
                sum -= sequence[start++];
            }
        }

        int[] answer = {index1, index2};
        return answer;
    }
}
