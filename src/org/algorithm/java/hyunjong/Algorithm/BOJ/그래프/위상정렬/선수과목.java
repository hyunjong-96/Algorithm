package org.algorithm.java.hyunjong.Algorithm.BOJ.그래프.위상정렬;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> map = new ArrayList<>();
		int[] indegree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			indegree[b]++;
			map.get(a).add(b);
		}

		int[] answer = topological(map, indegree);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int[] topological(List<List<Integer>> map, int[] indegree) {
		Queue<int[]> queue = new LinkedList<>();
		int[] answer = new int[map.size()];

		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(new int[] {i, 1});
		}

		while (!queue.isEmpty()) {
			int[] currentInfo = queue.poll();

			answer[currentInfo[0]] = currentInfo[1];

			for (int link : map.get(currentInfo[0])) {
				indegree[link]--;
				if (indegree[link] == 0) {
					queue.offer(new int[] {link, currentInfo[1] + 1});
				}
			}
		}

		return answer;
	}
}
