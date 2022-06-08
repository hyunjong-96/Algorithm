package org.algorithm.java.hyunjong.Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MooTube {
	static int N;
	static int Q;
	// static int[][] network;
	static List<int[]>[] network;
	static int[][] question;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		network = new List[N+1];
		for(int i=0;i<N+1;i++){
			network[i] = new ArrayList<>();
		}
		// network = new int[N+1][N+1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// network[p][q] = r;
			// network[q][p] = r;
			//0 : 채널 번호, 1 : USADO
			network[p].add(new int[]{q,r});
			network[q].add(new int[]{p,r});
		}

		question = new int[Q][2];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			question[i][0] = Integer.parseInt(st.nextToken());
			question[i][1] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int turn = 0; turn < Q; turn++) {
			int count = recommendation(turn);
			sb.append(count);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int recommendation(int turn) {
		int k = question[turn][0];
		int v = question[turn][1];

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		visit[v] = true;
		queue.add(v);
		int count = 0;

		while(!queue.isEmpty()){
			int current = queue.poll();

			for(int[] channel : network[current]){
				int num = channel[0];
				int usado = channel[1];
				if(!visit[num] && usado >= k){
					visit[num] = true;
					queue.add(num);
					count++;
				}
			}
		}

		return count;
	}
}
