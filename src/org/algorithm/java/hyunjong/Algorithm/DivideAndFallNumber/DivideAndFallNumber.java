package org.algorithm.java.hyunjong.Algorithm.DivideAndFallNumber;

import java.util.ArrayList;
import java.util.List;

public class DivideAndFallNumber {
	public int[] solution(int[] arr,int divisor){
		List<Integer> divideAndFallNumber = new ArrayList<>();
		for(int i : arr){
			if(i%divisor == 0){
				divideAndFallNumber.add(i);
			}
		}
		divideAndFallNumber.sort(null);
		if(divideAndFallNumber.size() == 0){
			divideAndFallNumber.add(-1);
		}
		int[] answer = new int[divideAndFallNumber.size()];
		for(int j=0;j<divideAndFallNumber.size();j++){
			answer[j] = divideAndFallNumber.get(j);
		}
		return answer;
	}
}
