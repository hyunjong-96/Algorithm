package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.HashSet;
import java.util.Set;

/*
union find로 문제를 구현하면 마지막 union이 모두 루트 노드를 가리키지 않는 경우가 있다.
예를 들어 union = {0,0,2,2} 로 되어있을 때 마지막 union메소드가 union(0,3)이 되게되면
최종 union은 {0,0,0,2}가 되고 Set에 넣게 되면 2개가 된다.
하지만 union[3]도 같은 네트워크에 연결되어있기 때문에 정답은 1이 되어야한다.

그렇기 때문에 최종 union을 구한 뒤 각 노드를 루트 노드를 가리키도록 갱신시켜야한다.
find의 union을 압축하는 식을 이용하여 루트 노드로 최종 갱신하면 될것같다.
 */
public class 네트워크 {
	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		solution(n,computers);
	}

	static int[] union;
	static int solution(int n, int[][] computers){
		union = new int[n];
		for(int i=0;i<n;i++){
			union[i] = i;
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i!=j && computers[i][j]==1){
					union(i,j);
				}
			}
		}

		for(int i=0;i<n;i++){
			find(i);
		}

		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++){
			set.add(union[i]);
		}
		return set.size();
	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);

		if(a>b){
			union[a] = b;
		}else{
			union[b] = a;
		}
	}

	static int find(int a){
		if(union[a] == a) return a;
		return union[a] = find(union[a]);
	}
}
