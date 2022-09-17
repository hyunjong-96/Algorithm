package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[] : 안에 있는 문자중 1개
? : 앞의 문자가 0또는 1개
+ : 앞의 문자가 1개이상
$ : 앞의 문자로 끝나는 패턴
 */
public class 염색체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			String pattern = br.readLine();
			if(pattern.matches("[ABCDEF]?A+F+C+[ABCDEF]?$")){
				sb.append("Infected!");
			}else{
				sb.append("Good");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
