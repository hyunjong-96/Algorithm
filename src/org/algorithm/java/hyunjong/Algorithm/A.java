package org.algorithm.java.hyunjong.Algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A {

	public static void main(String[] args) throws IOException {
		LinkedList<Number> test = new LinkedList<>();
		test.add(new Number(1));
		test.add(new Number(2));

		LinkedList<Number> test2 = new LinkedList<>();
		test2 = (LinkedList<Number>)test.clone();
		test2.get(0).num = 10;

		for(Number n : test){
			System.out.println(n.num);
		}
		for(Number n : test2){
			System.out.println(n.num);
		}
	}
	static class Number{
		int num;
		public Number(int num){
			this.num = num;
		}
	}
}
