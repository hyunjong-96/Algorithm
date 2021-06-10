package org.algorithm.java.hyunjong.Algorithm.StringSorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSorted {
	public String[] solution(String[] strings, int n){
		String[] answer = new String[strings.length];
		List<String> arr = new ArrayList<>();
		for(int i=0;i< strings.length;i++){
			arr.add(strings[i].charAt(n)+strings[i]);
		}
		Collections.sort(arr);
		for(int j=0;j<arr.size();j++){
			answer[j] = arr.get(j).substring(1);
		}

		return answer;
	}
}
