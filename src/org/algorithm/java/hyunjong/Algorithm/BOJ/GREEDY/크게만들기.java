package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String number = br.readLine();

		Deque<Character> dq = new LinkedList<>();

		int idx = 0;
		int k = K;
		while(idx < N){
			char num = number.charAt(idx++);

			while(k > 0 && !dq.isEmpty() && dq.getLast() < num){
				dq.pollLast();
				k--;
			}
			dq.offerLast(num);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N-K;i++){
			sb.append(dq.pollFirst());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	//시간초과 O(N^2)
	// static int N;
	// static int K;
	// static int[] number;
	// static List<Number> numbers;
	// static Queue<Integer> queue;
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 	N = Integer.parseInt(st.nextToken());
	// 	K = Integer.parseInt(st.nextToken());
	//
	// 	String n = br.readLine();
	// 	number = new int[n.length()];
	// 	numbers = new ArrayList<>();
	// 	queue = new LinkedList<>();
	//
	// 	for(int i=0;i<n.length();i++){
	// 		number[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
	// 		numbers.add(new Number(i, number[i]));
	// 	}
	//
	// 	Collections.sort(numbers);
	//
	// 	String answer = start();
	// 	bw.write(answer);
	// 	bw.flush();
	// 	bw.close();
	// }
	//
	// static void setNumber(){
	// 	int limit = K;
	// 	int prevIdx = 0;
	//
	// 	while(limit < N){
	// 		for(int i=0;i<numbers.size();i++){
	// 			if(numbers.get(i).idx > prevIdx && numbers.get(i).idx <= limit){
	// 				limit++;
	// 				prevIdx = numbers.get(i).idx;
	// 				queue.offer(numbers.get(i).num);
	// 				numbers.remove(numbers.get(i));
	// 				break;
	// 			}else if(numbers.get(i).idx < prevIdx){
	// 				numbers.remove(numbers.get(i));
	// 			}
	// 		}
	// 	}
	// }
	//
	// static String start(){
	// 	setNumber();
	//
	// 	StringBuilder sb = new StringBuilder();
	// 	while(!queue.isEmpty()){
	// 		sb.append(queue.poll());
	// 	}
	//
	// 	return sb.toString();
	// }
	//
	// static class Number implements Comparable<Number>{
	// 	int idx;
	// 	int num;
	// 	public Number(int idx, int num){
	// 		this.idx = idx;
	// 		this.num = num;
	// 	}
	//
	// 	@Override
	// 	public int compareTo(Number o1){
	// 		int result = o1.num - this.num;
	// 		if(result == 0){
	// 			result = this.idx - o1.idx;
	// 		}
	// 		return result;
	// 	}
	// }
}
