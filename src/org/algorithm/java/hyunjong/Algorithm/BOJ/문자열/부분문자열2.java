package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
KMP를 써야하는가 생각했는데, parents배열을 선형탐색하면서 pattern index를 0부터 선언하고 동일한 값이 있다면 index를 한칸씩 증가시키면서
해당 index의 값이 존재하는지 확인만 하면된다.
O(N)으로 해결가능. 너무 어렵게 생각함.
 */
public class 부분문자열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = br.readLine()) != null) {

			StringTokenizer st = new StringTokenizer(str);

			String pattern = st.nextToken();
			String parents = st.nextToken();

			boolean flag = false;
			int index = 0;
			for(int i=0;i<parents.length();i++){
				if(parents.charAt(i) == pattern.charAt(index)){
					index++;
				}
				if(index == pattern.length()){
					flag = true;
					break;
				}
			}
			String result = flag ? "Yes" : "No";

			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
