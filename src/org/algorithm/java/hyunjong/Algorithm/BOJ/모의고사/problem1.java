package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class problem1 {
	public String solution(String X, String Y) {
		Map<Character, Integer> map = new HashMap<>();

		for(int i=0;i<X.length();i++){
			char c = X.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}

		List<Character> clist = new ArrayList<>();
		int zeroCount = 0;
		for(int i=0;i<Y.length();i++){
			char c = Y.charAt(i);
			if(map.containsKey(c) && map.get(c) > 0){
				clist.add(c);
				map.put(c, map.get(c)-1);
				if(c=='0') zeroCount++;
			}
		}

		StringBuilder sb = new StringBuilder();

		if(clist.size() != zeroCount){
			clist.sort(Comparator.reverseOrder());

			for(char c : clist){
				sb.append(c);
			}
		}else if(clist.size() == 0){
			sb.append("-1");
		}else{
			sb.append("0");
		}

		return sb.toString();
	}
}
