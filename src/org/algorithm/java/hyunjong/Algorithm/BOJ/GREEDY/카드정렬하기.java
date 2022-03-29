package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*
우선순위 큐를 사용하는 문제이다.
N개의 카드묶음 수가 있을 때 각각의 카드 합이 최소일 때 더해주는 것을 반복하면 되는것이다.
ex) {10,10,20,30,40} 일때 카드 묶음수가 10, 10 인 것을 합했을때가 가장 적은 수이므로
{(10,10),20,30,40} 이 두개를 더해준 다음 다시 넣어준다 {20,20,30,40}
그 다음에 카드 묶음수가 가장 작은 수는 20,20 이므로 더해서 다시 넣어준다. {40,30,40}
이때 두 카드 묶음수의 합이 가장 작은 것을 더해줘야 하기 때문에 {30,40,40}이 되어야한다.
우선 순위 큐를 사용하면 두 카드 묶음수의 값을 다시 우선 순위 큐에 넣어줬을때 minHeap인 경우 longN의 시간 복잡도로 정렬해주기에
배열의 오름차순 정렬을 하는것보다 시간복잡도가 빠르게 되므로 우선순위 큐를 사용해줘야한다.
 */
public class 카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		//두 카드 묶음 수들의 합을 저장
		int sum = 0;
		/*
		pq가 빌 때까지 반복하면 b 에서 NPE가 발생하므로 크기가 2이상 일때 까지만 돌려준다
		어차피 N이 짝수든 홀수든 더해준 값을 다시 pq에 넣기 때문에 1이하로 떨어질 일은 없다.
		*/
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();

			sum += a + b;
			pq.add(a + b);
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
