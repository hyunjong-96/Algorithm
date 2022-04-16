package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
문제 해결 방법은 바로 파악을 했는데 그 과정에서 놓치고 있던 부분으로 인해 시간초과가 발생해서 스스로 해결을 못한 문제.
N/2명의 팀을 구성해야하는데 모든 경우의수를 확인해봐야 할것같았다.
그래서 백트래킹을 이용해서 첫번째 팀과 두번째 팀을 구했는데,
생각해보니까 첫번째 팀이 전체 인원의 절반이니까 두번째 팀을 구하는 반복을 굳이 할 필요가 없었다. 시간이 2배 걸리는것뿐..
그래서 N/2번의 반복분만 실행하고 visit 여부를 파악해 N/2명을 필터링하고 그 나머지 인원의 값을 구해서 min값을 구하려고했다.
하지만 계속해서 시간초과가 발생했고, 재귀함수에 index를 argument에 추가해서 어차피 이전의 index(인원)의 앞에 있는 index에 대한 재귀함수는
team[i][j],team[j][i]를 나중에 함께 계산하기 떄문에 볼필요가 없다. 그렇기에 index 뒤에 있는 값들로만 반복하게 하여 성공.
 */
public class 스타트와링크 {
	static boolean[] visit;
	static int[][] team;
	static int S1;
	static int S2;
	static int min;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		team = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		setTeam(1,0);

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	static void setTeam(int index, int count){
		if(count>=N/2){
			S1=0;
			S2=0;
			for(int i=1;i<= N;i++){
				for(int j=i+1;j<= N;j++){
					if(visit[i] && visit[j]){
						S1+=team[i][j]+team[j][i];
					}else if(!visit[i] && !visit[j]){
						S2+=team[i][j]+team[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(S1-S2));
			return;
		}

		for(int i=index;i<=N;i++){
			if(!visit[i]){
				visit[i] = true;
				setTeam(i+1, count+1);
				visit[i] = false;
			}
		}
	}

	// static void setOtherTeam(int index, List<Integer> playerList) {
	// 	if (playerList.size() >= N / 2) {
	// 		S2 = 0;
	// 		for (int i = 0; i < playerList.size()-1; i++) {
	// 			int player1 = playerList.get(i);
	// 			for (int j = i + 1; j < playerList.size(); j++) {
	// 				int player2 = playerList.get(j);
	// 				S2 += team[player1][player2] + team[player2][player1];
	// 			}
	// 		}
	// 		min = Math.min(min, Math.abs(S1-S2));
	// 		return;
	// 	}
	//
	// 	for(int i=index;i<=N;i++){
	// 		if(!visit[i]){
	// 			visit[i] = true;
	// 			playerList.add(i);
	// 			setOtherTeam(index+1, playerList);
	// 			playerList.remove(playerList.size()-1);
	// 			visit[i] = false;
	// 		}
	// 	}
	// }
}
