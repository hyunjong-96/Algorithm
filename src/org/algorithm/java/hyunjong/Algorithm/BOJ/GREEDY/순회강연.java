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

/*
데드라인이 가장 늦은 날부터 데드라인이 1일인 날까지 돌면서 해당 데드라인날까지 해결해야하는 강연 중 가장 p가 큰 곳을 선택해서 강연한다.
데드라인이 늦은 날부터 하는 이유는 늦은 날의 p가 pq가 들어가있을때 데드라인은 점점 빠른 날로 이동하기 때문에 pq에 들어가있는 p도 선택할수 있기 떄문.
 */
public class 순회강연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer>[] lectures = new List[10001];

		for (int i = 0; i < 10001; i++) {
			lectures[i] = new ArrayList<>();
		}
		int maxD = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			lectures[d].add(p);
			maxD = Math.max(maxD, d);
		}

		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = maxD; i > 0; i--) {
			for(int p : lectures[i]){
				pq.offer(p);
			}

			if(!pq.isEmpty()){
				answer += pq.poll();
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
