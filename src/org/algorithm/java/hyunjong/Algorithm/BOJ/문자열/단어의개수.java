package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 단어의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] strArr = br.readLine().split(" ");
		int count = 0;
		for(String s : strArr){
			if(s.length()>0) count++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
