package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class A {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for(int i=0;i<N;i++){
			StringBuilder sb = new StringBuilder(br.readLine());
			sb.reverse();
			String[] word = sb.toString().split("");
			for(int j=0;j<word.length;j++){
				map.put(word[j],map.getOrDefault(word[j],0)+(int)Math.pow(10,j));
			}
		}

		List<Integer> valueList = new ArrayList<>(map.values());
		Collections.sort(valueList, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				return o2-o1;
			}
		});

		int v = 9;
		int sum = 0;
		for(int value : valueList){
			sum += value*v;
			v--;
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
