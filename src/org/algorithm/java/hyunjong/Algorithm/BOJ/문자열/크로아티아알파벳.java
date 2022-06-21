package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();

		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (c == 'c' && i<word.length()-1) {
					char nextC = word.charAt(i + 1);

					if (nextC == '=' || nextC == '-')
						i++;
			} else if (c == 'd' && i < word.length() - 1) {
				char nextC = word.charAt(i + 1);
				if (nextC == '-')
					i++;
				else if (nextC == 'z' && i < word.length() - 2) {
					if (word.charAt(i + 2) == '=')
						i+=2;
				}
			} else if ((c == 'l' || c == 'n') && i < word.length() - 1) {
				if (word.charAt(i + 1) == 'j')
					i++;
			} else if ((c == 's' || c == 'z') && i < word.length() - 1) {
				if (word.charAt(i + 1) == '=')
					i++;
			}

			count++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
