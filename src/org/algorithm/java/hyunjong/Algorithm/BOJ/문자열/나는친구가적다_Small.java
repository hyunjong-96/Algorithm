package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
public class 나는친구가적다_Small{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		String pattern = br.readLine();

		text = text.replaceAll("[0-9]", "");

		boolean result = false;
		for(int i=0;i<text.length();i++){
			boolean isMatch = true;
			int index = i;
			for(int j=0;j<pattern.length();j++){
				if(text.charAt(index++) != pattern.charAt(j)){
					isMatch = false;
					break;
				}
			}
			if(isMatch){
				result = true;
				break;
			}
		}

		String answer = result ? "1" : "0";
		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
