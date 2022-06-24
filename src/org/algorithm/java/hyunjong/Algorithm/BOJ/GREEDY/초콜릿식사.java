package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 초콜릿식사 {

	static int minSize;
	static int divisionCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());

		int size = 0;
		int idx = 0;
		while (size < K) {
			size = (int)Math.pow(2, idx++);
		}

		minSize = size;
		divisionCount = 0;

		while(K>0){
			if(K>=size){
				K -= size;
			}else{
				size /= 2;
				divisionCount++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(minSize);
		sb.append(' ');
		sb.append(divisionCount);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
