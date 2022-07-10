package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> Q = new TreeMap<>();

			for(int i=0;i<N;i++){
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String type = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if(Objects.equals(type, "I")){
					Q.put(num, Q.getOrDefault(num,0)+1);
				}else{
					if(Q.isEmpty()) continue;
					if(num == -1){
						int min = Q.firstKey();
						if(Q.get(min) > 1){
							Q.put(min, Q.get(min)-1);
						}else{
							Q.remove(min);
						}
					}else{
						int max = Q.lastKey();
						if(Q.get(max) > 1){
							Q.put(max, Q.get(max)-1);
						}else{
							Q.remove(max);
						}
					}
				}

			}
			if(Q.isEmpty()){
				sb.append("EMPTY");
			}else{
				if(Q.size() == 1){
					Map.Entry<Integer,Integer> lastNum = Q.pollFirstEntry();
					sb.append(lastNum.getKey());
					sb.append(" ");
					sb.append(lastNum.getKey());
				}else{
					sb.append(Q.lastKey());
					sb.append(" ");
					sb.append(Q.firstKey());
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
