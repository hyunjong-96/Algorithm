package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

public class 징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	static int solution(int[] stones, int k){
		int front=1;
		int end=200000000;
		int answer = 0;
		while(front<=end){
			int mid = (front+end)/2;

			if(crossRiver(mid, k, stones)){
				answer = Math.max(answer, mid);
				front = mid+1;
			}else{
				end = mid-1;
			}
		}

		return answer;
	}

	static boolean crossRiver(int user, int k, int[] stones){
		int count=0;

		for(int stone : stones){
			if(stone-user < 0){
				count++;
			}else{
				count=0;
			}

			if(count == k){
				return false;
			}
		}
		return true;
	}

	//슬라이딩 윈도우
	// static int solution(int[] stones, int k){
	// 	int min = 0;
	// 	int idx = 0;
	// 	for(int i=0;i<k;i++){
	// 		if(stones[i]>min){
	// 			min = stones[i];
	// 			idx = i;
	// 		}
	// 		min = Math.max(min, stones[i]);
	// 	}
	//
	// 	for(int i=k;i<stones.length;i++){
	// 		int max = 0;
	// 		for(int j=i-k+1;j<=i;j++){
	// 			if(stones[j]>max){
	// 				idx = j;
	// 				max = stones[j];
	// 			}
	// 		}
	// 		while(i-k+1<idx){
	// 			i++;
	// 		}
	//
	// 		min = Math.min(min,max);
	// 	}
	// 	return min;
	// }
}
