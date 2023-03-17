package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = find(N, K);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int find(int N, int K) {
		Queue<int[]> queue = new LinkedList();
		boolean[] check = new boolean[100001];

		queue.offer(new int[] {N, 0});
		check[N] = true;

		while (!queue.isEmpty()) {
			int currentTimeSize = queue.size();
			for (int i = 0; i < currentTimeSize; i++) {
				int[] current = queue.poll();
				int pos = current[0];
				int time = current[1];

				if (pos == K)
					return time;

				move(check, queue, pos - 1, time);
				move(check, queue, pos + 1, time);
				move(check, queue, pos * 2, time);
			}
		}
		return -1;
	}

	static void move(boolean[] check, Queue<int[]> queue, int nextPos, int time) {
		if (nextPos >= 0 && nextPos <= 100000 && !check[nextPos]) {
			queue.offer(new int[] {nextPos, time + 1});
			check[nextPos] = true;
		}
	}
}
