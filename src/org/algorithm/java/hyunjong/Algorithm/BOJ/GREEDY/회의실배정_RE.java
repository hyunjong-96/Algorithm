package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class 회의실배정_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Meeting(start, end));
		}

		int result = 0;
		int prevEnd = 0;
		while (!pq.isEmpty()) {
			Meeting meeting = pq.poll();

			if (prevEnd > meeting.start)
				continue;

			result++;
			prevEnd = meeting.end;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	public static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			int result = this.end - o.end;
			if (result == 0)
				return this.start - o.start;
			return result;
		}
	}
}
