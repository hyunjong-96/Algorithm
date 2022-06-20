package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 등수매기기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] anticipateGrade = new int[N];

		for(int i=0;i<N;i++){
			anticipateGrade[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(anticipateGrade);

		long answer=0;
		int grade=1;
		for(int i=0;i<N;i++){
			answer += Math.abs(anticipateGrade[i]-grade);
			grade++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
