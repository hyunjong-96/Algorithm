package org.algorithm.java.hyunjong.Algorithm.BOJ.비트마스킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
초기 막대기 길이가 64 이므로 나올수 있는 막대기의 길이는 1,2,4,8,16,32,64 이다.
초기 막대기 길이가 64은 2진법으로 나타내면 1 0 0 0 0 0 0 이다.
예를 들어 X가 23을 2진법으로 나타내면 0 0 1 0 1 1 1 이다.
즉 필요한 나무막대기의 길이는 16, 4, 2, 1. 즉 4개의 막대기가 필요하다.
비트 마스킹으로 나타내서 0부터 6자릿수의 값을 X의 존재여부로 파악하면 필요한 막대기의 갯수를 구할수있다.
 */
public class 막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i = 0; i < 7; i++) {
			if ((X & 1<<i) != 0)
				count++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	int X = Integer.parseInt(br.readLine());
	//
	// 	int result = cut(X);
	// 	bw.write(String.valueOf(result));
	// 	bw.flush();
	// 	bw.close();
	// }
	//
	// static int cut(int X){
	// 	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
	// 		@Override
	// 		public int compare(Integer o1, Integer o2){
	// 			return o1-o2;
	// 		}
	// 	});
	//
	// 	if(X == 64) return 1;
	//
	// 	int sum = 64;
	// 	pq.add(64);
	//
	// 	while(!pq.isEmpty()){
	// 		int stick = pq.poll();
	// 		int half = stick/2;
	// 		sum -= half;
	//
	// 		if(sum >= X){
	// 			pq.offer(half);
	// 			if(sum == X){
	// 				return pq.size();
	// 			}
	// 		}else{
	// 			pq.offer(half);
	// 			pq.offer(half);
	// 			sum += half;
	// 		}
	// 	}
	// 	return -1;
	// }
}
