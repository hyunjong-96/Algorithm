package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class 최대힙_구현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		MaxHeap heap = new MaxHeap();

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			Long num = Long.parseLong(br.readLine());

			if (num == 0)
				sb.append(heap.poll()).append("\n");
			else
				heap.offer(num);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class MaxHeap {
		private List<Long> heap;

		public MaxHeap() {
			this.heap = new ArrayList<>();
			heap.add(0L);
		}

		public long peek() {
			return heap.size() == 1 ? 0L : heap.get(1);
		}

		public void offer(long e) {
			heap.add(e);
			int p = heap.size() - 1;

			while (p > 1 && heap.get(p / 2) < heap.get(p)) {
				long swap = heap.get(p / 2);
				heap.set(p / 2, heap.get(p));
				heap.set(p, swap);
				p /= 2;
			}
		}

		public long poll() {
			long result = 0;
			if (heap.size() == 1)
				return result;

			result = heap.get(1);
			heap.set(1, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);

			int p = 1;

			while (p * 2 < heap.size()) {
				int maxI = p * 2;
				long maxV = heap.get(maxI);

				if (p * 2 + 1 < heap.size() && maxV < heap.get(p * 2 + 1)) {
					maxI = p * 2 + 1;
					maxV = heap.get(p * 2 + 1);
				}

				if(heap.get(p) > maxV) break;

				long swap = heap.get(p);
				heap.set(p, maxV);
				heap.set(maxI, swap);

				p = maxI;
			}
			return result;
		}
	}
}
