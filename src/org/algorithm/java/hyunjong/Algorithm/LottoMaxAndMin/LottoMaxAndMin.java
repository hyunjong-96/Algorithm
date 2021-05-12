package org.algorithm.java.hyunjong.Algorithm.LottoMaxAndMin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMaxAndMin {
    public int[] solution(int[] lottos, int[] win_nums){
        int[] answer = new int[2];
        int zero_count=0;
        int win_count=0;
        List<Integer> knowLottoNum = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        Collections.sort(knowLottoNum);

        for(int i : lottos){
            if(i==0) zero_count++;
            if(knowLottoNum.contains(i)) win_count++;
        }

        answer[0] = rating(zero_count+win_count);
        answer[1] = rating(win_count);

        for(int j = 0;j<2;j++){
            System.out.println(answer[j]);
        }

        return answer;
    }

    private int rating(int count){
        switch (count){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default: return 6;
        }
    }
}
