package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
야근 지수의 최소값을 구하기 위해서는 남은 야근 수를 최소화 시켜야한다.
그렇기 때문에 야근 값을 PriorityQueue에 담에서 가장 많이 남은 작업량을 1개씩 빼주어야 한다.
이 때, 이대로 수행한다면 pq의 작업이 음수가 될 수 있다. 이런 경우 모든 작업량보다 n이 크거나 같은 경우 발생할 수 있는데
	이러한 경우를 대비하기 위해 works의 모든 값과 n을 비교하여 해당 경우를 제외한다.
그리고 PQ에 들어있는 모든 값에 제곱하여 더해서 반환해준다.
 */
public class 야근지수 {
	public static void main(String[] args) {
		int[] works = {4, 3, 3};
		int n = 4;
		System.out.println(solution(n, works));
	}

	static public long solution(int n, int[] works){
		int totalWorks = 0;
		for(int work : works){
			totalWorks += work;
		}

		long answer = 0;
		if(totalWorks > n){
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			for(int work : works){
				pq.offer(work);
			}

			while(n-- > 0){
				int largestWork = pq.poll();
				pq.offer(largestWork-1);
			}

			while(!pq.isEmpty()){
				answer += Math.pow(pq.poll(),2);
			}
		}
		return answer;
	}
}
