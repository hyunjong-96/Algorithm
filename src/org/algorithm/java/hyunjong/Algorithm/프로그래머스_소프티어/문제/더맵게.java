package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.PriorityQueue;

/*
내가 실수한 부분은 맵기를 구하는 식에서 while의 조건에 sum < K으로 설정.
그렇게 되면 pq에 아직 K보다 덜매운게 있어도 sum이 K보다 크게 된다면 실패되기 떄문이다.
 */
public class 더맵게 {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	static int solution(int[] scoville, int K){
		PriorityQueue<Long> pq = new PriorityQueue<>();

		/*
		주어진 맵기를 pq에 저장한다.
		 */
		for(int i=0;i<scoville.length;i++){
			pq.offer((long)scoville[i]);
		}

		int answer = 0;
		long sum = 0;
		/*
		맵기가 식을 구하기 위한 2개를 가지고 있고 가장 안매운 음식이 K보다 작다면
		모든 맵기를 K이상으로 만들기 위해 실행
		 */
		while(pq.size() >=2 && pq.peek() < K){
			sum = pq.poll();
			sum += pq.poll()*2;
			pq.offer(sum);
			answer++;
		}

		/*
		while문이 끝나는 경우는 모든 맵기 탐색을 끝냈거나 모든 맵기가 K이상인 경우이다.
		만약 최근에 구한 맵기(sum)가 K보다 작은데 while이 끝났다면 K이상의 맵기를 만들수 없다는 것.
		*/
		if(sum < K) answer = -1;
		return answer;
	}
}
