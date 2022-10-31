package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class 단어정렬{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Set<String> filtering = new HashSet<>();
		for(int i=0;i<N;i++){
			filtering.add(br.readLine());
		}

		List<String> answer = new ArrayList<>();
		for(String s : filtering){
			answer.add(s);
		}

		Collections.sort(answer, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				int result = o1.length()-o2.length();
				if(result == 0){
					result = o1.compareTo(o2);
				}
				return result;
			}
		});

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<answer.size();i++){
			sb.append(answer.get(i)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
