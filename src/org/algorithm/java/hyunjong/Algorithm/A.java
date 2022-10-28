package org.algorithm.java.hyunjong.Algorithm;

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
	static AtomicInteger integer = new AtomicInteger(0);
	static int integer1 = 0;
	public static void main(String[] args) throws Exception {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.remove();
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
	}

	static void printCollection(Collection<? super MyParent> c){
		for(Object p : c){
			System.out.println(p);
		}
	}

	static void setCollection(Collection<? super MyParent> c){
		c.add(new MyChild(1));
		c.add(new MyParent(2));
	}

	static class MyGrandParent{
		public int id;
		public MyGrandParent(int id){
			this.id = id;
		}
	}
	static class MyParent extends MyGrandParent{
		public int id;
		public MyParent(int id) {
			super(id);
			this.id = id;
		}
	}

	static class MyChild extends MyParent{
		public int id;
		public MyChild(int id) {
			super(id);
			this.id = id;
		}
	}
}