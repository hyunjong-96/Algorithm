package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그리디;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public static void main(String[] args) {
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(routes);
	}

	static public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				int result = o1[0]-o2[0];
				if(result == 0) result = o1[1]-o2[1];
				return result;
			}
		});

		int answer = 1;
		int cameraPos = routes[0][1];

		for(int i=1;i<routes.length;i++){
			if(cameraPos < routes[i][0]){
				cameraPos = routes[i][1];
				answer++;
			}
		}
		return answer;
	}
}
