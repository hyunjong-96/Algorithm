package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
3개의 치킨을 선택했을 때 선택된 치킨 중 각 회원의 가장 큰 선호값의 합을 구해서, 그 중 가장 큰 값을 반환한다.
LinkedList에 선택한 3개의 치킨을 저장하고 선형탐색하여 N명의 회원이 3개의 치킨 중에서 가지는 최고의 우선순위를 하나 뽑아와 모두 더해준다.
그리고 max값과 비교하여 큰 값을 갱신해준다.
 */
public class 치킨치킨치킨 {
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] priorities = new int[N][M];
		for(int i=0;i<N;i++){
			String[] row = br.readLine().split(" ");
			for(int j=0;j<M;j++){
				priorities[i][j] = Integer.parseInt(row[j]);
			}
		}

		max = 0;
		findBest(priorities, new LinkedList<>(), 0, N, M, 0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	static void findBest(int[][] priorities, LinkedList<Integer> choice, int depth, int N, int M, int index){
		if(depth == 3){
			int prefixSum = 0;
			for(int i=0;i<N;i++){
				int p = 0;
				for (Integer integer : choice) {
					p = Math.max(p, priorities[i][integer]);
				}
				prefixSum += p;
			}

			max = Math.max(prefixSum, max);
			return;
		}

		for(int i=index;i< M;i++){
			choice.addLast(i);
			findBest(priorities, choice, depth+1, N, M, i+1);
			choice.removeLast();
		}
	}
}
