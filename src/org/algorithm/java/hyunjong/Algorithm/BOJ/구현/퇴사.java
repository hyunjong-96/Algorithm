package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
처음에 완전 브루트포스로 구현하려다가 자꾸 조건에서 삑 나서 혹시나 하는 마음에 dp로 풀어보았다.
Top-Bottom으로 풀었다
T(상담 기간)와 P(가치)를 저장하고 있는 배열의 index를 날짜로 두고
dp를 해당 날짜에서 상담을 했을때 N날 까지 중 가질수 있는 최대의 가치
index+works[index]-1이 N보다 작거나 같을경우 index+works[index]부터 N까지의 dp중에서 가장 큰 값을 가지는 값과 works[index].P를 합해서 dp[index]에 저장해준다.
 Top-Bottom으로 한다고 했으니 works의 맨 뒷부분부터 탐색하면서 현재 날짜와 상담기간의 합이 N을 벗어나게 되면 상담을 할수 없으므로 dp에 0을 저장하고
 합이 N을 벗어나지 않으면 해당 날부터 마지막 날까지 중 가능한 가장 큰 가치(dp)의 값을 찾아서 현재 날짜에 상담할떄의 가치와 합해주면
 해당 날짜부터 N날까지 했을때 가질수 있는 가장 큰값을 구해줄수 있다.
이를 반복한다음
dp값중 가장 큰값을 반환해주면 된다.
 */
public class 퇴사 {
	static Work[] works;
	static int[] dp;
	static int N;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		works = new Work[N + 1];
		dp = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		setDp();

		max = 0;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, dp[i]);
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	static void setDp() {
		for (int i = works.length - 1; i > 0; i--) {
			if (i + works[i].t - 1 <= N) {
				int max = 0;
				for (int j = i + works[i].t; j <= N; j++) {
					max = Math.max(max, dp[j]);
				}
				dp[i] = works[i].p + max;
			} else {
				dp[i] = 0;
			}
		}
	}

	static class Work {
		int t;
		int p;

		public Work(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}
}
