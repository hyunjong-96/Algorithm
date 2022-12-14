package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class 회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<String, Boolean> map = new TreeMap<>(Comparator.reverseOrder());
		for(int i=0;i<N;i++){
			String[] log = br.readLine().split(" ");

			if(log[1].equals("enter")){
				map.put(log[0],true);
			}else{
				map.remove(log[0]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(String in : map.keySet()){
			sb.append(in).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
