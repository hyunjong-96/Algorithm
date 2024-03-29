package org.algorithm.java.hyunjong.Algorithm.BOJ.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요새푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		sb.append("<");
		while (queue.size() > 1) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll());
			sb.append(", ");
		}

		sb.append(queue.poll()).append(">");

		System.out.println(sb);
	}
}
