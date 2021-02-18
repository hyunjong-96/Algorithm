package org.algorithm.java.hyunjong.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 두개더뽑아서더하기 {
    public int[] solution(int[] numbers){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                int sum = numbers[i]+numbers[j];
                if(list.indexOf(sum)<0){
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
//        Arrays.sort(answer);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        return answer;
    }
}
