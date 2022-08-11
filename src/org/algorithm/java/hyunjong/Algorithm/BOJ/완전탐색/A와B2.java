package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A와B2 {
	static boolean isSuccess;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		String T = br.readLine();
		isSuccess = false;
		setString(S, T);
		int answer = isSuccess ? 1 : 0;
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setString(String S, String temp) {
		if (temp.length() == S.length()) {
			if (temp.equals(S))
				isSuccess = true;
			return;
		}

		if(temp.charAt(0) == 'B'){
			StringBuilder sb = new StringBuilder(temp);
			sb.reverse();
			String t = sb.toString();
			t = t.substring(0, t.length()-1);
			setString(S, t);
		}
		if(temp.charAt(temp.length()-1)=='A'){
			String t = temp.substring(0, temp.length()-1);
			setString(S, t);
		}
	}
}
