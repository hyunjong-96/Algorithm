package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {

	static int[] human;
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = 100;
		int Y = 58;

		double rate = (((double)Y/X)*100);
		double rate2 = (((double)Y*100/X));

		System.out.println(rate);
		System.out.println(rate2);

		// int originRate = (int)(((double)Y/X)*100);
		// long start=0;
		// long end=2000000000;
		// while(start<end){
		// 	long mid = (start+end)/2;
		//
		// 	int rate = (int)(((double)(Y+mid)/(X+mid))*100);
		//
		// 	if(originRate != rate){
		// 		end = mid;
		// 	}else{
		// 		start = mid+1;
		// 	}
		// }

		// bw.write(String.valueOf(end));
		bw.flush();
		bw.close();
	}
}
