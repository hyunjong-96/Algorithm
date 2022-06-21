package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문서검색 {
	public static void main(String[] args) throws IOException {
		// startWith 풀이
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// String line = br.readLine();
		// String pattern = br.readLine();
		//
		// int count=0;
		// while(line.length() > 0){
		// 	if(line.startsWith(pattern)){
		// 		count++;
		// 		line = line.substring(pattern.length());
		// 	}else{
		// 		line = line.substring(1);
		// 	}
		// }
		//
		// bw.write(String.valueOf(count));
		// bw.flush();
		// bw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String sentence = br.readLine();
		String word = br.readLine();

		int flag=0;
		int w = 0;
		int count = 0;
		boolean isCheck = false;
		for (int s = 0; s < sentence.length(); s++) {
			char c = sentence.charAt(s);

			if(c == word.charAt(w)){
				isCheck = true;
				if(w < word.length()-1){
					w++;
				}else{
					w = 0;
					flag = s;
					count++;
				}
			}else{
				w = 0;
				if(isCheck){
					s = flag++;
				};
				isCheck = false;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
