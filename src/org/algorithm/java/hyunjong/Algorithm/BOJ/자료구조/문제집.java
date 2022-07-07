package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 문제집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//각 문제의 나중에 풀어야할 문제
		List<List<Integer>> solve = new ArrayList<>();
		//선행되어야할 문제 개수
		int[] indegree = new int[N+1];

		for(int i=0;i<=N;i++){
			solve.add(new ArrayList<>());
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			solve.get(first).add(last);
			indegree[last]++;
		}

		Queue<Integer> result = topologicalSort(solve, indegree);

		//result에 저장된 문제는 저장된 순서에 따라 조건을 만족하는 문제 풀이 순서이다.
		StringBuilder sb = new StringBuilder();
		while(!result.isEmpty()){
			sb.append(result.poll()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	//위상정렬
	static Queue<Integer> topologicalSort(List<List<Integer>> solve, int[] indegree){
		//indegree가 0인 문제를 저장
		//먼저 풀어야할 문제가 0개일 때 값이 작은 순서부터 풀어야하기 떄문에 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//3가지 조건을 만족하는 문제를 순서대로 저장
		Queue<Integer> result = new LinkedList<>();

		//indegree가 0인 문제를 먼저 pq에 초기화한다.
		for(int i=1;i<indegree.length;i++){
			if(indegree[i] == 0){
				pq.offer(i);
			}
		}

		while(!pq.isEmpty()){
			//indegree가 0인 문제
			int currentNode = pq.poll();

			//문제 풀이 순서에 저장
			result.offer(currentNode);

			//현재 문제가 선행되었어야 풀수 있는 문제 리스트
			for(Integer last : solve.get(currentNode)){
				//last의 선행 문제가 풀렸으므로 indegree[last]의 개수를 감소시킨다.
				if(indegree[last] != 0){
					indegree[last]--;
				}

				//last의 선행 문제 개수가 0이라면 해당문제(last)를 풀수 있으므로 pq에 저장한다.
				if(indegree[last] == 0) pq.offer(last);
			}
		}

		return result;
	}
}
