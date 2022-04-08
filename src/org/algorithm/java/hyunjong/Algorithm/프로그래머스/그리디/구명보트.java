package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그리디;

import java.util.Arrays;

/*
처음에 구현할때는 정렬후 limit-현재 최소 몸무게인 몸무게로가서 count하고 삭제하고 하는 식으로 또 복잡하게 풀어재껴놨다.
index의 값을 직접적으로 삭제하는 것이 아닌, index를 이동시키는 방법을 사용하면 삭제후 정렬하는 시간과 복잡도를 줄일수 있다.
문제의 핵심은 min과 max이다. min은 현재 people에서 가장작은 몸무게, max는 현재 people에서 가장큰 몸무게를 가리키는 index이다.
people을 정렬하고 min=0, max = people.length로 초기화 시킨다음 min과 max의 값을 비교해서 limit를 넘어가면 max값을 가지는 사람 한명만 보트를 타고 갈수있는것.
그러므로 count를 해주고 max을 -1해준다.(요소 자체를 삭제하는것이 아닌 index를 옮겨준다고 했다).
그리고 min+max값이 limit값보다 작거나 같다면 min++, max--을 해주고 count해준다.
반복문을 다 도는데 만약 min==max로 끝났다면 혼자 탈출할수 있도록 count를 해주면 끝.
 */
public class 구명보트 {
	public static void main(String[] args) {
		int[] people = {70,50,80,50};
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	static int solution(int[] people, int limit){
		int answer = 0;
		int min=0;
		int max=people.length-1;
		Arrays.sort(people);
		while(min<max){
			if(people[min]+people[max]<=limit){
				min++;
				max--;
			}else{
				max--;
			}
			answer++;
		}
		if(min==max) answer++;

		return answer;
	}
}
