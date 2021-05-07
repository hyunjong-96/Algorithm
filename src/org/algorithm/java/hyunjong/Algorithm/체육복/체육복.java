package org.algorithm.java.hyunjong.Algorithm.체육복;

import java.util.ArrayList;
import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve){
        int[] all = new int[n];
        int answer=0;
        for(int i: reserve) all[i-1]++;
        for(int j : lost) all[j-1]--;

        for (int i = 0; i < all.length; i++)
            if (all[i] < 0)
                if (i != all.length - 1 && all[i + 1] > 0) {
                    all[i]++;
                    all[i + 1]--;
                } else if (i != 0 && all[i - 1] > 0) {
                    all[i]++;
                    all[i - 1]--;
                }
        for(int q:all){
            if(!(q<0)) answer++;
        }
        return answer;
    }
}
