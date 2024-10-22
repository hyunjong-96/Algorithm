package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class 인사고과 {
	public static void main(String[] args) {
		int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
		int result = solution(scores);
		System.out.println(result);
	}

	static public int solution(int[][] scores) {
		List<Worker> list = new ArrayList<>();
		for(int i=0;i<scores.length;i++){
			list.add(new Worker(i, scores[i][0], scores[i][1]));
		}
		Collections.sort(list);

		int targetSum = scores[0][0]+scores[0][1];
		int maxCoworker = 0;
		int rank = 1;
		for(Worker worker : list){
			if(worker.coworker < maxCoworker){
				if(worker.id == 0) return -1;
			}else{
				maxCoworker = Math.max(maxCoworker, worker.coworker);
				if(worker.attention + worker.coworker > targetSum) rank++;
			}
		}

		return rank;
	}

	static class Worker implements Comparable<Worker> {
		int id;
		int attention;
		int coworker;

		public Worker( int id, int attention, int coworker){
			this.id = id;
			this.attention = attention;
			this.coworker = coworker;
		}

		@Override
		public int compareTo (Worker o1){
			int result = o1.attention-this.attention;
			if(result == 0) result = this.coworker - o1.coworker;

			return result;
		}
	}

	// static public int solution(int[][] scores) {
	// 	PriorityQueue<Worker> pq = new PriorityQueue<>();
	// 	int N = scores.length;
	// 	for (int i = 0; i < N; i++) {
	// 		pq.offer(new Worker(i, scores[i][0], scores[i][1]));
	// 	}
	//
	// 	int[] ranking = new int[N];
	// 	Worker firstWorker = pq.poll();
	// 	int attentionMax_attention = firstWorker.attention;
	// 	int attentionMax_coworker = firstWorker.coworker;
	// 	int coworkerMax_attention = firstWorker.attention;
	// 	int coworkerMax_coworker = firstWorker.coworker;
	// 	int rank = 1;
	// 	int tmpRank = 1;
	// 	int prevSum = firstWorker.attention + firstWorker.coworker;
	// 	ranking[firstWorker.id] = rank;
	// 	while (!pq.isEmpty()) {
	// 		Worker current = pq.poll();
	//
	//
	// 		boolean canGetIncentive = true;
	// 		//해당 사원은 인센못받음
	// 		//랭킹에도 안들어감
	// 		if ((attentionMax_attention > current.attention && attentionMax_coworker > current.coworker) || (
	// 			coworkerMax_attention > current.attention && coworkerMax_coworker > current.coworker)) {
	// 			canGetIncentive = false;
	// 		}
	//
	// 		if (attentionMax_attention < current.attention) {
	// 			attentionMax_attention = current.attention;
	// 			attentionMax_coworker = current.coworker;
	// 		}
	//
	// 		if (coworkerMax_coworker < current.coworker) {
	// 			coworkerMax_attention = current.attention;
	// 			coworkerMax_coworker = current.coworker;
	// 		}
	//
	// 		if(!canGetIncentive){
	// 			ranking[current.id] = -1;
	// 			continue;
	// 		}
	//
	// 		tmpRank++;
	// 		if (prevSum > current.attention + current.coworker) {
	// 			rank = tmpRank;
	// 			prevSum = current.attention + current.coworker;
	// 		}
	// 		ranking[current.id] = rank;
	// 	}
	//
	// 	return ranking[0];
	// }
	//
	// static class Worker implements Comparable<Worker> {
	// 	int id;
	// 	int attention;
	// 	int coworker;
	//
	// 	public Worker( int id, int attention, int coworker){
	// 		this.id = id;
	// 		this.attention = attention;
	// 		this.coworker = coworker;
	// 	}
	//
	// 	@Override
	// 	public int compareTo (Worker o1){
	// 		return (o1.attention + o1.coworker) - (this.attention + this.coworker);
	// 	}
	// }
}
