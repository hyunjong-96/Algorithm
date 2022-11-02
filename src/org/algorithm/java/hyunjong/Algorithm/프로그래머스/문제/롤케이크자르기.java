package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.HashMap;
import java.util.Map;

/*
Map을 통해서 컷 부분을 나누어 왼쪽과 오른쪽의 토핑 개수를 갱신하면서 left와 right의 크기가
 동일한 경우 answer를 증가시키는 과정을 통해 해결

Map을 사용하는 방법도 있었지만, 배열을 사용하는것이 좀더 비용적으로 좋았다.
10000 크기의 left, right 배열을 만들고 모든 토핑을 right에 추가시키면서 추가시키기전 요소의 크기가 0인 경우 rightCount를 증가
그리고 모든 토핑을 left로 옮기는 과정을 수행하는데, left[i]의 요소가 0이라면 leftCount를 증가시키고 내부 요소를 증가.

이때 leftCount와 rightCount가 동일하다면 동일한 토핑 종류 수를 가지고 있는것이기 때문에 answer를 증가시켜준다.
 */
public class 롤케이크자르기 {
	public static void main(String[] args) {
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		System.out.println(solution(topping));
	}

	// static public int solution(int[] topping) {
	// 	Map<Integer,Integer> left = new HashMap<>();
	// 	Map<Integer,Integer> right = new HashMap<>();
	// 	int point = 1;
	//
	// 	left.put(topping[0],1);
	// 	for(int i=point;i<topping.length;i++){
	// 		right.put(topping[i], right.getOrDefault(topping[i],0)+1);
	// 	}
	//
	// 	int answer = 0;
	// 	for(int i=point;i<topping.length;i++){
	// 		int t = topping[i];
	// 		//왼쪽 추가
	// 		left.put(t, left.getOrDefault(t, 0)+1);
	//
	// 		//오른쪽 삭제
	// 		right.put(t, right.get(t)-1);
	// 		if(right.get(t)==0) right.remove(t);
	//
	// 		if(left.size() == right.size()) answer++;
	// 	}
	//
	// 	return answer;
	// }

	static public int solution(int[] topping) {
		int[] left = new int[10001];
		int[] right = new int[10001];
		int leftCount = 0;
		int rightCount = 0;

		for(int t : topping){
			if(right[t]==0) rightCount++;
			right[t]++;
		}

		int answer = 0;
		for(int t : topping){
			right[t]--;
			if(right[t]==0) rightCount--;

			if(left[t]==0) leftCount++;
			left[t]++;

			if(leftCount == rightCount) answer++;
		}

		return answer;
	}
}
