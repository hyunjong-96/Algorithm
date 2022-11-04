package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class A {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String compare = br.readLine();
		String target = br.readLine();

		boolean isContain = KMP(compare, target);

		int result = isContain ? 1 : 0;

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static boolean KMP(String compare, String target){
		int[] table = makeTable(target);

		int compareSize = compare.length();
		int targetSize = target.length();
		int j=0;

		for(int i=0;i<compareSize;i++){
			while(j>0 && target.charAt(j) != compare.charAt(i)){
				j = table[j-1];
			}

			if(target.charAt(j) == compare.charAt(i)){
				if(j == targetSize-1) return true;
				j++;
			}
		}
		return false;
	}

	static int[] makeTable(String target){
		int targetSize = target.length();
		int[] table = new int[targetSize];

		int j = 0;
		for(int i=1;i<targetSize;i++){
			while(j>0 && target.charAt(j) != target.charAt(i)){
				j = table[j-1];
			}

			if(target.charAt(j) == target.charAt(i)){
				table[i] = ++j;
			}
		}

		return table;
	}
}