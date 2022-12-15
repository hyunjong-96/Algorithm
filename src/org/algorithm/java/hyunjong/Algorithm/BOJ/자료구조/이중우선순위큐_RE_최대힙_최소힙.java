package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
public class 이중우선순위큐_RE_최대힙_최소힙{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			MyQueue queue = new MyQueue();
			int k = Integer.parseInt(br.readLine());

			for(int i=0;i<k;i++){
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String operation = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if(operation.equals("I")){
					queue.input(n);
				}else{
					queue.delete(n);
				}
			}

			if(queue.size == 0){
				sb.append("EMPTY");
			}else{
				sb.append(queue.getMax()).append(" ").append(queue.getMin());
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static class MyQueue{
		PriorityQueue<Integer> maxQueue;
		PriorityQueue<Integer> minQueue;
		Map<Integer, Integer> map;
		int size;

		public MyQueue(){
			this.map = new HashMap<>();
			this.maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
			this.minQueue = new PriorityQueue<>();
			this.size = 0;
		}

		public void input(int v){
			this.maxQueue.offer(v);
			this.minQueue.offer(v);
			this.size++;
			this.map.put(v, map.getOrDefault(v, 0)+1);
		}

		public void delete(int type){
			if(size == 0) return;

			if(type == 1){
				removeNotExist(maxQueue);
				int out = this.maxQueue.poll();
				map.put(out, map.get(out)-1);
				if(map.get(out)==0) map.remove(out);
			}else{
				removeNotExist(minQueue);
				int out = this.minQueue.poll();
				map.put(out, map.get(out)-1);
				if(map.get(out)==0) map.remove(out);
			}

			this.size--;
		}

		public int getMax(){
			removeNotExist(maxQueue);
			return this.maxQueue.peek();
		}

		public int getMin(){
			removeNotExist(minQueue);
			return this.minQueue.peek();
		}

		public void removeNotExist(PriorityQueue<Integer> pq){
			while(!map.containsKey(pq.peek())){
				pq.poll();
			}
		}
	}
}