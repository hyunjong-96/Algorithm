package org.algorithm.java.hyunjong.Algorithm.BOJ.위상정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 계보복원가호석 {
	static int N;
	static Map<String, Integer> idMap;
	static String[] names;
	static List<Integer>[] edges;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		idMap = new HashMap<>();	//이름을 id로
		names = new String[N];	//id를 이름으로
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int id = 0;
		for(int i=0;i<N;i++){
			String name = st.nextToken();
			names[id] = name;
			idMap.put(name, id++);
		}

		int M = Integer.parseInt(br.readLine());
		edges = new List[N];
		indegree = new int[N];
		for(int i=0;i<N;i++) edges[i] = new ArrayList<>();

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int x = idMap.get(st.nextToken());
			int y = idMap.get(st.nextToken());

			indegree[x]++;
			edges[y].add(x);
		}

		List<String> family = new ArrayList<>();
		Child[] childs = new Child[N];

		topologicalSort(family, childs);

		Collections.sort(family);
		StringBuilder sb = new StringBuilder();
		sb.append(family.size()).append("\n");
		for(String f : family) sb.append(f).append(" ");
		sb.append("\n");

		Arrays.sort(childs);
		for(Child c : childs){
			sb.append(c.name).append(" ");
			sb.append(c.childs.size());
			if(c.childs.size() > 0){
				sb.append(" ");
				while(!c.childs.isEmpty()){
					sb.append(c.childs.poll()).append(" ");
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void topologicalSort(List<String> family, Child[] childs){
		Queue<Integer> queue = new LinkedList<>();

		for(int i=0;i<N;i++){
			if(indegree[i] == 0){
				queue.offer(i);
				family.add(names[i]);
			}
		}

		while(!queue.isEmpty()){
			int current = queue.poll();

			childs[current] = new Child(current);

			for(int link : edges[current]){
				indegree[link]--;
				if(indegree[link] == 0){
					queue.offer(link);
					childs[current].putChilds(link);
				}
			}
		}
	}

	static class Child implements Comparable<Child>{
		String name;
		PriorityQueue<String> childs;

		public Child(int id){
			name = names[id];
			childs = new PriorityQueue<>();
		}

		public void putChilds(int child){
			childs.offer(names[child]);
		}

		@Override
		public int compareTo(Child o) {
			return this.name.compareTo(o.name);
		}
	}
}
