package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
백트래킹을 통해 최대 8개의 던전을 하나하나 돌아서 최대한 많은 던전을 도는 경우를 구해야한다.
 */
public class 피로도 {
	public static void main(String[] args) {
		int k =80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(solution(k,dungeons));
	}

	static int answer;
	static int solution(int k, int[][] dungeons){
		answer = 0;

		boolean[] visit = new boolean[dungeons.length];
		bt(dungeons, visit, k, 0);

		return answer;
	}

	static public void bt(int[][] dungeons, boolean[] visit, int k, int depth){
		answer = Math.max(answer, depth);
		if(depth == dungeons.length) return;

		for(int i=0;i<dungeons.length;i++){
			int needs = dungeons[i][0];
			int use = dungeons[i][1];

			if(k >= needs && k-use > 0 && !visit[i]){
				visit[i] = true;
				bt(dungeons, visit, k-use, depth+1);
				visit[i] = false;
			}
		}
	}
}
