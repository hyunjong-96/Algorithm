package org.algorithm.java.hyunjong.Algorithm.StringBasic;

public class StringBasic {
	public boolean solution(String s) {

		if(s.length() != 4 && s.length() != 6) return false;

		String[] convertArray = s.split("");

		try{
			for(String c : convertArray){
				Integer.parseInt(c);
			}
		}catch(Exception e){
			return false;
		}

		return true;
	}
}
