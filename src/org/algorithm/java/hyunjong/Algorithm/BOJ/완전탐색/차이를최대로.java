package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
수열들의 위치를 바꿔가며 |seq[0]-seq[1]|+|seq[1]-seq[2]|+... 의 공식을 통해 최대값을 구해야한다.
dept값을 통해 배열의 자릿수(index)에서 공식을 수행할 값들을 변경해야하는데, 공식에 적용될 값들은 ans배열에 저장을 한다.
각 dept값에 대한 값 초기화는 dfs를 통해 비교해준다.
 */
public class 차이를최대로 {
	static int N;
	static int[] seq;
	static int[] ans;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		ans = new int[N];
		visit = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	/*
	dfs를 통해 depth값 즉, 공식을 수행할 값들을 정렬하게된다.
	depth=0일때 seq[0]의 값을 ans[0]에 저장을 해주고 다른 depth값에서 해당 값을 사용할수 없도록 visit배열로 boolean처리를 한다.
	만약 depth=N값 만큼이 되면 공식을 수행할 값들이 ans배열에 저장이 되어있는것이므로 공식 수행 후 result값과 비교해 큰값을 저장한다.
	 */
	private static void dfs(int depth) {
		if (depth == N) {
			int sum = 0;

			for (int i = 0; i < ans.length - 1; i++) {
				sum += Math.abs(ans[i] - ans[i + 1]);
			}
			result = Math.max(sum, result);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(!visit[i]){
				ans[depth] = seq[i];	//depth에서 사용할 값(seq[i])을 ans[depth]에 저장한다
				visit[i] = true;	//true처리를 함으로써 다음 depth에서 seq[i]값을 사용할수 없도록 한다.
				dfs(depth+1);
				visit[i] = false;	//false처리를 함으로써 이전 depth에서 seq[i]값을 사용할수 있게 하여 ans[depth]에 seq[i]값이 들어갈수 있게 된다.
			}
		}
	}
}
