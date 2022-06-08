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

		Shark[][] map = new Shark[4][4];
		map[0][1] = new Shark();

		System.out.println(map[0][0]);
		System.out.println(map[0][1]);

		if(map[0][0] == null){
			System.out.println("yes");
		}
	}

	static class Shark{
		int num;
		int smell;
	}

}
