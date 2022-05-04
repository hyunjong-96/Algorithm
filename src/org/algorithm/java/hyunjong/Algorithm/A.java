package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A {

	static int INF = 100000000;
	static List<List<Node>> graph;
	static int[] distance;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<Node> excel = new LinkedList<>();
		Node[] nodes = new Node[5];

		List<List<Node>> nodeList = new ArrayList<>();
		for(int i=0;i<=10;i++){
			nodeList.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for(int i=0;i<=V;i++){
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Node(v,w));
		}

		distance = new int[V+1];
		visit = new boolean[V+1];
		Arrays.fill(distance, INF);
		distance[K] = 0;
		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i< distance.length;i++){
			int d = distance[i];
			if(d == INF){
				sb.append("INF");
			}else{
				sb.append(String.valueOf(d));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dijkstra(int start){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()){
			Node currentNode = pq.poll();
			if(visit[currentNode.index]) continue;
			visit[currentNode.index] = true;

			for(Node linkedNode : graph.get(currentNode.index)){
				if(linkedNode.distance+ currentNode.distance < distance[linkedNode.index]){
					pq.add(new Node(linkedNode.index, linkedNode.distance+currentNode.distance));
					distance[linkedNode.index] = linkedNode.distance+currentNode.distance;
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int index;
		int distance;
		public Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o){
			return this.distance - o.distance;
		}
	}
}
