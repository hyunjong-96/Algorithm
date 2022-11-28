package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			int K = Integer.parseInt(br.readLine());

			TreeMap<Integer,Integer> map = new TreeMap<>();
			for(int i=0;i<K;i++){
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String method = st.nextToken();

				switch (method){
					case "I":
						int n = Integer.parseInt(st.nextToken());
						map.put(n, map.getOrDefault(n,0)+1);
						break;
					case "D":
						int type = Integer.parseInt(st.nextToken());
						if(map.isEmpty()) continue;
						if(type == 1){
							int maxKey = map.lastKey();
							if(map.get(maxKey)<=1) map.remove(maxKey);
							else map.put(maxKey, map.get(maxKey)-1);
						}else{
							int minKey = map.firstKey();
							if(map.get(minKey)<=1) map.remove(minKey);
							else map.put(minKey, map.get(minKey)-1);
						}
						break;
				}
			}

			if(map.isEmpty()) sb.append("EMPTY");
			else sb.append(map.lastKey()).append(" ").append(map.firstKey());
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}