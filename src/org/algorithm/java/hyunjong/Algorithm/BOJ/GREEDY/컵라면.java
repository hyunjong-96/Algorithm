package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 컵라면 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Problem[] problems = new Problem[N];
		int lastDeadLine = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int deadLine = Integer.parseInt(st.nextToken());
			int noodle = Integer.parseInt(st.nextToken());
			problems[i] = new Problem(i, deadLine, noodle);

			lastDeadLine = Math.max(lastDeadLine, deadLine);
		}

		List<Integer>[] noodles = new List[lastDeadLine + 1];
		for (int i = 1; i < noodles.length; i++) {
			noodles[i] = new ArrayList<>();
		}

		for (Problem problem : problems) {
			noodles[problem.deadLine].add(problem.noodle);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int answer = 0;

		for (int i = noodles.length - 1; i >= 1; i--) {
			for(int noodle : noodles[i]){
				pq.offer(noodle);
			}

			if(pq.isEmpty()) continue;

			answer += pq.poll();
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static class Problem {
		int num;
		int deadLine;
		int noodle;

		public Problem(int num, int deadLine, int noodle) {
			this.num = num;
			this.deadLine = deadLine;
			this.noodle = noodle;
		}
	}
}
