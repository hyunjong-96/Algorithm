package org.algorithm.java.hyunjong.Algorithm.프로그래머스.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 프로그래머스K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		for(int n : solution(array,commands)){
			System.out.println(n);
		}
	}

	static public int[] solution(int[] array, int[][] commands) {
		int commendCount = commands.length;
		int[] answer = new int[commendCount];
		for(int c = 0;c<commendCount;c++){
			int[] command = commands[c];
			int i = command[0];
			int j = command[1];
			int k = command[2];
			List<Integer> sub = new ArrayList<>();
			for(int l = i-1;l<j;l++){
				sub.add(array[l]);
			}
			Collections.sort(sub);
			Integer[] test = sub.toArray(new Integer[0]);
			answer[c] = test[k-1];
		}

		return answer;
	}
}
