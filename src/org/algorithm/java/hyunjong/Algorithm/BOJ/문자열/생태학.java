package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

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

/*
HashMap을 이용해서 나무의 종이 map에 들어가있다면 value +1
없다면 해당 종의 value에 0을 넣어주고 1을 더해준다.
종의 사전 순으로 정렬한 후 각 나무의 갯수를 전체 나무의 갯수에 대한 백분위를 구해준다(4자리 - "%.4f")
 */
public class 생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();

		int total = 0;
		while (true) {
			String tree = br.readLine();
			if (tree == null || tree.equals("")) {
				break;
			}
			map.computeIfAbsent(tree, key -> 0);
			map.put(tree, map.get(tree) + 1);
			total++;
		}

		List<Map.Entry<String, Integer>> map_list = new ArrayList<>(map.entrySet());
		map_list.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		for (Map.Entry<String, Integer> entry : map_list) {
			double v = entry.getValue() * 100;
			double d = v / total;
			String sd = String.format("%.4f", d);
			sb.append(entry.getKey()).append(" ").append(sd).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
