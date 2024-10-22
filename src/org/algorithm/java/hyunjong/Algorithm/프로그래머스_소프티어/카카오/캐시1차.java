package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.LinkedList;

/*
캐시 알고리즘을 Least Recently User 알고리즘을 사용한다고 했으니
최근에 사용된 데이터가 가장 나중에 삭제되게한다.
LinkedList<String> cache를 사용하여 cache에 해당 데이터가 없다면 cache의 제일 앞 부분(사용한지 오래된) 데이터를 삭제해준다.
이때 데이터를 삭제할땐 캐시가 cacheSize만큼 차 있어야 한다.
그리고 cache의 맨 뒤에 해당 데이터를 추가해주고 (삽입, 삭제가 빈번하기 떄문에 linkedList사용) answer += 5.
cache에 데이터가 있다면 해당 데이터를 cache에서 삭제해주고 맨 뒤에 다시 추가해준다. answer += 1;
cachesize가 0일때는 모든 데이터가 cache miss이므로 모든 데이터에 5를 넣어서 반환.
 */
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
