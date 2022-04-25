package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.LinkedList;

public class 캐시1차 {
	public static void main(String[] args) {
		int cacheSize = 0;
		String[] cities = 	{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize, cities));
	}

	static int solution(int cacheSize, String[] cities){
		LinkedList<String> caches = new LinkedList<>();

		int answer = 0;
		if(cacheSize>0){
			for(String c : cities){
				c = c.toLowerCase();
				if(caches.contains(c)){
					answer += 1;
					caches.remove(c);
					caches.add(c);
				}else{
					answer += 5;
					if(caches.size()==cacheSize){
						caches.removeFirst();
					}
					caches.add(c);
				}
			}
		}else{
			answer = 5*cities.length;
		}

		return answer;
	}
}
