package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 수정렬하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		for(int i=0;i<N;i++){
			array[i] = (Integer.parseInt(br.readLine()));
		}
		Arrays.sort(array);
		for(int i : array){
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		// bw.write(sb.toString());
		// bw.flush();
		// bw.close();
	}
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	StringBuilder sb = new StringBuilder();
	//
	// 	int N = Integer.parseInt(br.readLine());
	// 	List<Integer> list = new ArrayList();
	// 	for(int i=0;i<N;i++){
	// 		list.add(Integer.parseInt(br.readLine()));
	// 	}
	// 	Collections.sort(list);
	// 	for(Integer i : list){
	// 		sb.append(i).append("\n");
	// 	}
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }
}
