package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 나는친구가적다Large {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String book = br.readLine();
		String keyword = br.readLine();

		book = book.replaceAll("[0-9]","");
		keyword = "(.*)"+keyword+"(.*)";
		String result = book.matches(keyword) ? "1" : "0";
		// String result = book.contains(keyword) ? "1" : "0";
		bw.write(result);
		bw.flush();
	}
}
