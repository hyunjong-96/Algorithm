package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] leaks = new int[N];
		for(int i=0;i<N;i++){
			leaks[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(leaks);

		double pos=0;
		int count=0;
		for(int leak : leaks){
			if(pos < leak-0.5){
				pos = leak-0.5;
				pos += L;
				count++;
			}else if(pos < leak+0.5){
				pos += L;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
