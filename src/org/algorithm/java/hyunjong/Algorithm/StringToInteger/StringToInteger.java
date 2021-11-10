package org.algorithm.java.hyunjong.Algorithm.StringToInteger;

public class StringToInteger {
	public int solution(String s){
		String[] stringArray = s.split("-");
		boolean isMinus = s.contains("-");

		StringBuilder toString = new StringBuilder();
		for(String c : stringArray){
			toString.append(c);
		}

		int answer = Integer.parseInt(toString.toString());
		if(isMinus) answer = answer*-1;

		return answer;
	}
}
