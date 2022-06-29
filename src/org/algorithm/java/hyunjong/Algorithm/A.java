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

	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = 1999999999;
		int Y = 1979999999;
		System.out.println((int)(((long)Y*100)/X));
		int origin = (int)(((long)Y*100)/X);

		int i=0;
		int count=0;
		while(true){

			int rate = (int)(((long)(Y+i)*100)/(X+i));
			if(origin != rate){
				System.out.println(count);
				break;
			}
			i++;
			count++;
		}

		// bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}


}
