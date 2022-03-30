package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
프린터 큐에서 현재 맨 앞에 있는 문서보다 중요도가 높은 문서가 큐에 존재한다면 큐 맨 뒤로 이동 시킨다.
모든 문서의 우선순위를 PriorityQueue에 넣어서 내림차순 시키고
모든 문서가 프린트 될때까지 반복 시킨다.
해당 반복문에서 Priority의 맨 앞의 우선순위보다 현재 문서의 우선순위가 낮다면 Queue맨 뒤로 문서를 보내게 된다.
만약 Priority의 맨 앞 우선순위와 현재 문서의 우선순위가 같다면 PriorityQueue와 Queue의 문서를 제거해주고 출력 횟수 count++;
이를 반복하면서 M의 우선순위가 PriorityQueue의 맨 앞에 나오고 현재 문서가 M이 되도록 한다.
 */
public class 프린터큐 {
	static class Document{
		int index;
		int priority;

		public Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Integer> pq;
		Queue<Document> queue;
		int count;
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			pq = new PriorityQueue<>(Comparator.reverseOrder());
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				int p = Integer.parseInt(st.nextToken());
				pq.add(p);
				queue.add(new Document(i, p));
			}

			count = 0;
			while(!queue.isEmpty()){
				Document currentDocument = queue.poll();
				if(pq.peek() == currentDocument.priority){
					pq.poll();
					count++;
					if(currentDocument.index == M) break;
				}else{
					queue.add(currentDocument);
				}
			}

			sb.append(count).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
