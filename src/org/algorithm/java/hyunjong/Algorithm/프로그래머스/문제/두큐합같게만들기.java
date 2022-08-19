package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
	public static void main(String[] args) {
		int[] queue1 = {1,1};
		int[] queue2 = {1,5};
		System.out.println(solution(queue1, queue2));
	}

	static int solution(int[] queue1, int[] queue2){
		long queue1Sum = 0;
		long queue2Sum = 0;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for(int i=0;i<queue1.length;i++){
			q1.offer(queue1[i]);
			queue1Sum += queue1[i];
		}
		for(int i=0;i<queue2.length;i++){
			q2.offer(queue2[i]);
			queue2Sum += queue2[i];
		}

		int limit = queue1.length* 2 +queue2.length*2;
		long target = (queue1Sum + queue2Sum)/2;

		int count = 0;
		while(queue1Sum != target && queue2Sum != target){
			if(count > limit) return -1;

			if(queue1Sum > queue2Sum){
				int q = q1.poll();
				q2.offer(q);

				queue2Sum += q;
				queue1Sum -= q;
			}else{
				int q = q2.poll();
				q1.offer(q);

				queue1Sum += q;
				queue2Sum -= q;
			}
			count++;
		}

		return count;
	}
}
