package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.Map;

/*
wantMap에 원하는 물건과 그 갯수를 저장
discountMap에 슬라이딩 윈도우를 이용해 해당 범위 내의 물건과 그 갯수 저장

해당 범위의 discount물건 개수와 wantMap의 개수가 동일하다면 answer +1증가를 반복
end가 discount.length -1 일때 더이상 end를 이동시키면 arrayoutbound가 발생하므로 check메서드 수행 후 바로 종료
 */
public class 할인행사 {
	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		System.out.println(solution(want, number, discount));
	}

	static int solution(String[] want, int[] number, String[] discount){
		Map<String, Integer> wantMap = new HashMap<>();
		Map<String, Integer> discountMap = new HashMap<>();

		int range = 0;
		for(int i=0;i<want.length;i++){
			String w = want[i];
			int n = number[i];
			wantMap.put(w, wantMap.getOrDefault(w,0)+n);
			range += n;
		}

		for(int i=0;i<range;i++){
			String d = discount[i];
			discountMap.put(d, discountMap.getOrDefault(d, 0)+1);
		}

		int answer = 0;
		int start = 0;
		int end = range;
		while(end<=discount.length){
			if(check(wantMap, discountMap, start, end-1)) {
				answer++;
			}
			if(end==discount.length) break;
			String s = discount[start++];
			String e = discount[end++];
			discountMap.put(s, discountMap.get(s)-1);
			discountMap.put(e, discountMap.getOrDefault(e,0)+1);
		}

		return answer;
	}

	static public boolean check(Map<String,Integer>wantMap, Map<String,Integer>discountMap, int start, int end){
		for(String want : wantMap.keySet()){
			if(!discountMap.containsKey(want) || discountMap.get(want) < wantMap.get(want)) return false;
		}
		return true;
	}
}
