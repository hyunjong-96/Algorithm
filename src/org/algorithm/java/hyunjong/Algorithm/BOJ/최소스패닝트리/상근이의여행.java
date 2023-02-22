package org.algorithm.java.hyunjong.Algorithm.BOJ.최소스패닝트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 상근이의여행 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[N + 1];
			Queue<int[]> queue = new LinkedList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {a, b});
			}
			int count = N-1;
			// while (!queue.isEmpty()) {
			// 	int[] current = queue.poll();
			// 	if (!check[current[0]] || !check[current[1]]) {
			// 		check[current[0]] = true;
			// 		check[current[1]] = true;
			// 		count++;
			// 	}
			// }

			sb.append(String.valueOf(count)).append("\n");
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
