package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 좌표압축 {
	static int N;
	static int[] arr;
	static int[] arr2;
	//이분 탐색을 이용한 좌표압축
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			set.add(num);
		}

		arr2 = new int[set.size()];
		int i=0;
		for(int num : set){
			arr2[i++] = num;
		}
		Arrays.sort(arr2);

		StringBuilder sb = new StringBuilder();
		for(int num : arr){
			int result = binarySearch(num);
			sb.append(result);
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int binarySearch(int target){
		int start=0;
		int end=arr2.length-1;

		while(start<=end){
			int mid = (start+end)/2;

			if(arr2[mid]>target){
				end = mid-1;
			}else if(arr2[mid]<target){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}

	//Map을 이용한 좌표압축
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	N = Integer.parseInt(br.readLine());
	// 	arr = new int[N];
	// 	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	// 	for(int i=0;i<N;i++){
	// 		arr[i] = Integer.parseInt(st.nextToken());
	// 	}
	//
	// 	HashMap<Integer, Integer> map = new HashMap<>();
	//
	// 	arr2 = arr.clone();
	// 	Arrays.sort(arr2);
	//
	// 	int rank=0;
	// 	for(int i=0;i<arr2.length;i++){
	// 		int num = arr2[i];
	// 		if(!map.containsKey(num)){
	// 			map.put(num, rank);
	// 			rank++;
	// 		}
	// 	}
	//
	// 	StringBuilder sb = new StringBuilder();
	// 	for(int target : arr){
	// 		sb.append(map.get(target));
	// 		sb.append(" ");
	// 	}
	//
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }