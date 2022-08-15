package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
8진수의 길이가 333,334을 넘기때문에 최대 10^333334의 8진수를 받게된다.
이는 long으로도 받을수 없는 수이기 때문에 8진수의 각 자리를 배열에 저장하고 0~8까지의 8진수를 이진수로 변경한 것을 저장한다.
그리고 맨 앞에서 0인것을 빼준다.
8진수가 0이라면 0으로 반환해준다.
 */
public class 진수8진수2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] octArr = {"000", "001", "010", "011", "100", "101", "110", "111"};

		StringBuilder sb = new StringBuilder();
		String[] octSArr = br.readLine().split("");
		for (int i = 0; i < octSArr.length; i++) {
			int oct = Integer.parseInt(octSArr[i]);
			sb.append(octArr[oct]);
		}

		String stringb = sb.toString();
		if (octSArr[0].equals("0"))
			stringb = "0";
		else {
			int idx = 0;
			while (stringb.charAt(idx) != '1') {
				idx++;
			}

			stringb = stringb.substring(idx);
		}
		bw.write(stringb);

		bw.flush();
		bw.close();
	}
}
