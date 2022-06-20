package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 종이접기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++){
			String rule = br.readLine();
			validation(rule, sb);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static public void validation(String rule, StringBuilder sb){

		boolean isCorrect = true;

		int len = rule.length();
		int idx = len/2;

		while(idx!=0){
			for(int i=0,j=len-1;i<idx;i++,j--){
				if(rule.charAt(i) == rule.charAt(j)){
					isCorrect = false;
					break;
				}
			}

			if(!isCorrect) break;

			len /= 2;
			idx /= 2;
		}

		if(isCorrect){
			sb.append("YES");
		}else{
			sb.append("NO");
		}
		sb.append("\n");
	}
}
