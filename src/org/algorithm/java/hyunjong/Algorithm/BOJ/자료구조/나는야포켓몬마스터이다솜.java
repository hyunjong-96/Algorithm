package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> idMap = new HashMap<>();
		Map<Integer, String> nameMap = new HashMap<>();

		int idx=1;
		for(int i=0;i<N;i++){
			String name = br.readLine();

			if(!idMap.containsKey(name)){
				idMap.put(name,idx++);
			}
			int id = idMap.get(name);
			nameMap.computeIfAbsent(id, v -> name);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			String result = br.readLine();
			if(result.charAt(0)>='A' && result.charAt(0)<='Z'){
				sb.append(idMap.get(result));
			}else{
				int numResult = Integer.parseInt(result);
				sb.append(nameMap.get(numResult));
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
