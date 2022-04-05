package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.Arrays;

public class 실패율 {
	public static void main(String[] args){
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] result = solution(N, stages);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

	/*
	실패율 : 도달했지만 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
	stages에 들어있는 각 사용자의 스테이지를 통해 stage_count의 index를 스테이지로 놓고 해당 index의 값을 카운트 해준다.
	stage정보, stage에 있는 사용자 수, 스테이지에 도달한 유저 수를 담은 Stage클래스를 담은 배열을 만들고
	각 스테이지 마다 해당 stage정보를 Stage에 담아 stage_arr에 저장한다.
	이때 스테이지에 도달한 유저 수를 구하기 위해 총 유저수 - 이전까지 stage의 총 유저수를 통해 값을 저장해준다.
	그리고 중요한것, 스테이지에 도달한 유저 수가 0명이면 실패율이 0이어야한다. 하지만 이를 고려하지 않으면
	java에서는 0으로 나눠줄때 NAN값이 나오게 되어 런타임이 발생하게 된다. 그래서 실패율을 계산해줄때
	해당 스테이지의 도달한 유저수가 0일때 실패율을 0으로 만들어줘야한다(여기서 해결못했었음)
	그런다음 Stage클래스의 실패율을 내림차순으로 정렬 한 후 각 스테이지를 배열로 저장해여 반환해준다.
	 */
	public static int[] solution(int N, int[] stages){
		int[] stage_count = new int[N+2];
		Stage[] stage_arr = new Stage[N];
		int totalUser = 0;
		for(int i=0;i<stages.length;i++){
			stage_count[stages[i]]++;
			totalUser++;
		}

		int prevUser = 0;
		for(int i=0;i<N;i++){
			stage_arr[i] = new Stage(i+1, stage_count[i+1], totalUser-prevUser);
			prevUser += stage_count[i+1];
		}

		Arrays.sort(stage_arr);

		int[] answer = new int[N];
		for(int i=0;i<N;i++){
			answer[i] = stage_arr[i].stage;
		}
		return answer;
	}
}

class Stage implements Comparable<Stage>{
	int stage;
	int count;
	int receiveCount;
	public Stage(int stage, int count, int receiveCount){
		this.stage = stage;
		this.count = count;
		this.receiveCount = receiveCount;
	}

	@Override
	public int compareTo(Stage o) {
		double thisFailRate = this.receiveCount == 0 ? 0.0 : (double)this.count/this.receiveCount;
		double otherFailRate = o.receiveCount == 0 ? 0.0 : (double)o.count/o.receiveCount;
		if(otherFailRate > thisFailRate){
			return 1;
		}else if(otherFailRate == thisFailRate){
			return this.stage - o.stage;
		}
		return -1;
	}
}
