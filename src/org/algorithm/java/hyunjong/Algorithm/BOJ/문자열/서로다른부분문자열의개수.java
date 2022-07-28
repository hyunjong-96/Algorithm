package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();

		set = new HashSet<>();

		for (int i = 0; i < S.length(); i++) {
			// setString(S, "", i);
			for(int j=i;j<S.length();j++){
				String s = S.substring(i,j+1);
				set.add(s);
			}
		}

		bw.write(String.valueOf(set.size()));
		bw.flush();
		bw.close();
	}

	static void setString(String S, String s, int index) {
		if (index == S.length()) {
			return;
		}

		String partString = s + S.charAt(index);
		set.add(partString);
		setString(S, partString, index + 1);
	}
}
