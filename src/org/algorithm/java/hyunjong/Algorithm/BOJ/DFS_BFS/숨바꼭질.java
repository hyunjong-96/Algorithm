package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
	static int[] point = new int[100001];
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(N != K){
			bfs();
		}

		bw.write(String.valueOf(point[K]));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);

		while (!queue.isEmpty()) {
			if (point[K] != 0)
				break;
			int n = queue.poll();

			if (n-1 >= 0 && point[n - 1] == 0) {
				queue.add(n - 1);
				point[n - 1] = point[n] + 1;
			}
			if (n + 1 < 100001 && point[n + 1] == 0) {
				queue.add(n + 1);
				point[n + 1] = point[n] + 1;
			}
			if (n * 2 < 100001 && point[n * 2] == 0) {
				queue.add(n * 2);
				point[n * 2] = point[n] + 1;
			}
		}
	}
}
