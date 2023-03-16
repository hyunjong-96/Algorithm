package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class 트리lv4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int caseCount = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			List<Integer>[] edges = new List[N + 1];
			boolean[] check = new boolean[N + 1];

			for(int i=1;i<=N;i++){
				edges[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}


			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!check[i]) {
					boolean isTree = true;
					count++;
					Queue<int[]> queue = new LinkedList();
					queue.offer(new int[] {i, 0});
					check[i] = true;
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int child = current[0];
						int parent = current[1];
						// check[child] = true;
						for (int link : edges[child]) {
							if (check[link]) {
								if(link != parent){
									isTree = false;
								}
							}
							else{
								check[link] = true;
								queue.offer(new int[] {link, child});
							}
						}
					}
					if(!isTree) count--;
				}
			}

			sb.append("Case ").append(caseCount).append(": ");
			if(count == 0){
				sb.append("No trees.");
			}
			else if(count == 1){
				sb.append("There is one tree.");
			}
			else{
				sb.append("A forest of ").append(count).append(" trees.");
			}
			sb.append("\n");
			caseCount ++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
