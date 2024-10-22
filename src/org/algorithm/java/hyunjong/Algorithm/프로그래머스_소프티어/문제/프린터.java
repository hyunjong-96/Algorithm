package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Queue에 프린터 우선순위를 저장
PQ에 우선순위 내림차순으로 저장

Queue에서 문서를 하나 빼서 우선순위가 가장 큰값보다 우선순위가 낮다면 Queue에 다시 넣어 맨 뒤에 넣는다.
만약 문서의 우선순위가 가장 큰 우선순위보다 크거나 같다면 해당 문서는 인쇄되는 것이다.
이때 location이 0이라면 내가 뽑고자하는 문서이기 때문에 반복문을 종료한다.

맨앞의 문서를 비교하고나서 가장 큰 우선순위가 아니여서 맨뒤로 가거나 가장 큰 우선순위여서 인쇄가 될때도
location은 앞으로 한칸씩 떙겨지기 때문에 모든 반복에는 location의 위치를 왼쪽으로 한칸씩 이동시켜줘야한다.
맨 앞에서 비교했을때 가장큰 우선순위가아니라면 맨뒤로 가기때문에 (location-1+queue.size())%queue.size()로 갱신시켜준다.
 */
public class 프린터 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities,location));
	}

	static int solution(int[] priorities, int location){
		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o2-o1);
		for(int i=0;i<priorities.length;i++){
			queue.offer(priorities[i]);
			pq.offer(priorities[i]);
		}

		int answer = 0;
		while(!pq.isEmpty()){
			int document = queue.poll();

			if(pq.peek() > document){
				queue.offer(document);
			}else{
				answer++;
				pq.poll();
				if(location == 0) break;
			}
			location = (location-1+queue.size())%queue.size();
		}

		return answer;
	}
}
