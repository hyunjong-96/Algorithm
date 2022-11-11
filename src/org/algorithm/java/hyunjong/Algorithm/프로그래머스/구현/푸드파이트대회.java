package org.algorithm.java.hyunjong.Algorithm.프로그래머스.구현;

class 푸드파이트대결 {
	public static void main(String[] args) {
		int[] food = {1, 7, 1, 2};
		System.out.println(solution(food));
	}

	static public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<food.length;i++){
			int f = food[i]/2;
			for(int j=0;j<f;j++){
				sb.append(i);
			}
		}

		StringBuilder answer = new StringBuilder();
		answer.append(sb).append(0).append(sb.reverse());

		return answer.toString();
	}
}
