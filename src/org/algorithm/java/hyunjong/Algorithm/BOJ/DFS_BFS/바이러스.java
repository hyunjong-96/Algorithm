package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
	static boolean[] visit;
	static LinkedList<Integer>[] netWork;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		netWork = new LinkedList[101];
		visit = new boolean[101];
		for (int i = 0; i <= 100; i++) {
			netWork[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			netWork[node1].add(node2);
			netWork[node2].add(node1);
		}

		int count = bfs();
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static int bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		int count = 0;
		visit[1] = true;

		while(!queue.isEmpty()){
			int current = queue.poll();
			LinkedList<Integer> child = netWork[current];

			for(int c : child){
				if(!visit[c]){
					queue.add(c);
					visit[c] = true;
					count++;
				}
			}
		}
		return count;
	}
}
