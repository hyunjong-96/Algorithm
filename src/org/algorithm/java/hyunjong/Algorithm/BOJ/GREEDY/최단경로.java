package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
다익스트라 알고리즘.
다익스트라 알고리즘은 출발노드에서 인접한 노드를 따라 도착 노드까지의 최단 거리를 구하는 알고리즘
단 간선의 가중치가 음수인 간선을 포함할수 없다.

알고리즘 순서
1. 출발 노드 설정
2. 각 노드들의 인접 노드 저장
3. 출발 노드를 기준으로 각 인접 노드 또는 갱신된 노드 중 거리가 가장 짧은 노드 선택
4. 방문하지 않았고 초기의 최단 거리와 촐발노드에서 해당 노드까지의 거리 + 해당 노드와 인접한 노드 간의 거리 중 후자의 길이가 더 짧다면 PQ에 저장
5. 3,4를 반복하다보면 출발 노드에서의 최단 거리를 저장한 배열이 완성되어있다.

 */
public class 최단경로 {
	// static int V;
	// static int E;
	// static int K;
	// static int INF = Integer.MAX_VALUE;
	// static List<List<Node>> graph = new ArrayList<>();
	// static boolean[] visit;
	// static int[] d;
	//
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	StringBuilder sb = new StringBuilder();
	// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 	V = Integer.parseInt(st.nextToken());
	// 	E = Integer.parseInt(st.nextToken());
	// 	K = Integer.parseInt(br.readLine());
	//
	// 	//노드 연결 정보 초기화
	// 	for (int i = 0; i < V + 1; i++) {
	// 		graph.add(new ArrayList<>());
	// 	}
	// 	//최단 거리 테이블 초기화
	// 	d = new int[V + 1];
	// 	Arrays.fill(d, INF);
	// 	//방문여부 초기화
	// 	visit = new boolean[V + 1];
	// 	//주어지는 입력 값에 따라 노드 연결정보(graph)초기화
	// 	for (int i = 0; i < E; i++) {
	// 		st = new StringTokenizer(br.readLine(), " ");
	// 		int from = Integer.parseInt(st.nextToken());
	// 		int to = Integer.parseInt(st.nextToken());
	// 		int distance = Integer.parseInt(st.nextToken());
	// 		graph.get(from).add(new Node(to, distance));
	// 	}
	//
	// 	dijkstra(K);
	// 	for (int i = 1; i < d.length; i++) {
	// 		int distance = d[i];
	// 		if (distance == Integer.MAX_VALUE) {
	// 			sb.append("INF");
	// 		} else {
	// 			sb.append(d[i]);
	// 		}
	// 		sb.append("\n");
	// 	}
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }
	//
	// static void dijkstra(int start) {
	// 	//1.거쳐가거나 시작할 노드를 방문 후 방문 처리
	// 	//2.방문한 노드에서 방문할수 있는 노드를 탐색
	// 	//3.탐색된 노드들의 계산된 거리 비용이 현재 저장된 최단거리보다 적을 경우 최단거리 갱신
	// 	//4.최단거리가 갱신된 노드들 중 가장 적은 거리를 가진 노드로 이동 후 방문 처리
	// 	PriorityQueue<Node> pq = new PriorityQueue<>();
	// 	d[start] = 0;
	// 	pq.offer(new Node(start, 0));
	//
	// 	while (!pq.isEmpty()) {
	// 		Node current = pq.poll();
	//
	// 		if (visit[current.node])
	// 			continue;
	// 		visit[current.node] = true;
	//
	// 		List<Node> linkedNodeList = graph.get(current.node);
	// 		for (Node linkedNode : linkedNodeList) {
	// 			//최단거리 테이블에 있는 거리보다 시작노드에서 현재 노드까지의 거리 + 다음 연결 노드까지의 거리가
	// 			//작다면 최단거리 테이블의 거리를 갱신해주고 pq에 해당 노드의 정보를 넣어준다.
	// 			if (d[linkedNode.node] > current.distance + linkedNode.distance) {
	// 				d[linkedNode.node] = current.distance + linkedNode.distance;
	// 				pq.offer(new Node(linkedNode.node, d[linkedNode.node]));
	// 			}
	// 		}
	// 	}
	// }
	//
	// static class Node implements Comparable<Node> {
	// 	int node;
	// 	int distance;
	//
	// 	public Node(int node, int distance) {
	// 		this.node = node;
	// 		this.distance = distance;
	// 	}
	//
	// 	@Override
	// 	public int compareTo(Node o) {
	// 		return Integer.compare(this.distance, o.distance);
	// 	}
	// }
	static int INF = 100000000;
	static int V;
	static int E;
	static int K;
	static List<List<Node>> graph = new ArrayList<>();
	static boolean[] visit;
	static int[] distance;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		//각 노드의 인접 노드 저장
		for(int i=0;i<V+1;i++){
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}

		//시작점을 기준으로 각 노드의 최단 거리 배열 초기화
		distance = new int[V+1];
		visit = new boolean[V+1];
		Arrays.fill(distance, INF);
		distance[K] = 0;

		dijkstra(K);

		//최단 거리 배열의 값을 index별로 반환, 경로가 존재하지 않다면 INF출력
		for(int i=1;i<V+1;i++){
			if(distance[i] == INF){
				sb.append("INF");
			}else{
				sb.append(distance[i]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	//방문한 노드를 제외하고 시작노드와 인접하거나 갱신된 노드 중 거리가 가장 짧은 순으로 탐색
	static void dijkstra(int start){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()){
			Node node = pq.poll();

			if(visit[node.index]) continue;
			visit[node.index] = true;

			//거리가 가장 짧은 노드의 인접노드를 가져와 현재 저장되어있는 인접노드의 최단거리와
			//출발 노드와 node까지의 거리 + node와 탐색할 인접노드 까지의 거리가
			//저장되어있는 인접노드의 최단거리보다 짧다면
			//최단거리 배열의 인접 노드의 값을 갱신시켜주고
			//pq에 해당 인접 노드의 정보를 저장해준다.
			List<Node> linkedNodeList = graph.get(node.index);
			for(Node linkedNode : linkedNodeList){
				if(node.distance+linkedNode.distance < distance[linkedNode.index]){
					distance[linkedNode.index] = node.distance + linkedNode.distance;
					pq.add(new Node(linkedNode.index, distance[linkedNode.index]));
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
		public int compareTo(Node n){
			return Integer.compare(this.distance, n.distance);
		}
	}
}
