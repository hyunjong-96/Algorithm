package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1,30,5};
		int[] result = solution(progresses, speeds);

		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

	static int[] solution(int[] progresses, int[] speeds){
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<progresses.length;i++){
			int rest = (100-progresses[i])/speeds[i];
			if((100-progresses[i]) % speeds[i] != 0) rest+=1;
			queue.offer(rest);
		}

		List<Integer> answers = new ArrayList<>();
		while(!queue.isEmpty()){
			int finishDay = queue.poll();
			int count = 1;

			while(!queue.isEmpty() && queue.peek() <= finishDay){
				queue.poll();
				count++;
			}

			answers.add(count);
		}

		int[] answer = answers.stream().mapToInt(Integer::new).toArray();
		return answer;
	}
}
