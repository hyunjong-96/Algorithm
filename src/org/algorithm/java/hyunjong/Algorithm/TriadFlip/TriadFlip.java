package org.algorithm.java.hyunjong.Algorithm.TriadFlip;

import java.util.ArrayList;

public class TriadFlip {
    public int solution(int n){
        int answer=0;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(true){
            if(n<3) {tmp.add(n); break;}
            tmp.add(n%3);
            n = n/3;
        }
        int tmpSize = tmp.size();
        for(int i=0;i<tmpSize;i++){
            answer+=tmp.get(i)*Math.pow(3,Math.abs(i-(tmpSize-1)));
        }
        return answer;
    }
}
