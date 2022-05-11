package org.algorithm.java.hyunjong.Algorithm.BOJ.비트마스킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// HashSet<Integer> set = new HashSet<>();
		int check = 0;
		while(M-- > 0){
			String[] sa = br.readLine().split(" ");
			String method = sa[0];
			int num;

			switch (method){
				case "add":
					num = Integer.parseInt(sa[1]);
					// if(set.size()<20){
					// 	set.add(num);
					// }
					check |= 1<<num;
					break;
				case "remove":
					num = Integer.parseInt(sa[1]);
					// set.remove(num);
					check &= ~(1<<num);
					break;
				case "check":
					num = Integer.parseInt(sa[1]);
					// sb.append(set.contains(num) ? 1 : 0);
					// sb.append("\n");
					sb.append((check & 1<<num)!=0 ? 1 : 0);
					sb.append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(sa[1]);
					// if(set.contains(num)){
					// 	set.remove(num);
					// }else{
					// 	set.add(num);
					// }
					if((check & 1<<num) != 0){
						check &= ~1<<num;
					}else{
						check |= 1<<num;
					}
					break;
				case "all":
					// set = new HashSet<>();
					// for(int i=1;i<=20;i++){
					// 	set.add(i);
					// }
					check = (1<<21)-1;
					break;
				case "empty":
					// set = new HashSet<>();
					check = 0;
					break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
