package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
디스크에 시작 요청 기준으로 요청값을 정렬한다.
그리고 PQ에는 작업이 끝난시점으로부터 이전이나 해당 시점에 시작 요청을 하는 작업을 저장한다.
(작업이 끝난시점보다 늦은 시점의 작업을 수행하면 작업이 끝난시점 이전에 요청한 작업들이 밀리게 된다)

작업이 끝난시점 end 이전이나 해당 시점에 시작 요청을한 작업 들 중 가장 작업 처리시간이 빠른 작업을 선택한다.
(작업 처리시간이 가장 짧을 수록 시작 요청시간에 상관없이 end시간이 짧아지기 때문에
다음 pq에 있는 값이 최대한 작은 end에서 작업 종료까지 걸린 시간을 구할 수 있다.)

pq가 비어있다면 해당 end보다 이전에 시작 요청을 한 작업이 없는 것이기 때문에 다음 작업의 시작 시간을 jobs에서 가져와
해당 jobs도 포함되어 처리완료 시간을 계산하게 된다.

pq가 비어있지 않다면 시작요청시간부터 종료시간까지의 처리시간을 구하고 작업 완료 시간 end를 갱신하고 count도 갱신한다.

count가 jobs.length만큼 수행되었다면 모든 작업을 수행한것이기 때문에

모든 처리시간을 저장한 answer를 jobs.length로 나누어 반환한다.
 */
public class 디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}

	static int solution(int[][] jobs) {
		//시작 요청 시간 기준 오름차순
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int answer = 0;
		int end = 0;
		int jobIndex = 0;
		int count = 0;

		while (count < jobs.length) {

			while (jobIndex < jobs.length && jobs[jobIndex][0] <= end) {
				pq.offer(jobs[jobIndex++]);
			}

			if (pq.isEmpty()) {
				end = jobs[jobIndex][0];
			} else {
				int[] currentJob = pq.poll();
				int startRequestTime = currentJob[0];
				int latency = currentJob[1];

				int totalTime = end + latency - startRequestTime;
				end += latency;
				count++;
				answer += totalTime;
			}
		}

		return answer/jobs.length;
	}
}
