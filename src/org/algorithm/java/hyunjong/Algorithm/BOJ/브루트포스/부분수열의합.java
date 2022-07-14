package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부분수열의합 {
	static int N;
	static int S;
	static int[] sequence;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		sequence = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		answer=0;
		setSum(0,0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setSum(int sum, int idx){

		for(int i=idx;i<N;i++){
			if(!visit[i]){
				visit[i] = true;
				if(sum+sequence[i]==S) {
					answer++;
				}
				setSum(sum+sequence[i], i+1);
				visit[i] = false;
			}
		}
	}
}
