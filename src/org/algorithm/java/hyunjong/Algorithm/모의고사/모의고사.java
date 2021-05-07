package org.algorithm.java.hyunjong.Algorithm.모의고사;

import java.util.*;
import java.util.stream.Collectors;

public class 모의고사 {
    public int[] solution(int[] answers){
        int[] answer = {};
        List<Integer> maxStudent = new ArrayList<>();
        int[] firstStudent = {1,2,3,4,5};
        int[] secondStudent = {2,1,2,3,2,4,2,5};
        int[] thirdStudent = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt={0,0,0};

        List<Integer> arr1 = Arrays.stream(thirdStudent).boxed().collect(Collectors.toList());
        Collections.sort(arr1, Comparator.reverseOrder());  //array -> List

        for(int i =0;i<answers.length;i++){
            if(answers[i]==(firstStudent[i%5])) cnt[0]++;
            if(answers[i]==(secondStudent[i%8])) cnt[1]++;
            if(answers[i]==(thirdStudent[i%10])) cnt[2]++;
        }

        maxStudent = getMostStudent(cnt,maxStudent);
        answer=new int[maxStudent.size()];
        for(int i =0;i<maxStudent.size();i++){
            answer[i]=maxStudent.get(i);
        }
        return answer;
    }
    private List<Integer> getMostStudent(int[] cnt, List<Integer> maxStudent){
        int max = Math.max(Math.max(cnt[0],cnt[1]),cnt[2]);
        if(max == cnt[0]) maxStudent.add(1);
        if(max == cnt[1]) maxStudent.add(2);
        if(max == cnt[2]) maxStudent.add(3);
        Collections.sort(maxStudent);
        return maxStudent;
    }
}
