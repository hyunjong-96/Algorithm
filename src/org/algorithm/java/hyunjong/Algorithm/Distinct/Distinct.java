package org.algorithm.java.hyunjong.Algorithm.Distinct;

import java.util.ArrayList;
import java.util.List;

public class Distinct {
	public int[] solution(int []arr){
		List<Integer> distinctArr = new ArrayList<>();
		int preNum = 10;
		for(int num : arr){
			if(preNum != num){
				distinctArr.add(num);
			}
			preNum = num;
		}
		int[] answer = new int[distinctArr.size()];
		for(int i =0;i< distinctArr.size();i++){
			answer[i] = distinctArr.get(i);
		}
		return answer;
	}
}
