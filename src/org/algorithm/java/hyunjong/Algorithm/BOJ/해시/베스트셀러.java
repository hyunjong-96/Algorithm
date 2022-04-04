package org.algorithm.java.hyunjong.Algorithm.BOJ.해시;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트셀러 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String book = br.readLine();
			if (book == null || book.equals(""))
				break;

			map.computeIfAbsent(book, k -> 0);
			map.put(book, map.get(book)+1);
		}

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if(o1.getValue() < o2.getValue()) return 1;
				else if(o1.getValue().equals(o2.getValue())){
					return o1.getKey().compareTo(o2.getKey());
				}
				return -1;
			}
		});
		bw.write(String.valueOf(entryList.get(0).getKey()));
		bw.flush();
		bw.close();
	}
}
