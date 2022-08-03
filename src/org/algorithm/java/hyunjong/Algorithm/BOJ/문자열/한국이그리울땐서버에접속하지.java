package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[a-z]*은 소문자 중 하나를 선택하는게 그것이 0개 이상이다.
* 문자 등 특수문자를 문자 그대로 사용하기 위해서는 \\를 붙여줘야한다.
 */
public class 한국이그리울땐서버에접속하지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String reg = br.readLine();
		String regex = reg.replaceAll("\\*", "[a-z]*");
		StringBuilder sb = new StringBuilder();
		while(N-- > 0){
			String s = br.readLine();

			if(s.matches(regex)){
				sb.append("DA");
			}else{
				sb.append("NE");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
