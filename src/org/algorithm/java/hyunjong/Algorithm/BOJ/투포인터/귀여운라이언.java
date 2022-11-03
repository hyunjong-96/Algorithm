package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;
/*
슬라이딩 윈도우를 이용하여 구현

start와 end의 범위에 lionCount가 K가 될때까지 end를 이동시킨다.
그리고 start가 1에 위치할때까지 start를 이동시킨다.

그 후
lionCount가 K라면 start를 다음 라이언인형이 있는곳까지 이동시킨다.
start가 다음 라이언인형이 있는곳까지 이동하였기 때문에 현재 lionCount는 K-1이므로 end가 다음 라이언 인형이 있는곳까지 이동하여
lionCount를 K로 만들어준다.
 */
public class 귀여운라이언{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dolls = new int[N];

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			dolls[i] = Integer.parseInt(st.nextToken());
		}

		int start=0;
		int end = 0;
		int lionCount = 0;
		int answer = 0;

		//lionCount가 k가 될때까지 end 이동
		while(end<N && lionCount < K){
			if(dolls[end] == 1) lionCount++;
			end++;
		}
		while(start<end && dolls[start]!=1){
			start++;
		}

		answer = end-start;
		//end가 끝까지 갈때까지 lion을 k개 유지하며 start와 end 이동
		if(lionCount < K) answer = -1;
		else{
			while(true){
				if(lionCount >= K){
					if(lionCount == K) answer = Math.min(answer, end-start);
					lionCount--;
					start++;
					while(start<end && dolls[start] != 1){
						start++;
					}
				}else{
					if(end>=N) break;
					if(dolls[end] == 1) lionCount++;
					end++;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
