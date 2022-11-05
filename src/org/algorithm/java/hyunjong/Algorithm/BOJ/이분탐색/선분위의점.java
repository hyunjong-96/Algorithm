package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
각 선분에서 모든 점을 포인터로 이동하며 검사하면 O(MN)으로 시간초과 발생

이분탐색을 통해 선분의 앞 부분을 lowerBound로 찾고 뒷 부분을 upperBound로 찾는다.
뒷부분이 upperBound로 찾은것이기 때문에 결과-1 위치가 lowerBound결과보다 작다면 선분 범위안에 점이 포함되지 않는다.
이는 O(MlongN)으로 해결
 */
public class 선분위의점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		int[] points = new int[N];

		for(int i=0;i<N;i++){
			points[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int startE = Integer.parseInt(st.nextToken());
			int endE = Integer.parseInt(st.nextToken());

			int startIndex = lowerBound(points, startE);

			int endIndex = upperBound(points, endE);
			if(endIndex-1 < startIndex){
				sb.append(0).append("\n");
				continue;
			}

			sb.append(endIndex-startIndex).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int lowerBound(int[] points, int target){
		int start = 0;
		int end = points.length;

		while(start<end){
			int mid = (start+end)/2;

			if(points[mid] < target){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		return end;
	}

	static int upperBound(int[] points, int target){
		int start = 0;
		int end = points.length;

		while(start<end){
			int mid = (start+end)/2;

			if(points[mid]<=target){
				start = mid+1;
			}else{
				end = mid;
			}
		}
		return end;
	}
}
