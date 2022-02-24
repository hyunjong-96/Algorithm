package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//9466
public class 텀_프로젝트 {
	static LinkedList<Integer>[] graph;
	static boolean[] checked;
	static int count;
	static int[] link;
	static boolean[] finished;

	public static void main(String[] args) throws IOException {
		//자기 자신을 가리키는 node는 미리 checked에 true처리
		//bfs로 연결된 노드를 마지막까지 돌렸는데, 마지막에 확인한 노드가 출발할때의 노드가 아니면 count+1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());//테스크케이스 수
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());//학생 수
			link = new int[N];
			checked = new boolean[N];
			finished = new boolean[N];
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int next = Integer.parseInt(st.nextToken());
				link[j] = next;
				if (j == next - 1){
					finished[j] = true;
					count++;
				}
			}

			for (int index = 0; index < N; index++) {
				if(!finished[index]){
					dfs(index);
				}
			}
			bw.write(String.valueOf(N-count));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int now){
		if(checked[now]){
			finished[now] = true;
			count++;
		}else{
			checked[now] = true;
		}

		int next = link[now]-1;	//line[now]에 있는 value는 연결된 노드값이므로 index를 줘야하기 때문에 -1
		if(!finished[next]) dfs(next);

		finished[now] = true;
	}

	// 	int T = Integer.parseInt(br.readLine());
	// 	for (int i = 0; i < T; i++) {
	// 		int N = Integer.parseInt(br.readLine());
	// 		graph = new LinkedList[N];
	// 		checked = new boolean[N];
	// 		int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	// 		for(int j = 0; j<N;j++){
	// 			graph[j] = new LinkedList<>();
	// 			graph[j].add(students[j]);
	// 			if(j == students[j]-1) checked[j] = true;	//자기 자신을 가리키고 있으면 true
	// 		}//초기화
	//
	// 		count=0;
	// 		for(int n = 0; n<N;n++){
	// 			bsf(n);
	// 		}
	// 		bw.write(String.valueOf(count));
	// 		bw.write("\n");
	// 	}
	// 	bw.flush();
	// 	bw.close();
	// }
	//
	// private static void bsf(int index){
	// 	if(!checked[index]){
	// 		Queue<Integer> queue = new LinkedList<>();
	// 		queue.add(index);
	// 		checked[index] = true;
	// 		int endIndex = index;
	// 		while(!queue.isEmpty()){
	// 			int cur = queue.poll();
	//
	// 			for(int next : graph[cur]){
	// 				endIndex = next-1;
	// 				if(!checked[next-1]){
	// 					queue.add(next-1);
	// 					checked[next-1] = true;
	// 				}
	// 			}
	// 		}
	// 		if(index != endIndex) count++;
	// 	}
	// }
}
