package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
완탐으로 풀어보려했으니 해결이 되지 않아서풀이를 보았다.
모든 경우의 수를 확인하긴 하는데 dp를 활용해서 목표 알고력과 목표 코딩력을 당설하는데 걸리는 시간을 계산한다 (신박)

//1
int[][] dp는 목표 알고력과 목표 코딩력까지 크기에다가 +1 크게 설정하여 ArrayOutBound를 방지한다.
	최초 알고력과 최초 코딩력에서 목표 알고력과 목표 코딩력까지 걸리는 모든 경우의 최소 값을 저장할때 2중 반복을 사용하기 때문

//2
알고력 i와 코딩력 j를 얻기 위해 걸리는 시간은
	dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1); // 알고력을 1 높이기 위한 시간
	dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1); //코딩력을 1 높이기 위한 시간
	dp[i][j] = Math.min(dp[i][j], dp[i-alp_rwd][j-cop_rwd]+cost); //특정 문제를 풀어 얻는 알고력과 코딩력에 걸리는 시간
	으로 구분할 수 있다.

//3
그리고 특정 문제를 풀었을 때 증가하는 알고력과 코딩력이 목표 알고력과 목표 코딩력을 벗어났을 경우도 생각해야한다.
	문제를 풀었을 때 i+alp_rwd > goal_alp 이고 j+cop_rwd > goal_cop 이면 dp에 그대로 저장해주는 것이 아니라
	dp[goal_alp][goal_cop]에 저장해주어야한다.
	왜냐면 목표 알고력과 목표 코딩력을 이상 넘은 이후로는 계산할 필요가 없고 그 순간이 되는 시간이 목표알고력과 목표 코딩력을
	달성하는 시간이 될수 있기 때문이다.

	위와 동일한 개념으로 문제를 풀었을때 얻은 알고력과 코딩력이 둘 다 목표를 넘는 것이 아닌 각각 넘었을경우
	목표를 넘은 것만 목표의 값으로 변경해주고 최소 시간으로 갱신해주게 된다.

	그리고 둘 다 목표보다 같거나 작다면 기존값에 증가값을 더해주면된다.

//4
마지막으로 초기 알고력과 초기 코딩력이 목표 알고력과 목표 코딩력을 넘겼을때 런타임이 발생하기 때문에
alp > goal_alp 이고 cop > goal_cop이라면 alp == goal_alp, cop == goal_cop 로 갱신하여 0이 나오도록 해준다.

이렇게 하면 모든 목표 알고력, 코딩력에 걸리는 시간을 탐색하기 위한 2중반복과 해당 알고력, 코딩력에서 각 문제를 해결해보는 과정인 반복문을 통해
O(목표 알고력 * 목표 코딩력 * 문제 개수)의 시간복잡도가 발생한다.
 */
public class 코딩테스트공부 {
	public static void main(String[] args) {
		int alp = 10;
		int cop = 10;
		int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
		System.out.println(solution(alp, cop, problems));
	}

	static int solution(int alp, int cop, int[][] problems) {
		int goalAlp = 0;
		int goalCop = 0;
		for (int[] p : problems) {
			goalAlp = Math.max(goalAlp, p[0]);
			goalCop = Math.max(goalCop, p[1]);
		}

		if (alp > goalAlp)
			alp = goalAlp;
		if (cop > goalCop)
			cop = goalCop;

		//목표 알고력,코딩력에 값을 저장하기 위해 +1, out bound를 예방하기 위해 +1
		int[][] dp = new int[goalAlp + 2][goalCop + 2];
		//dp에는 해당 dp[i][j]를 달성하기 위해 걸리는 최소 시간을 저장하기 위해 최대값으로 초기화
		for (int a = alp; a <= goalAlp; a++) {
			for (int c = cop; c <= goalCop; c++) {
				dp[a][c] = Integer.MAX_VALUE;
			}
		}

		//초기 알고력, 코딩력의 시간은 0이다.
		dp[alp][cop] = 0;

		//초기 알고력과 초기 코딩력부터 목표 알고력, 코딩력까지 걸리는 최소 시간을 찾기 위한 2중 반복문
		for (int a = alp; a <= goalAlp; a++) {
			for (int c = cop; c <= goalCop; c++) {

				//알고력 공부 +1
				dp[a + 1][c] = Math.min(dp[a][c] + 1, dp[a + 1][c]);
				//코딩력 공부 +1
				dp[a][c + 1] = Math.min(dp[a][c] + 1, dp[a][c + 1]);

				//해당 알고력, 코딩력에서 문제를 풀수 있는지 탐색
				for (int[] p : problems) {
					int alpReq = p[0];
					int copReq = p[1];
					int alpRwd = p[2];
					int copRwd = p[3];
					int cost = p[4];

					//현재 알고력, 코딩력으로 해당 문제를 풀 수 있을 때
					if (a >= alpReq && c >= copReq) {
						//문제를 풀었는데 alp, cop가 goalAlp, goalCop를 오버했을때.
						if (a + alpRwd > goalAlp && c + copRwd > goalCop) {
							//목표 알고력, 코딩력에 시간을 갱신해준다.
							dp[goalAlp][goalCop] = Math.min(dp[a][c] + cost, dp[goalAlp][goalCop]);
						}
						//alp이 목표 알고력을 넘어갔을때
						else if (a + alpRwd > goalAlp) {
							//넘어간 알고력을 목표 알고력으로 갱신해준다.
							dp[goalAlp][c + copRwd] = Math.min(dp[a][c] + cost, dp[goalAlp][c + copRwd]);
						}
						//cop이 목표 코딩력을 넘어갔을때
						else if (c + copRwd > goalCop) {
							//넘어간 코딩력을 목표 코딩력으로 갱신해준다.
							dp[a + alpRwd][goalCop] = Math.min(dp[a][c] + cost, dp[a + alpRwd][goalCop]);
						}
						//목표 알고력, 코딩력을 초과하지 않았다면 해당 알고력, 코딩력에 값을 갱신해준다.
						else if (a + alpRwd <= goalAlp && c + copRwd <= goalCop) {
							dp[a + alpRwd][c + copRwd] = Math.min(dp[a][c] + cost, dp[a + alpRwd][c + copRwd]);
						}
					}
				}
			}
		}

		return dp[goalAlp][goalCop];
	}
}
