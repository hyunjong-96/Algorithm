package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		System.out.println(solution(n,times));
	}

	static long solution(int n, int[] times){
		/*
		심사를 오름차순으로 정렬한다.
		 */
		Arrays.sort(times);
		long max = times[times.length-1];

		long start = 1;
		// 심사 시간이 가장 오래 걸리는 경우
		long end = max*n;
		//심사 시간이 가장 오래 걸리는 경우가 10억*10억이기 때문에 long
		long min = Long.MAX_VALUE;
		while(start<=end){
			long mid = (start+end)/2;

			/*
			심사 시간을 돌면서 임의 시간에 대해 심사 받을 수 있는 인원 수를 구한다.

			비어있는 심사대에 가거나 더 빨리 끝나는 심사대로 이동한다는 뜻은
			특정 임의 시간에서 mid/times[i]의 합이 n의 인원 수와 딱 맞아 떨어지는 경우를 말하는 것 같다.

			예를 들어 n=6, times={7,10}일때 임의 시간이 28이라면 28/7=4, 28/10=2 로 위의 설명으로 심사했을때
			딱 맞아떨어지는 경우이다.
			 */
			long sum = 0;
			for(int i=0;i<times.length;i++){
				sum += mid/times[i];
			}

			/*
			만약 임의 시간안에 검사를 받은 총 인원의 수가 n보다 작다면 임의 최소 시간을 늘려준다

			검사 받은 총 인원수가 n보다 크거나 같다면 최소 시간이 될수 있는 후보이기 때문에
			min에 해당 임의 값을 갱신하고 임의 최소 시간을 줄인다.
			 */
			if(sum < n){
				start = mid+1;
			}else{
				end = mid-1;
				min = mid;
			}
		}

		return min;
	}
}
