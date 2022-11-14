package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
public class 알파벳개수{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();

		int[] charCountArr = new int[26];
		for(int i=0;i<text.length();i++){
			char c = text.charAt(i);
			charCountArr[c-'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<26;i++){
			sb.append(charCountArr[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
