package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.PriorityQueue;

public class 절대값힙_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int result = Math.abs(o1) - Math.abs(o2);
			if (result == 0) {
				result = o1 - o2;
			}
			return result;
		});
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.offer(x);
			} else {
				if (!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {
					sb.append("0").append("\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
