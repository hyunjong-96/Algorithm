package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String test = "muzi!muzi!muzi1muzi";
		// test = test.replaceAll("[0-9]"," ");
		Pattern pattern = Pattern.compile("\\b"+"muzi"+"\\b");
		Matcher matcher = pattern.matcher(test);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		// bw.write(sb.toString());
		// bw.flush();
		// bw.close();
	}
}
