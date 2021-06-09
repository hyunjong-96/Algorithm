package org.algorithm.java.hyunjong.Algorithm.CenterWord;

public class CenterWord {
	public String solution(String s){
		String answer = "";
		String[] arr = s.split("");
		int arrLength = arr.length;
		if(arrLength%2 == 0){
			answer+=arr[(arrLength/2)-1];
			answer+=arr[(arrLength/2)];
		}else{
			answer+=arr[arrLength/2];
		}
		return answer;
	}
}
