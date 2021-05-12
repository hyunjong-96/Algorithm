package org.algorithm.java.hyunjong.Algorithm.폰켓;

import java.util.ArrayList;
import java.util.List;

public class 폰켓몬 {
    public int solution(int[] nums){
        int answer=0;
        int monsterCount = (nums.length)/2;
        List<Integer> distinctMonster = new ArrayList<>();

        for(int monster : nums){
            if(!distinctMonster.contains(monster)){
                distinctMonster.add(monster);
            }
        }

        if(distinctMonster.size()>monsterCount) answer=monsterCount;
        else if(distinctMonster.size()<monsterCount) answer= distinctMonster.size();
        else answer=monsterCount;

        return answer;
    }
}
