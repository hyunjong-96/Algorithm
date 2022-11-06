package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class A{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];
			for(int i=0;i<n;i++){
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			int sum = 0;
			for(int i=nums.length-1;i>0;i--){
				for(int j=i-1;j>=0;j--){
					sum += gcd(nums[i],nums[j]);
				}
			}
			sb.append(sum).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int gcd(int a, int b){
		while(b!=0){
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
		// if(b==0) return a;
		// if(a%b==0) return b;
		// return gcd(b,a%b);
	}
}