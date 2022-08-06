package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class problem2_2차 {
	public static void main(String[] args) {
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

		System.out.println(solution(topping));
	}

	static int solution(int[] topping) {
		Set<Integer> set1 = new HashSet<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		Set<Integer> set2 = new HashSet<>();

		set1.add(topping[0]);
		for(int i=1;i<topping.length;i++){
			if(map2.containsKey(topping[i])){
				map2.put(topping[i],map2.get(topping[i])+1);
			}else{
				map2.put(topping[i],1);
			}
			set2.add(topping[i]);
		}

		int answer = 0;
		for(int i=1;i<topping.length;i++){
			set1.add(topping[i]);

			map2.put(topping[i],map2.get(topping[i])-1);
			if(map2.get(topping[i]) == 0) set2.remove(topping[i]);

			if(set1.size() == set2.size()) answer++;
		}


		return answer;
	}
}
