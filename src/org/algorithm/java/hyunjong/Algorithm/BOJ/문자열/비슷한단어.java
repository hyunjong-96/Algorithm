package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 비슷한단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] alp = new int[26];
		int N = Integer.parseInt(br.readLine());
		String first = br.readLine();
		for(int i=0;i<first.length();i++){
			char c = first.charAt(i);

			alp[c-'A']++;
		}
		N--;

		int count=0;
		while(N-->0){
			String compare = br.readLine();

			int[] comAlp = alp.clone();
			int same = 0;
			for(int i=0;i<compare.length();i++){
				char c = compare.charAt(i);
				if(comAlp[c-'A'] > 0){
					same++;
					comAlp[c-'A']--;
				}
			}

			//단어의 길이가 같을때
			if(first.length() == compare.length()){
				//같은 문자의 개수가 첫번째 단어의 개수와 같거나(다 같은경우)
				//같은 문자의 개수가 첫번째 단어의 문자보다 하나 적을 때
				if(same == first.length() || same+1 == first.length()) count++;
			}
			//비교 단어의 문자가 1개 더 많을때
			else if(first.length()+1 == compare.length() && same == first.length()){
				count++;
			}
			//첫번째 단어의 문자가 1개 더 많을때
			else if(first.length() == compare.length()+1 && same == compare.length()){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
