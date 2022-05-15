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

		String[] arr = {"img12.png", "img10.png", "img2.png", "img1.png"};
		Arrays.sort(arr);
		for(String s : arr){
			System.out.println(s);
		}
		// System.out.println("png".compareTo("gif"));
		String test = "";
		System.out.println(test.substring(0).length()<1);
		// bw.write(sb.toString());
		// bw.flush();
		// bw.close();
		String s = arr[0].split("[0-9]")[0].toLowerCase();
	}
	class File implements Comparable<File>{
		String file;
		String head;
		int number;
		String tail;
		@Override
		public int compareTo(File o) {
			int result = this.head.compareToIgnoreCase(o.head);
			if(result == 0){
				result = this.number-o.number;
				if(result == 0){
					result = this.tail.compareToIgnoreCase(o.tail);
				}
			}
			return result;
		}
	}
}
