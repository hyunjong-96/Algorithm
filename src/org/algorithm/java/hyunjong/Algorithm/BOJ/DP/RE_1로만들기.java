package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class RE_1로만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int answer = makeOne(N);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int makeOne(int N) {
		boolean[] check = new boolean[N + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N, 0});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			if (current[0] == 1)
				return current[1];

			if (current[0] % 3 == 0 && !check[current[0] / 3]) {
				queue.offer(new int[] {current[0] / 3, current[1] + 1});
				check[current[0] / 3] = true;
			}

			if (current[0] % 2 == 0 && !check[current[0] / 2]) {
				queue.offer(new int[] {current[0] / 2, current[1] + 1});
				check[current[0] / 2] = true;
			}

			if (!check[current[0] - 1]) {
				queue.offer(new int[] {current[0] - 1, current[1] + 1});
				check[current[0] - 1] = true;
			}
		}
		return -1;
	}
}
