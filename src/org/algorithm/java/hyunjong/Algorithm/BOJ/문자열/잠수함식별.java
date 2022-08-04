package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 잠수함식별 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String regex = "(100+1+|01)+";

		String answer = "NOISE";
		if(s.matches(regex)){
			answer = "SUBMARINE";
		}
		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
