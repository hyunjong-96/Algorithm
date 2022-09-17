package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 밀비급일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while(true){
			String word = br.readLine();
			if(word.equals("END")) break;

			StringBuilder subSB = new StringBuilder(word);
			subSB.reverse();
			sb.append(subSB);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
