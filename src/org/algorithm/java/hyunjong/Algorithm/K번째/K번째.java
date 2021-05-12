package org.algorithm.java.hyunjong.Algorithm.K번째;

import java.util.ArrayList;
import java.util.Collections;

public class K번째 {
    public int[] solution(int[] array, int[][] commands){
        int[] answer=new int[commands.length];
        for(int q=0;q< commands.length;q++){
            ArrayList<Integer> sortList = new ArrayList();
            int i = commands[q][0];
            int j = commands[q][1];
            int k = commands[q][2];

            for(int p=i-1;p<j;p++){
                sortList.add(array[p]);
            }
            Collections.sort(sortList);

            answer[q] = sortList.get(k-1);
        }

        return answer;
    }
}
