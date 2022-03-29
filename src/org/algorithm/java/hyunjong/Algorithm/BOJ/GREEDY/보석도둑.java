package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
처음 풀었을 때는 보석의 가격의 내림차순과 무게의 오름차순으로 정렬, 가방을 오름차순으로 정렬한 후
각 가방을 돌면서 가방의 무게보다 작은 보석의 첫번째의 가격을 더해가는 식으로 반복해서 구현을 했었다.
이렇게 풀면 NK의 시간복잡도가 나오기 때문에 (30000*30000) 시간 초과가 발생했다.
nlong의 복잡도로 내려서 푸는 방법을 찾아서 구현해보았다.

처음 풀때와 다르게 보석의 무게를 오름차순으로 만 정렬, 가방을 오름차순으로 정렬한 후
각 가방을 첫번째 부터 반복하면서 현재 가방의 무게보다 작거나 같은 보석의 무게를 PriorityQueue에 저장하였다.
그리고 PQ에는 가방에 들어갈수 있는 보석이 들어있고 pq.poll을 했을때 나오는 값이 그 중 가치가 가장 높은 값이 나오게 된다.(핵심)
그 값을 sum에 저장하고 반복하게 된다.
반복을 돌면 PQ에는 이전에 선택받지 못한 보석과 현재 가방의 무게에 들어갈수 있는 보석들이 추가가 되지만
결국 현재 가방에 넣을수 있는 보석은 pq의 맨 앞에 있는 값이기 때문에 N+K와 정렬 longN으로 NlongN의 시간복잡도를 가져 통과하게 된다.
 */
public class 보석도둑 {
	static class Jewel implements Comparable<Jewel> {
		int m;
		int v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			return this.m - o.m;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		int[] bag = new int[K];
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			jewels[i] = new Jewel(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewels);	//보석 무게에 대한 오름차순
		Arrays.sort(bag);	//가방 무게에 대한 오름차순

		long sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());	//보석의 가치에 대한 내림차순
		for (int i = 0, j = 0; i < K; i++) {	//i : 가방의 index, j : 보물의 index
			while (j<N && jewels[j].m <= bag[i]){	//현재 가방의 무게보다 작거나 같은 보석의 무게까지 PQ에 넣어준다.
				pq.offer(jewels[j++].v);	//보석을 넣게 되면 현재 보석 무게보다 작은건 다시 탐색할 필요가 없으니 j++
			}

			if(!pq.isEmpty()){	//해당 가방의 무게에서 넣을수 있는 보석이 있다면
				sum += pq.poll();	//그중 가치가 가장 높은 보석 값을 합해준다.
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}
