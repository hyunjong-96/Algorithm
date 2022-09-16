package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class A {
	static int[][] beginning;
	static int[][] target;
	static int answer;

	static class Genre implements Comparable<Genre>{
		String genre;
		int totalPlay;
		public Genre(String genre, int play){
			this.genre = genre;
			this.totalPlay = play;
		}

		@Override
		public int compareTo(Genre o) {
			return o.totalPlay - this.totalPlay;
		}
	}

	public static void main(String[] args) throws Exception {
		String s = "8a   b ";
		String[] arr = s.split(" ");
		for(String a : arr){
			System.out.println(a.toUpperCase().trim());
		}


		// Map<Genre, PriorityQueue<Integer>> map = new TreeMap<>();
		// map.put(new Genre("classic", 1450), new PriorityQueue<>());
		// map.put(new Genre("jazz", 1000), new PriorityQueue<>());
		// map.put(new Genre("pop", 5000), new PriorityQueue<>());
		// Deque<Integer> dq = new LinkedList<>();
		// dq.offer(5);
		// dq.offer(10);
		//
		// while(!dq.isEmpty()){
		// 	System.out.println(dq.poll());
		// }

		// PriorityQueue<Integer> pq = new PriorityQueue<>();
		// pq.remove(1);
		// for(Genre g : map.keySet()){
		// 	System.out.println(g.genre);
		// }

		// int size = pq.size();
		// for(int i=0;i<size;i++){
		// 	System.out.println(pq.poll().totalPlay);
		// }
		// for(Genre g : pq){
		// 	System.out.println(g.totalPlay);
		// }

		// list.add(1);
		// list.add(2);
		// list.add(3);
		//
		//
		// Queue<Integer> queue = new LinkedList<>();
		// Set<Integer> set = new HashSet<>();
		// LinkedList<Integer> ll = new LinkedList<>();
		//
		//
		// PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		// List<Integer> list2 = list.stream().map(n -> n + 1).collect(Collectors.toList());
		// for (int l : list) {
		// 	System.out.println(l);
		// }
		//
		// for (int l : list2) {
		// 	System.out.println(l);
		// }
	}
}