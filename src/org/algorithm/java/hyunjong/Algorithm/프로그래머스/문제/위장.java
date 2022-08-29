package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.HashMap;
import java.util.Map;

/*
각 옷 종류에 따라 옷을 선택할 때 옷을 선택한다, 선택하지 않는다의 경우가 나오게 된다.
만약 한 종류의 옷이 2개가 있을때 a를 입는다. b를 입니다. 아무것도 입지않는다. 총 3가지의 종류가 나온다.
그리고 다른 종류의 옷이 3개가 있을때 c를 입는다. d를 입는다. e를 입는다. 아무것도 입지않는다. 총 4가지의 종류가 나온다.
그렇기 때문에 3*4로 총 12가 나오고 최소 하나 이상의 옷을 조합하기 때문에 1을 빼준다.
 */
public class 위장 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
	static int solution(String[][] clothes){
		Map<String, Integer> map = new HashMap<>();

		for(String[] info : clothes){
			String name = info[0];
			String type = info[1];

			map.put(type, map.getOrDefault(type, 0)+1);
		}

		int answer = 1;
		for(String type : map.keySet()){
			answer *= map.get(type) + 1;
		}

		return answer - 1;
	}
}
