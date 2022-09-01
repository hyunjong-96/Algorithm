package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
정렬되는 뎈을 만드는 문제.
linkedList를 사용하거나 PQ를 사용해서 만들수 있다.
LinkedList를 사용할때는 I 함수가 나왔을때는 LinkedList에 저장하고 정렬해준다.
	최대값 삭제시에는 ll의 맨 뒤에있는 값을 삭제하고, 최소값 삭제시에는 ll의 맨 앞에 있는 값을 삭제한다.
PQ 사용할때는 I 함수가 나왔을때 maxPQ와 minPQ에 저장한다.
	최대값 삭제시 maxPQ에서 값을 꺼내와 해당 값을 minPQ에서도 삭제
	최소값 삭제시 minPQ에서 값을 꺼내와 해당 값을 maxPQ에서도 삭제
 */
public class 이중우선순위큐 {
	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result = solution(operations);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	static int[] solution(String[] operations){
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();

		for(String op : operations){
			String[] o = op.split(" ");
			String method = o[0];
			int num = Integer.parseInt(o[1]);

			if(method.equals("I")){
				maxPQ.offer(num);
				minPQ.offer(num);
			}else{
				if(maxPQ.isEmpty()) continue;

				if(num == 1){
					int max = maxPQ.poll();
					minPQ.remove(max);
				}else{
					int min = minPQ.poll();
					maxPQ.remove(min);
				}
			}
		}

		int[] answer = {0,0};
		if(!maxPQ.isEmpty()){
			answer[0] = maxPQ.poll();
			answer[1] = minPQ.poll();
		}

		return answer;

		//linkedlist 풀이
		// LinkedList<Integer> ll = new LinkedList<>();
		// for(String op : operations){
		// 	String[] o = op.split(" ");
		// 	String method = o[0];
		// 	int num = Integer.parseInt(o[1]);
		//
		// 	if(method.equals("I")){
		// 		ll.offer(num);
		// 		Collections.sort(ll);
		// 	}else{
		// 		if(num == 1 && ll.size()>0){
		// 			ll.removeLast();
		// 		}else if(num == -1 && ll.size()>0){
		// 			ll.removeFirst();
		// 		}
		// 	}
		// }
		//
		// int[] answer = {0,0};
		// if(!ll.isEmpty()){
		// 	answer[0] = ll.getLast();
		// 	answer[1] = ll.getFirst();
		// }
		//
		// return answer;
	}
}
