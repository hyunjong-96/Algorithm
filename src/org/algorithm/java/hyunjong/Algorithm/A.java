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

		int[][] arr = {{1,1,1},{2,2,2},{3,3,3}};
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int t =0;t<3;t++){
			for(int i=0;i<3;i++){
				map.put(arr[t][i], map.getOrDefault(arr[t][i],0)+1);
			}
		}

		for(int key : map.keySet()){
			System.out.println(map.get(key));
		}
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
