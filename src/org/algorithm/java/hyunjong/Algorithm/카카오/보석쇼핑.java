package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 보석쇼핑 {
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] result = solution(gems);
		for (int r : result) {
			System.out.println(r);
		}
	}

	static public int[] solution(String[] gems) {
		HashSet<String> gemSet = new HashSet<>();
		HashMap<String,Integer> gemMap = new HashMap<>();
		Queue<String> gemQueue = new LinkedList<>();
		//보석 이름 초기화
		for(String gem : gems){
			gemSet.add(gem);
		}

		int start=0;
		int end=gems.length-1;
		int startPoint = 0;
		int distance = end-start;
		for(int g = 0;g<gems.length;g++){
			gemMap.put(gems[g], gemMap.getOrDefault(gems[g],0)+1);
			gemQueue.offer(gems[g]);
			while(true){
				if(gemMap.get(gemQueue.peek()) > 1){
					gemMap.put(gemQueue.peek(), gemMap.get(gemQueue.peek())-1);
					gemQueue.poll();
					startPoint++;
				}else{
					break;
				}
			}

			if(gemMap.size() == gemSet.size() && distance>gemQueue.size()){
				distance = gemQueue.size();
				start = startPoint;
				end = g;
			}
		}

		return new int[]{start+1,end+1};
	}
}
