package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String parents = br.readLine();
		String pattern = br.readLine();
		boolean isMatch = KMP(parents, pattern);
		int result = isMatch ? 1 : 0;

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static boolean KMP(String parents, String pattern) {
		int[] table = makeTable(pattern);

		int parentsSize = parents.length();
		int patternSize = pattern.length();

		boolean flag = false;

		int j = 0;
		for (int i = 0; i < parentsSize; i++) {
			while(j>0 && parents.charAt(i) != pattern.charAt(j)){
				j = table[j-1];
			}

			if(parents.charAt(i) == pattern.charAt(j)){
				if(j == patternSize-1) {
					// j = table[j]; //?
					flag = true;
					break;
				}
				else j++;
			}
		}

		return flag;
	}

	static int[] makeTable(String pattern) {
		int patternSize = pattern.length();
		int[] table = new int[patternSize];

		int j = 0;
		for (int i = 1; i < patternSize; i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = table[j - 1];
			}
			if (pattern.charAt(j) == pattern.charAt(i)) {
				table[i] = ++j;
			}
		}

		return table;
	}
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 	String parents = st.nextToken();
	// 	String pattern = st.nextToken();
	//
	// 	KMP(parents, pattern);
	//
	// }
	//
	// static void KMP(String parents, String pattern){
	// 	int[] table = makeTable(pattern);
	// 	System.out.println("이전 KMP 테이블 : "+Arrays.toString(table));
	//
	//
	// 	int parentsSize = parents.length();
	// 	int patternSize = pattern.length();
	// 	int j = 0;
	//
	// 	for(int i=0;i<parentsSize;i++){
	// 		while(j>0 && parents.charAt(i) != pattern.charAt(j)){
	// 			j = table[j-1];
	// 		}
	//
	// 		if(parents.charAt(i) == pattern.charAt(j)){
	// 			if(j == patternSize-1){
	// 				System.out.println(i-patternSize+2+ " 번째에서 찾았습니다.");
	// 				j = table[j];
	// 			}else{
	// 				j++;
	// 			}
	// 		}
	// 	}
	//
	// 	System.out.println("이후 KMP 테이블 : "+Arrays.toString(table));
	// }
	//
	// static int[] makeTable(String pattern){
	// 	int patternSize = pattern.length();
	// 	int[] table = new int[patternSize];
	//
	// 	int j = 0;
	// 	for(int i=1;i<patternSize;i++){
	// 		while(j>0 && pattern.charAt(j) != pattern.charAt(i)){
	// 			j = table[j-1];
	// 		}
	//
	// 		if(pattern.charAt(j) == pattern.charAt(i)){
	// 			table[i] = ++j;
	// 		}
	// 	}
	// 	return table;
	// }
}
