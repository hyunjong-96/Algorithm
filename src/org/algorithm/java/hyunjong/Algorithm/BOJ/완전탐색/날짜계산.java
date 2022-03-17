package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 빠른 년도를 출력하는 것이기 때문에 while문을 통해 날짜를 카운트하면서 year를 늘려준다
//while문 하나만 사용하기 때문에 O(n)이므로 10,000,000개 까지는 처리 가능해서 사용
public class 날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 1;
		int s = 1;
		int m = 1;
		int year = 1;
		while (e != E || m != M || s != S) {
			e++;
			s++;
			m++;
			year++;

			if (e == 16)
				e = 1;
			if (s == 29)
				s = 1;
			if (m == 20)
				m = 1;
		}
		bw.write(String.valueOf(year));
		bw.flush();
		bw.close();
	}
}
