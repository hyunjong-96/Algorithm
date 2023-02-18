package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 스마트물류 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] line = br.readLine().split("");

		PriorityQueue<Integer> pqH = new PriorityQueue<>();
		Queue<Integer> queueP = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String s = line[i];

			if (s.equals("P"))
				queueP.offer(i);
			else
				pqH.offer(i);
		}

		int count = 0;
		while (!queueP.isEmpty()) {
			int p = queueP.poll();
			if (pqH.isEmpty())
				break;

			int h = pqH.poll();

			if (Math.abs(p - h) <= K) {
				count++;
			} else {
				pqH.offer(h);

				while (!pqH.isEmpty() && pqH.peek() < p && Math.abs(p - pqH.peek()) > K) {
					pqH.poll();
				}

				if (!pqH.isEmpty() && Math.abs(p - pqH.peek()) <= K) {
					pqH.poll();
					count++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}


