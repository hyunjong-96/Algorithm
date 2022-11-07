package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.*;
public class 복호화{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Q = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(Q-- > 0){
			String text = br.readLine();

			int[] count = new int[26];

			for(int i=0;i<text.length();i++){
				char c = text.charAt(i);
				if(c==' ') continue;

				count[c-'a']++;
			}

			int[] maxCount = findMaxCount(count);
			boolean isOnly = isMaxCountOnly(count, maxCount);

			char answer = isOnly ? (char)('a'+maxCount[0]) : '?';

			sb.append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean isMaxCountOnly(int[] count, int[] maxCount){
		for(int i = 0;i<count.length;i++){
			int v = count[i];
			if(maxCount[0] != i &&  maxCount[1] <= v) return false;
		}
		return true;
	}

	static int[] findMaxCount(int[] count){
		int maxV = 0;
		int maxIdx = 0;
		for(int i = 0;i<count.length;i++){
			int v = count[i];
			if(maxV < v){
				maxV = v;
				maxIdx = i;
			}
		}

		return new int[]{maxIdx, maxV};
	}
}
