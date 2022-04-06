package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그래프;

/*
플로이드 와샬 알고리즘을 사용하는 문제이다.
플로이드 와샬이란 모든 정점에 대해서 경유하는 정점을 통해 모든 정점으로의 최단 거리를 구하는 알고리즘이다.
처음에는 이 문제랑 플로이드랑 무슨 상관이 있지 라는 생각을 했었다.
문제를 보면 i선수와 j선수의 결과를 통해 순위를 매길수 있는데, 모든 선수의 결과가 없는 상황이다.
이때 순위를 유추하기 위해서는 다른 선수들간의 경기 결과를 통해 i와 j 선수의 순위를 파악해야하는것이다.
예를 들어 1번 선수가 2번 선수를 이겼고 3번 선수가 2번 선수에게 졌다면 3번선수는 1번선수에게 진것이 된다.
그렇기 때문에 초기 결과 배열에서는 '모름'이였지만 1번 선수와 2번선수의 결과 2번 선수와 3번선수와의 결과를 통해
1번 선수와 3번선수와의 결과를 유추할수 있게 되기때문에 플로이드 와샬 알고리즘이라 할수있겠다.
다만 보통의 플로이드 와샬에서는 가중치의 값(최단 거리)를 결과 배열에 넣지만 여기서는 가중치는 없고 승,패,모름 으로 나누면되기 때문에
승 : 1, 패 : -1, 모름 : 0으로 저장해서 자기자신을 제외하고 다른 선수와의 결과가 결과배열에 있다면 순위를 알수 있게 되는것이다.
 */
public class 순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results ={{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n,results));
	}

	static int solution(int N , int[][] results){
		int[][] grade = new int[N+1][N+1];
		//winner의 열에는 1, losser의 행에는 -1
		for(int i=0;i<results.length;i++){
			int winner = results[i][0];
			int losser = results[i][1];
			grade[winner][losser] = 1;
			grade[losser][winner] = -1;
		}

		//플로이드 와샬 알고리즘을 이용해 k선수를 통한 결과값이 1또는 -1로 나와있다면 i와j의 결과를 알수있기때문에
		//grade[i][k]==1이고 grade[k][j]==1이면 i는 j에게 이긴것과 같다.
		//마찬가지로 grade[i][k]==-1 && grade[k][j]==-1이면 i는 j에게 진것과 같다.
		for(int k=1;k<N+1;k++){
			for(int i=1;i<N+1;i++){
				for(int j=1;j<N+1;j++){
					if(grade[i][k]==1&&grade[k][j]==1){
						grade[i][j] = 1;
						grade[j][i] = -1;
					}
					if(grade[i][k]==-1&&grade[k][j]==-1){
						grade[i][j] = -1;
						grade[j][i] = 1;
					}
				}
			}
		}

		//결과 배열에서 자기 자신을 제외한 다른 선수와의 결과가 0이 아닌 값이면 순위를 알수있기때문에
		//해당 선수의 열을 확인한 후 0의 값이 1개라면 순위를 알수있기때문에 answer++해준다.
		int answer = 0;
		for(int i=1;i<N+1;i++){
			int cnt=0;
			for(int j=1;j<N+1;j++){
				if(grade[i][j] != 0){
					cnt++;
				}
			}
			if(cnt==N-1) answer++;
		}
		return answer;
	}
}
