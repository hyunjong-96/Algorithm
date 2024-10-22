package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {
	public static void main(String[] args) {
		int n = 2;
		int[][] result = solution(n);

		for(int[] move : result){
			System.out.println(Arrays.toString(move));
		}
	}

	static public int[][] solution(int n) {

		List<int[]> result = new ArrayList<>();
		hanoi(result, n, 1, 2, 3);

		int[][] answer = new int[result.size()][2];

		for(int i=0;i<result.size();i++){
			answer[i] = result.get(i);
		}
		return answer;
	}

	static public void hanoi(List<int[]>answer, int N, int start, int mid, int end){
		if(N==1){
			answer.add(new int[]{start, end});
			return;
		}

		hanoi(answer, N-1, start, end, mid);

		answer.add(new int[]{start,end});

		hanoi(answer, N-1, mid, start, end);
	}
}
