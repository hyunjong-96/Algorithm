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
과제의 데드라인을 맞추기 위해서 최대 데드라인에서 부터 시작해서 해당 데드라인 날까지 해결할 수 있는 과제의 점수를 PQ에 넣는다.
pq는 점수 기준으로 내림차순으로 정렬되어있기 때문에 pq에 들어가있는 점수 중 가장 높은 점수 부터 차례로 해결해야한다.
이 때 데드라인이 높은 날 부터 탐색하기 때문에 pq에 들어가있는 점수들은 모두 해당 deadline의 날에 해결할수 있는 점수로 이루어져있다.

그렇기 때문에 데드라인 마지막 날 부터 1까지 탐색하며 pq에 점수가 존재한다면 pq에서 가장 높은 점수를 더해주면 그것이 최대 점수이다.
 */
public class 과제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer>[] homework = new List[1001];
		int N = Integer.parseInt(br.readLine());

		for(int i=0;i<=1000;i++){
			homework[i] = new ArrayList<>();
		}

		int deadline = 0;
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			homework[d].add(w);

			deadline = Math.max(deadline, d);
		}

		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		while(deadline > 0){
			for(int w : homework[deadline]){
				pq.offer(w);
			}

			if(!pq.isEmpty()){
				answer += pq.poll();
			}

			deadline--;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
