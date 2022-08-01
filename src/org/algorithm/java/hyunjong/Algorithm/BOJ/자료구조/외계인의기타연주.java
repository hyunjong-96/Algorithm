package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
기타 줄에서 누르고 있는 프랫 중 가장 높은 프랫으로 음이 난다고했다.
그렇기 때문에 guitar[line]을 priorityQueue로 선언하고 같은 line에서 누르려는 프랫보다 높은 프랫이 있다면
	높은 프랫들을 지우고 해당 프랫을 pq에 넣고 count++
guitar[line].isEmpty()이거나 guitar[line]에서 누르고 있는 프랫이 누르려는 프랫보다 낮으면 pq에 해당 프랫을 넣고 count++
다른 line의 프랫은 누르고 있어도 상관없다.
 */
public class 외계인의기타연주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer>[] guitar = new PriorityQueue[7];
		for (int i = 1; i <= 6; i++) {
			guitar[i] = new PriorityQueue<>(Comparator.reverseOrder());
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int line = Integer.parseInt(st.nextToken());
			int pratt = Integer.parseInt(st.nextToken());

			if (guitar[line].isEmpty()) {
				guitar[line].offer(pratt);
				count++;
			} else {
				if (guitar[line].peek() > pratt) {
					while (!guitar[line].isEmpty() && guitar[line].peek() > pratt) {
						guitar[line].poll();
						count++;
					}

					if (guitar[line].isEmpty() || guitar[line].peek() < pratt) {
						guitar[line].offer(pratt);
						count++;
					}
				} else if (guitar[line].peek() < pratt) {
					guitar[line].offer(pratt);
					count++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
