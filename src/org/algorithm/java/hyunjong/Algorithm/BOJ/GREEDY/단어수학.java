package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
각 알파벳이 가지고 있는 자릿수의 합이 클 수록 높은 숫자를 가져야한다.
ex) ABAB, CCCC가 주어졌을때 10^3(A+C) + 10^2(B+C) + 10(A+C) + (B+C)의 식이 된다
이를 변형하면 A(10^3 + 10) + B(10^2 + 1) + C(10^3 + 10^2 + 10 + 1)이 되므로 자릿수의 합은 C>A>B가 된다.
그러므로 C = 9, B = 8, C = 7의 숫자를 주어져 계산하면 되는것이다.

각 알파벳 문자를 받았을때 역행으로 저장을 해준다, 이렇게 하면 나중에 계산하기 편해진다.
역행으로 저장된 알파벳 문자를 길이에 따른 내림차순으로 정렬 해준 후
알파벳 문자의 길이가 가장 긴 문자의 자릿수부터 map을 통해 해당 자릿수의 알파벳에 자릿수를 더해준다.
그렇게 되면 A = 1010, B = 101, C = 1111 이 map에 저장되게 될것이다.

그 후 각 알파벳의 자릿수 합에 대해 내림차순으로 변경후 변경할수 있는 수 중 가장 큰 값인 9부터 곱해준다음
그 결과값을 모두 더해주면 알파벳을 숫자로 변경했을때 나올수 있는 가장 큰 값이 나오게 된다.
 */
public class 단어수학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] problem = new String[N];

		//각 알파벳 문자를 받을때 역전하여 저장한다.(핵심)
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			problem[i] = sb.reverse().toString();
		}

		//알파벳 문자의 길이에 따른 내림차순 정렬
		Arrays.sort(problem, (p1, p2) -> p2.length() - p1.length());

		Map<Character, Integer> alphabet = new HashMap<>();

		//i : 자릿수, j : 각 알파벳 문자
		for (int i = problem[0].length() - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				//알파벳 문자의 길이가 현재 자릿수보다 작다면 IndexOutBound가 발생하므로 넘어감
				if (i > problem[j].length()-1) {
					break;
				}

				//알파벳 문자 중 i 자릿수에 해당하는 알파벳에 자릿수를 더해 저장한다.(i에 10을 거듭제곱하면 자릿수가 만들어진다)(핵심)
				char a = problem[j].charAt(i);
				if (alphabet.containsKey(a)) {
					alphabet.put(a, alphabet.get(a) + (int)Math.pow(10, i));
				} else {
					alphabet.put(a, (int)Math.pow(10, i));
				}
			}
		}

		//list에 각 알파벳 자릿값의 총합을 각각 저장한 후 자릿값의 총합에 대해 내림차순
		Iterator<Character> iterator = alphabet.keySet().iterator();
		List<Integer> list = new ArrayList<>();

		while (iterator.hasNext()) {
			list.add(alphabet.get(iterator.next()));
		}

		list.sort((l1, l2) -> l2 - l1);

		//내림차순된 자릿값의 총합에 대해 변경가능한 큰 값인 9부터 변경해가며 result를 계산해간다.
		int num = 9;
		int result = 0;
		for (Integer integer : list) {
			result += integer * num--;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
