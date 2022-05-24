package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 회전초밥 {
	static int N;
	static int d;
	static int k;
	static int c;
	static int[] susi;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		susi = new int[N];
		visit = new int[d+1];
		for(int i=0;i<N;i++){
			susi[i] = Integer.parseInt(br.readLine());
		}

		bw.write(String.valueOf(eat()));
		bw.flush();
		bw.close();
	}

	static int eat(){
		int total=0;
		int max=0;
		for(int i=0;i<k;i++){
			if(visit[susi[i]]==0) total++;
			visit[susi[i]]++;
		}
		// if(visit[c]==0) total++;
		max = total;

		for(int i=1;i<N;i++){
			visit[susi[i-1]]--;
			if(visit[susi[i-1]] == 0) total--;
			visit[susi[(i+k-1)%N]]++;
			if(visit[susi[(i+k-1)%N]] == 1) total++;

			if(max<=total){
				if(visit[c]==0){
					max = total + 1;
				}else{
					max = total;
				}
			}
		}

		return max;
	}
}
