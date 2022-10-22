package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 줄서는방법 {
	public static void main(String[] args) {
		int n = 3;
		int k = 5;
		int[] result = solution(n,k);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int n, long k){
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i=1;i<=n;i++){
			ll.add(i);
		}

		int[] answer = new int[n];
		int idx = 0;
		k--;
		while(ll.size() != 0){
			int total = factorial(ll.size());
			int block = getBlock(total, ll.size());
			int index = getIndex(k, block);
			answer[idx++] = ll.remove(index);
			k = nextK(k,block);
		}

		return answer;
	}

	public static int factorial(int n){
		int result = n;
		while(n!=1){
			result *= --n;
		}
		return result;
	}

	public static int getBlock(int total, int range){
		return total/range;
	}

	public static int getIndex(long k, int block){
		return (int)(k/block);
	}

	public static long nextK(long k, int block){
		return k%block;
	}
}
