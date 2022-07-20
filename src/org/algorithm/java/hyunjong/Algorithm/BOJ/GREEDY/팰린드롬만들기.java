package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//name의 길이가 짝수일 때 주어진 단어가 모두 짝수여야하고 name의 길이가 홀수 일 때 주어진 단어 중 하나만이 홀수여야한다(중앙에 해당 단어 배치)
//모든 단어를 (단어의 개수/2) 개 씩 배치하고 홀수 단어가 있다면 해당 단어를 삽입하고 reverse된 단어를 합쳐서 팰린드롬을 완성한다.
public class 팰린드롬만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String name = br.readLine();
		int[] arr = new int['Z' - 'A'+1];

		for (int i = 0; i < name.length(); i++) {
			char n = name.charAt(i);
			arr[n - 'A']++;
		}

		int midIdx = 0;
		int oddCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				midIdx = i;
				oddCount++;
			}
		}

		StringBuilder sb = new StringBuilder();

		if ((name.length() % 2 == 0 && oddCount > 0) || (name.length() % 2 != 0 && oddCount > 1)) {
			sb.append("I'm Sorry Hansoo");
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					for (int j = 0; j < arr[i] / 2; j++) {
						sb.append((char)(i + 'A'));
					}
				}
			}

			String reverse = sb.reverse().toString();
			sb.reverse();
			if (oddCount == 1)
				sb.append((char)(midIdx + 'A'));
			sb.append(reverse);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
