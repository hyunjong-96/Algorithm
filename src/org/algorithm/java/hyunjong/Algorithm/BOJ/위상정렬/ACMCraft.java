package org.algorithm.java.hyunjong.Algorithm.BOJ.위상정렬;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] indegree = new int[N + 1];
			List<Integer>[] conditions = new List[N + 1];
			int[] times = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				conditions[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				indegree[y]++;
				conditions[x].add(y);
			}

			int target = Integer.parseInt(br.readLine());

			int[] time = topologSort(indegree, conditions, times, N);
			sb.append(String.valueOf(time[target])).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] topologSort(int[] indegree, List<Integer>[] conditions, int[] times, int N) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		int[] successTime = new int[N+1];
		for(int i=1;i<=N;i++){
			successTime[i] = times[i];
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int need : conditions[current]) {
				indegree[need]--;

				successTime[need] = Math.max(successTime[need], successTime[current]+times[need]);
				if (indegree[need] == 0) {
					queue.offer(need);
				}
			}
		}

		return successTime;
	}
}