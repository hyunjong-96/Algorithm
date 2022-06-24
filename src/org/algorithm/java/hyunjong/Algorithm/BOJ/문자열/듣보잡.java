package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new LinkedHashSet<>();

		for(int i=0;i<N;i++){
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>();
		for(int i=0;i<M;i++){
			String see = br.readLine();

			if(set.contains(see)) list.add(see);
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size());
		sb.append("\n");
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
