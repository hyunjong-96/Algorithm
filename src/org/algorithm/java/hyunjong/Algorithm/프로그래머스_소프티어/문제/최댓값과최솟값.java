package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최댓값과최솟값 {
	public static void main(String[] args) {
		String s = "-4 -2 -3 -1";
		System.out.println(solution(s));
	}

	static String solution(String s){
		String[] arr = s.split(" ");
		List<Integer> list = new ArrayList<>();
		for(String a : arr){
			list.add(Integer.parseInt(a));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Collections.min(list));
		sb.append(" ");
		sb.append(Collections.max(list));

		return sb.toString();
	}
}
