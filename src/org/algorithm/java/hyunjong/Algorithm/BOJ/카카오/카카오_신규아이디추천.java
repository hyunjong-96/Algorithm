package org.algorithm.java.hyunjong.Algorithm.BOJ.카카오;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Locale;

public class 카카오_신규아이디추천 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String new_id = br.readLine();
		String ans = solution(new_id);
		bw.write(ans);
		bw.flush();
		bw.close();
	}

	static String solution(String new_id) {
		//소문자 치환
		new_id = new_id.toLowerCase(Locale.ROOT);
		//- _ . 제외 제거
		StringBuilder sb = new StringBuilder();
		for (char c : new_id.toCharArray()) {
			if ((c >= 'a' && c <= 'z') || c == '-' || c == '_' || c == '.' || (c >= '0' && c <= '9'))
				sb.append(c);
		}
		new_id = sb.toString();
		//연속 . 하나로
		for (int i = 0; i < new_id.length() - 1; i++) {
			if (new_id.charAt(i) == '.' && new_id.charAt(i + 1) == '.') {
				sb = new StringBuilder(".");
				int j = i + 1;

				while (j < new_id.length() && new_id.charAt(j) == '.') {
					sb.append('.');
					j++;
				}

				if (sb.length() > 1) {
					new_id = new_id.replace(sb.toString(), ".");
				}
			}
		}
		//처음, 끝의 . 제거
		if (new_id.startsWith(".")) {
			new_id = new_id.substring(1);
		}
		if(new_id.endsWith(".")){
			new_id = new_id.substring(0, new_id.length()-1);
		}
		//빈 문자열 'a' 치환
		if (new_id.length() < 1)
			new_id = "a";
		//16글자 이상이면 15까지, 마지막이 .이라면 .제거
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, 14);
		}
		//2글자 이하면 3이 될때까지
		if (new_id.length() <= 2) {
			sb = new StringBuilder(new_id);
			while (!(sb.length() == 3)) {
				sb.append(new_id.charAt(new_id.length() - 1));
			}
			new_id = sb.toString();
		}

		return new_id;
	}
}
