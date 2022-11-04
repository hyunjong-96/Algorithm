package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
public class 찾기{
	static int matchingCount;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		String pattern = br.readLine();

		sb = new StringBuilder();
		matchingCount = 0;
		KMP(text, pattern);

		String result = String.valueOf(matchingCount+"\n");
		bw.write(result+sb.toString().trim());
		bw.flush();
		bw.close();
	}

	static void KMP(String text, String pattern){
		int[] table = makeTable(pattern);

		int N = text.length();
		int M = pattern.length();
		int j=0;
		for(int i=0;i<N;i++){
			while(j>0 && text.charAt(i) != pattern.charAt(j)){
				j = table[j-1];
			}

			if(text.charAt(i) == pattern.charAt(j)){
				if(j == M-1){
					int findPos = i-M+2;
					sb.append(findPos).append(" ");
					matchingCount++;
					j = table[j];
				}else{
					j++;
				}
			}
		}
	}

	static int[] makeTable(String pattern){
		int M = pattern.length();
		int[] table = new int[M];
		int j = 0;
		for(int i=1;i<M;i++){
			while(j>0 && pattern.charAt(j) != pattern.charAt(i)){
				j = table[j-1];
			}

			if(pattern.charAt(j) == pattern.charAt(i)){
				table[i] = ++j;
			}
		}
		return table;
	}
}
