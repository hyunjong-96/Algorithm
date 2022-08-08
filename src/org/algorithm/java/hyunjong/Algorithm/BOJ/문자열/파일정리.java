package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/*
파일의 확장자를 구해 각 확장자의 개수를 구하기 위해 map을 사용하고 확장자를 사전순으로 나열하기 위해 key기준 오름차순 정렬하는 treemap사용
 */
public class 파일정리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Map<String, Integer> map = new TreeMap<>();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String s = br.readLine();
			String[] arr = s.split("\\.");

			String extension = arr[1];
			map.computeIfAbsent(extension, v -> 0);
			map.put(extension, map.get(extension) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for(String e : map.keySet()){
			sb.append(e).append(" ").append(map.get(e));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
