package org.algorithm.java.hyunjong.Algorithm.year2016;

public class year2016 {
    public String solution(int a, int b){
        String[] answer={"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30};
        for(int i=0;i<a;i++){
            b+=month[i];
        }
        return answer[b%7];
    }
}
