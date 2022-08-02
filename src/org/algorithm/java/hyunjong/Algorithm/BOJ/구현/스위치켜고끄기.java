package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++){
			String s = st.nextToken();
			if(s.equals("1")) switches[i] = true;
		}

		int S = Integer.parseInt(br.readLine());
		for(int i=0;i<S;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if(s == 1){
				int idx = n;
				int j=1;
				while(idx <= N){
					switches[idx] = !switches[idx];
					j++;
					idx = n*j;
				}
			}else{
				switches[n] = !switches[n];

				int leftIdx = n-1;
				int rightIdx = n+1;
				while(leftIdx>0 && rightIdx<=N && switches[leftIdx] == switches[rightIdx]){
					switches[leftIdx] = !switches[leftIdx];
					switches[rightIdx] = !switches[rightIdx];
					leftIdx--;
					rightIdx++;
				}
			}
		}

		int count=0;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++){
			if(count >= 20){
				sb.append("\n");
				count = 0;
			}

			int turn = switches[i] ? 1 : 0;
			sb.append(turn);
			sb.append(" ");
			count++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
