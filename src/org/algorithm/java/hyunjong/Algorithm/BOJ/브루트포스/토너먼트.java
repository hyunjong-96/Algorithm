package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
라운드별로 살아남은 참가자를 저장한 List를 통해서 각 경기의 첫번째 참가자를 left, 두번째 참가자를 right로 놓는다.
left와 right가 K이고 I라면 해당 라운드를 반환하고 재귀를 끝낸다.
left와 right 중 하나만 K거나 I라면 해당 참가자를 nextRound인 List에 저장한다. 둘다 아니라면 아무나 nextRound에 넣는다(구현은 두번째 참가자)
만약 현재 라운드에서 참가자가 홀수라면 마지막 인원은 그냥 nextRound에 넣어준다.
그리고 nextRound를 재귀로 돌린다.

만약 round가 총 라운드 개수를 넘어가면 K와 I는 서로 대결을 하지 못한것이기 때문에 -1을 반환해준다.
 */
public class 토너먼트 {
	static int K;
	static int I;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		I = Integer.parseInt(st.nextToken());

		List<Integer> user = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			user.add(i);
		}

		int limit = user.size() % 2 == 0 ? user.size() / 2 : user.size() / 2 + 1;
		answer = 0;
		play(user, 1, limit);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void play(List<Integer> currentRound, int round, int limit) {
		if (round > limit) {
			answer = -1;
			return;
		}

		int size = currentRound.size();
		List<Integer> nextRound = new ArrayList<>();
		for (int i = 0; i < size; i += 2) {
			if(i != size-1){
				int left = currentRound.get(i);
				int right = currentRound.get(i + 1);

				if ((left == K && right == I) || (left == I && right == K)) {
					answer = round;
					return;
				} else if (left == K || left == I) {
					nextRound.add(left);
				} else {
					nextRound.add(right);
				}
			}else{
				nextRound.add(currentRound.get(i));
			}
		}
		play(nextRound, round+1, limit);
	}
}
