package org.algorithm.java.hyunjong.Algorithm.BOJ.위상정렬;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class 음악프로그램{
	static int[] indegree;
	static List<Integer>[] edges;
	static int indegreeCount;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		indegreeCount = 0;
		indegree = new int[N+1];
		edges = new List[N+1];
		for(int i=1;i<=N;i++){
			edges[i] = new ArrayList<>();
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());

			if(n==0) continue;

			int prevSinger = Integer.parseInt(st.nextToken());
			for(int j=1;j<n;j++){
				int singer = Integer.parseInt(st.nextToken());

				indegree[singer]++;
				edges[prevSinger].add(singer);
				prevSinger = singer;
				indegreeCount++;
			}
		}

		Queue<Integer> sequence = topologicalSort();

		StringBuilder sb = new StringBuilder();
		if(!isValid()){
			sb.append("0");
		}else{
			while(!sequence.isEmpty()){
				sb.append(sequence.poll()).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static Queue<Integer> topologicalSort(){
		Queue<Integer> result = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();

		for(int i=1;i<indegree.length;i++){
			if(indegree[i]==0) queue.offer(i);
		}

		while(!queue.isEmpty()){
			int current = queue.poll();

			result.offer(current);
			for(int link : edges[current]){
				if(--indegree[link] == 0) queue.offer(link);
				indegreeCount--;
			}
		}

		return result;
	}

	static boolean isValid(){
		return indegreeCount == 0;
	}
}
