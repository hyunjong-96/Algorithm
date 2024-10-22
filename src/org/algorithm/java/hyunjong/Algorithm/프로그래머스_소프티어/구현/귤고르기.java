package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 귤고르기 {
	public static void main(String[] args) {

	}

	public int solution(int k, int[] tangerine) {
		int[] tangerineCount = new int[10000001];
		for(int t : tangerine){
			tangerineCount[t]++;
		}

		List<Tangerine> tangerineList = new ArrayList<>();
		for(int i=1;i<10000001;i++){
			if(tangerineCount[i] != 0){
				tangerineList.add(new Tangerine(i,tangerineCount[i]));
			}
		}

		Collections.sort(tangerineList, (Tangerine o1, Tangerine o2)->{
			return o2.count - o1.count;
		});

		int answer = 0;
		int idx=0;
		while(k>0){
			k -= tangerineList.get(idx++).count;
			answer++;
		}
		return answer;
	}

	class Tangerine{
		int size;
		int count;
		public Tangerine(int size, int count){
			this.size = size;
			this.count = count;
		}
	}
}
