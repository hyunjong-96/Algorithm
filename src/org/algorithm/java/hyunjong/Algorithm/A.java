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

import java.io.*;
import java.util.StringTokenizer;
public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		long[] woods = new long[N];
		long maxLength = 0;
		for(int i=0;i<N;i++){
			woods[i] = Long.parseLong(st.nextToken());
			maxLength = Math.max(maxLength, woods[i]);
		}

		long start = 0;
		long end = maxLength;

		while(start<end){
			long mid = (start+end)/2;

			long totalLength = cutWood(woods, mid);

			if(totalLength >= M){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		bw.write(String.valueOf(end-1));
		bw.flush();
		bw.close();
	}

	static long cutWood(long[] woods, long mid){
		long total = 0;
		for(int i=0;i<woods.length;i++){
			if(woods[i] >= mid){
				total += woods[i]-mid;
			}
		}
		return total;
	}
}