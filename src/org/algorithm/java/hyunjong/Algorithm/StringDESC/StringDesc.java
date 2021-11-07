package org.algorithm.java.hyunjong.Algorithm.StringDESC;

import java.util.Arrays;
import java.util.Collections;

public class StringDesc {
	public String solution(String s){

		String[] convertArray = s.split("");
		Arrays.sort(convertArray, Collections.reverseOrder());

		for(String i : convertArray){
			System.out.println(i);
		}

		StringBuilder builder = new StringBuilder();
		for(String c : convertArray){
			builder.append(c);
		}
		return builder.toString();
	}
}
